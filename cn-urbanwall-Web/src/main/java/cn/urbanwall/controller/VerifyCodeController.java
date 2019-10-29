package cn.urbanwall.controller;

import cn.urbanwall.quervo.ImgResult;
import cn.urbanwall.utils.IDUtils;
import cn.urbanwall.utils.RedisUtils;
import cn.urbanwall.utils.VerifyCodeUtils;
import io.swagger.annotations.*;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value="/code")
@Api(value="获取验证码",tags = "获取验证码接口")
public class VerifyCodeController {

    @Autowired
    private RedisUtils redisUtils;
    /**
     * 获得验证码
     * @throws IOException
     */

    @ApiOperation(value = "获取验证码图片")
    @ApiResponse(code=200,message="获取图片验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(value="图片宽度",name="width",defaultValue = "120"),
            @ApiImplicitParam(value="图片高度",name="height",defaultValue = "40")
    })
    @RequestMapping(value="/getCode",method= RequestMethod.GET)
    public ImgResult codeImage(@RequestParam(defaultValue = "120") int width,
                               @RequestParam(defaultValue = "40") int height) throws IOException {
        ImgResult rs = VerifyCodeUtils.VerifyCode(width, height, 4);
        System.out.println(rs.getImg());
        return rs;
    }
}
