package cn.urbanwall.serviceImpl;

import cn.urbanwall.model.TbUser;
import cn.urbanwall.quervo.UserToken;
import cn.urbanwall.service.TokenService;
import cn.urbanwall.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public String generateToken(TbUser user) {
        return createToken(user, new Date());
    }

    @Override
    public boolean saveToken(UserToken userToken) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",userToken.getUsername());
        map.put("token",userToken.getToken());
        return redisUtils.hmset(userToken.getUsername(), map);
    }

    private String createToken(TbUser user, Date date) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60 * 24 * 7))
                .claim("username",String.valueOf(user.getUsername())) // 设置内容
                .setIssuer("panda")// 设置签发人
                .signWith(signatureAlgorithm,"token"); // 签名，需要算法和key
        String jwt = builder.compact();
        return jwt;
    }
//
//    private TbUser decryptToken(String username,String token){
//        Claims claims = Jwts.parser().setSigningKey(username).parseClaimsJws(token).getBody();
//        String tokenUsername=(String)claims.get("username");
//        return new TbUser();
//    }

}
