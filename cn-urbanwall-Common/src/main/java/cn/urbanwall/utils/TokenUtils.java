package cn.urbanwall.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

public class TokenUtils {
    public static String getTokenUsername(HttpServletRequest request){
        String token = request.getHeader("token");
        Claims claims = Jwts.parser().setSigningKey("token").parseClaimsJws(token).getBody();
        String username=(String)claims.get("username");
        System.out.println("解析token里用户名为"+username);
        return username;
    }
}
