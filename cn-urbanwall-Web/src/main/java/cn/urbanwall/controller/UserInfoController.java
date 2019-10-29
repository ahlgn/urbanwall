package cn.urbanwall.controller;

import cn.urbanwall.model.TbUser;
import cn.urbanwall.model.TbUserbase;
import cn.urbanwall.quervo.PicturePath;
import cn.urbanwall.serviceImpl.UserServiceImpl;
import cn.urbanwall.utils.FileUploadUtils;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
@RestController
@RequestMapping(value = "/userinfo")
@Api(value = "用户信息操作接口",tags = "用户信息操作接口")
//解决跨域的问题
@CrossOrigin
public class UserInfoController {

    //上传文件路径
    @Value("${application.profileicon}")
    private String UPLOAD_ICON;
    //基于slf4j日志
    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    @Autowired
    private UserServiceImpl userService;

    //显示用户信息
    @ApiOperation(value = "显示用户的信息", notes = "只需传递username")
    @ApiImplicitParam(name = "username", required = true, dataType = "String")
    @RequestMapping(value = "/showuserinfo/{username}" ,method = RequestMethod.GET)
    public TbUserbase showUserinfo(@PathVariable String username) {
        TbUserbase tbUserbase = userService.selectUser(username);
        logger.info("用户的相关的其他信息:" + tbUserbase.toString());
        return tbUserbase;
    }


    //更新用户的信息只跟新
    @ApiOperation(value = "更新用户信息", notes = "需要传递userBirthday,userPhone,userEmail")
    @ApiImplicitParam(name = "tbUserbase", value = "用户信息更改", required = true, dataType = "TbUserbase")
    @RequestMapping(value = "/updateuserinfo", method = RequestMethod.POST)
    public Object updateTbUserbase(@RequestBody TbUserbase tbUserbase) {
        Integer status = userService.updateUserbase(tbUserbase);
        return "success";
    }


    //修改头像
    @RequestMapping(value = "/uploadicon", method = RequestMethod.POST)
    public String uploadFace(@RequestParam("faceicon") MultipartFile faceicon, @RequestParam("username") String username) {

        if (faceicon.equals(null)) {
            return "erro";
        }
        //头像开始上传
        String faceIcnName = null;
        try {
            //向数据库中修改头像
            faceIcnName = FileUploadUtils.uploadPicture(faceicon, UPLOAD_ICON);
            logger.info("头像名是：" + faceIcnName);
            TbUserbase tbUserbase = userService.selectUser(username);
            tbUserbase.setUsericon(faceIcnName);
            userService.updateUserbase(tbUserbase);
        } catch (IOException e) {
            e.printStackTrace();
            return "upload fail";
        }
        return "success";
    }
}
