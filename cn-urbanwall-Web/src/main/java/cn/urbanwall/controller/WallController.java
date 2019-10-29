package cn.urbanwall.controller;

import cn.urbanwall.model.TbWaller;
import cn.urbanwall.quervo.PicturePath;
import cn.urbanwall.quervo.WallPages;
import cn.urbanwall.quervo.WallView;
import cn.urbanwall.serviceImpl.WallServiceImpl;
import cn.urbanwall.utils.FileUploadUtils;
import cn.urbanwall.utils.TokenUtils;
import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/wall")
@Api(value="留言墙操作接口",tags = "留言墙操作接口")
public class WallController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private WallServiceImpl wallService;
    //上传文件路径
    @Value("${application.profile}")
    private String UPLOAD_FOLDER;

    /**
     * 发送留言
     * @param waller
     * @throws IOException
     */
    @ApiOperation(value = "发送留言")
    @PostMapping("/sendwaller")
    public void sendWall(@RequestBody
                             @ApiParam(name="留言信息",value="传入json格式",required=true)
                                     TbWaller waller,HttpServletRequest request) throws IOException {
        jmsTemplate.send("wallMessage", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(waller);
                return message;
            }
        });
    }

    @ApiOperation(value = "删除留言")
    @GetMapping("/deletewall{id}")
    public void deletewall(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
        //拿到请求头token里的用户名
        String username = TokenUtils.getTokenUsername(request);
        //校验这条消息是否为该用户所发
        boolean b = wallService.contrastIdAndUsername(id, username);
        if(b){
            boolean b1 = wallService.deleteWallById(id);
            response.setStatus(b1?200:201);
        }else{
            response.setStatus(201);
        }

    }
    /**
     * 显示该学校最新留言
     * @return
     */
    @ApiOperation(value = "显示该学校最新留言",notes = "例: pageNo=1,PageSize=10,school='蚌埠学院' " +
            "第pageNo页 显示PageSize条 蚌埠学院的消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "school", value = "学校", required = true, dataType = "String")
    })
    @PostMapping("/newwall")
    public List<WallView> showNewWall(@RequestBody WallPages pages){
        System.out.println(pages.getPageNo()+"."+pages.getPageSize()+pages.getSchool());
        List<WallView> wallViews = wallService.selectWallBySchool(pages.getSchool(),
                pages.getPageSize(),
                pages.getPageNo());
        for (WallView  t: wallViews) {
            System.out.println(t.toString());
        }
        return wallViews;
    }


    /**
     * 上传图片
     * @param
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadpicture")
    @ApiImplicitParam(name="上传图片",value = "图片",required = true)
    public PicturePath uploadPicture(@RequestParam("picture") MultipartFile picture) throws IOException {
        PicturePath path = new PicturePath();
        String pathurl="";
        path.setPath(pathurl);
        if(picture.equals(null)){
            System.out.println("上传空文件");

            return path;
        }
        System.out.println("开始上传文件了");
        String picpath = FileUploadUtils.uploadPicture(picture, UPLOAD_FOLDER);
        System.out.println(picpath);
        if(pathurl.equals("")){
            pathurl=picpath;
        }else{
            pathurl=pathurl+"#"+picpath;
        }
        System.out.println(pathurl);
        path.setPath(pathurl);
        return path;
    }


}
