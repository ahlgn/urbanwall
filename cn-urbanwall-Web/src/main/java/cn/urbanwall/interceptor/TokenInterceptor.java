package cn.urbanwall.interceptor;

import cn.urbanwall.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;


public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtils redisUtils;

    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
//        if(arg0.getMethod().equals(RequestMethod.OPTIONS.name())){
//            arg1.setStatus(200);
//            return true;
//        }
//        arg1.setHeader("Access-Control-Allow-Origin", "*");
//        arg1.setHeader("Access-Control-Allow-Methods", "*");
//        arg1.setHeader("Access-Control-Max-Age", "3600");
//        arg1.setHeader("Access-Control-Allow-Headers", "*");
//        if (arg0.getMethod().equals(RequestMethod.OPTIONS.name())) {
//            arg1.setStatus(HttpServletResponse.SC_OK);
//            System.out.println(arg0.getHeader("Token"));
//            return false;
//        }

        //普通路径放行
        if ("/user/register".equals(arg0.getRequestURI()) || "/user/login".equals(arg0.getRequestURI())||"/code/getImage".equals(arg0.getRequestURI())) {
            return true;}

        //权限路径拦截
        arg1.setCharacterEncoding("UTF-8");
        final String headerToken=arg0.getHeader("token");
        System.out.println(headerToken);
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")){
            arg1.setStatus(701);
            arg1.setHeader("Token",headerToken);
            return false;
        }
        //解析Token信息
        try {
            Claims claims = Jwts.parser().setSigningKey("token").parseClaimsJws(headerToken).getBody();
            String tokenUsername=(String)claims.get("username");
            //根据客户Token查找数据库Token
//            Token myToken=TokenMapper.findByUserId(itokenUserId );
            if(redisUtils.getExpire(tokenUsername)<=0){
                arg1.setStatus(702);
                return false;
            }
            Map<Object, Object> hmget = redisUtils.hmget(tokenUsername);
            if(!(hmget.get("username").equals(tokenUsername)) || !(hmget.get("token").equals(headerToken))){
                arg1.setStatus(703);
                return false;
            }
            //判断Token过期
            Date tokenDate=(Date)claims.getExpiration();
            int overtime=(int)(new Date().getTime()-tokenDate.getTime())/1000;
            if(overtime>60*60*24*7){
                arg1.setStatus(704);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            arg1.setStatus(705);
            return false;
        }
        //最后才放行
        return true;
    }

}


