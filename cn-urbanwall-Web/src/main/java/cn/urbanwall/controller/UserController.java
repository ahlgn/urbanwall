package cn.urbanwall.controller;

import cn.urbanwall.model.TbUser;
import cn.urbanwall.model.TbUserbase;
import cn.urbanwall.quervo.UserToken;
import cn.urbanwall.service.UserService;
import cn.urbanwall.serviceImpl.TestProducer;
import cn.urbanwall.serviceImpl.TokenServiceImpl;
import cn.urbanwall.serviceImpl.UserServiceImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.*;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping("/user")
@Api(value="用户操作接口",tags = "用户操作接口")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private TestProducer producer;

    @ApiOperation(value = "注册新用户",notes = "只需传递username,password")
    @ApiImplicitParam(name="user",value = "用户注册信息",required = true,dataType = "TbUser")
    @PostMapping("/register")
    public void registerUser(@RequestBody TbUser user){
        Integer status = userService.register(user);
        if(1==status){

        }else if(0==status){

        }else{

        }
    }

    @ApiOperation(value = "用户登录",notes = "只需要传递username,password")
    @ApiImplicitParam(name="user",value = "用户登录信息",required = true,dataType = "TbUser")
    @ApiResponses({
            @ApiResponse(code=200,message = "返回username以及Token"),
            @ApiResponse(code =400,message = "请求参数没填好"),
            @ApiResponse(code =404,message = "请求路径没有")
    })
    @PostMapping("/login")
    public UserToken loginUser(@RequestBody TbUser user){
        Integer status = userService.login(user);
        if(1==status){
            String token = tokenService.generateToken(user);
            UserToken userToken = new UserToken();
            userToken.setUsername(user.getUsername());
            userToken.setToken(token);
            return tokenService.saveToken(userToken)?userToken:null;
        }else if(0==status){
            return null;
        }else{
            return null;
        }
    }

    @ApiOperation(value="查询用户信息",notes = "传递用户名")
    @ApiImplicitParam(name="username",value = "用户名",required = true,dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(code = 200, message = "返回用户信息"),
            @ApiResponse(code = 701, message = "请求头为空"),
            @ApiResponse(code = 702, message = "缓存过期"),
            @ApiResponse(code = 703, message = "token无效"),
            @ApiResponse(code = 704, message = "token过期"),
            @ApiResponse(code = 705, message = "解析token异常")
    })
    @GetMapping("/username=={username}")
    public TbUserbase searchUser(@PathVariable String username, HttpServletRequest request){
        TbUserbase userbase = userService.selectUser(username);
        return userbase;
    }

}
