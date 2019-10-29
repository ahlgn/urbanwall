package cn.urbanwall;


import cn.urbanwall.model.*;
import cn.urbanwall.quervo.ImgResult;
import cn.urbanwall.quervo.UserToken;
import cn.urbanwall.quervo.WallView;
import cn.urbanwall.serviceImpl.*;
import cn.urbanwall.utils.MD5Utils;
import cn.urbanwall.utils.RedisUtils;
import cn.urbanwall.utils.VerifyCodeUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {
    @Autowired
    private TestProducer producer;

    @Test
    public void contextLoads() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Destination destination = new ActiveMQQueue("mytest.queue");
        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "这是一条消息"+i);
        }
    }

    @Test
    public void MD5Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password = MD5Utils.encodePassword("ligengnan");
        System.out.println(password);

    }
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void registerUser(){
        TbUser user= new TbUser();
        user.setUsername("片叶不沾身");
        user.setPassword("admin");
        Integer status = userService.register(user);
        if(status==1){
            System.out.println("注册成功");
        }else if(status==0){
            System.out.println("注册失败");
        }else{
            System.out.println("用户已经存在");
        }
    }

    @Test
    public void loginUser(){
        TbUser user= new TbUser();
        user.setUsername("万花丛中过");
        user.setPassword("admin");
        Integer status = userService.login(user);
        if(status==1){
            System.out.println("登录成功");
        }else if(status==0){
            System.out.println("密码错误");
        }else{
            System.out.println("用户不存在");
        }
    }

    @Test
    public void selectUserbase(){
        TbUser user= new TbUser();
        user.setUsername("万花丛中过");
        TbUserbase userbase = userService.selectUser(user);
        System.out.println(userbase.toString());
    }

    @Test
    public void updatePassword(){
        TbUser user= new TbUser();
        user.setUsername("万花丛中过");
        user.setPassword("admin");
        Integer status = userService.updatePassword(user);
        if(status==1){
            System.out.println("修改密码成功");
        }else {
            System.out.println("修改密码失败");
        }
    }

    @Autowired
    @Qualifier("ObjectConfigRedis")
    private RedisTemplate<String,Object> rtoken;
    @Test
    public void redisTest(){
        UserToken userToken = new UserToken();
        userToken.setUsername("ligengnan");
        userToken.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NTc2NzcyNDAsImV4cCI6MTU1NzkzNjQ0MCwidXNlciI6ImxpZ2VuZ25hbiZsaWdlbmduYW4iLCJpc3MiOiJwYW5kYSJ9.VNNBT56fg0m8RZOD-i7QHnZ0ykjWyhhY2VIHU3geHak");
        redisUtils.hmset(userToken.getUsername(),(Map<String, Object>) userToken);
    }

    @Test
    public void createToken(){
        TbUser user = new TbUser();
        user.setUsername("万花丛中过");
        user.setPassword("admin");
        Date date = new Date();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60 * 24 * 3))
                .claim("username",String.valueOf(user.getUsername()) ) // 设置内容
                .setIssuer("panda")// 设置签发人
                .signWith(signatureAlgorithm, "urbanwall"); // 签名，需要算法和key
        String jwt = builder.compact();
        System.out.println(jwt);
    }

    @Test
    public void test(){
        UserToken userToken = new UserToken();
        userToken.setUsername("ligengnan");
        userToken.setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NTc2NzcyNDAsImV4cCI6MTU1NzkzNjQ0MCwidXNlciI6ImxpZ2VuZ25hbiZsaWdlbmduYW4iLCJpc3MiOiJwYW5kYSJ9.VNNBT56fg0m8RZOD-i7QHnZ0ykjWyhhY2VIHU3geHak");
        Map<String,Object> map =new HashMap<>();
        map.put("username",userToken.getUsername());
        map.put("token",userToken.getToken());
        redisUtils.hmset(userToken.getUsername(),map);
    }

    @Autowired
    private RedisUtils redisUtils;
    @Test
    public void tokenMessage(){
        Map<Object, Object> map = redisUtils.hmget("片叶不沾身");
        if(!("片叶不沾身".equals(map.get("username")))){
            System.out.println("username不匹配");
            System.out.println(map.get("username"));
        }else if(!("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NTc2NzcyNDAsImV4cCI6MTU1NzkzNjQ0MCwidXNlciI6ImxpZ2VuZ25hbiZsaWdlbmduYW4iLCJpc3MiOiJwYW5kYSJ9.VNNBT56fg0m8RZOD-i7QHnZ0ykjWyhhY2VIHU3geHak".equals(map.get("token")))){
            System.out.println("token不匹配");
        }else{
            System.out.println("匹配");
        }
    }


    @Autowired
    private TokenServiceImpl tokenService;

    @Test
    public void testLogin(){
        TbUser user = new TbUser();
        user.setUsername("片叶不沾身");
        user.setPassword("admin");
        Integer status = userService.login(user);
        if(1==status){
            Date date = new Date();
            String token = getToken(user, date);
            Map<String,Object> map = new HashMap<>();
            map.put("username",user.getUsername());
            map.put("token",token);
            boolean b = redisUtils.hmset(user.getUsername(), map,60*60*24*7);
//            System.out.println(redisUtils.getExpire(user.getUsername()));
            System.out.println("用户"+user.getUsername()+"生成的Token为:"+token);
        }else if(0==status){

        }else{

        }
    }

    @Test
    public void checkToken(){
        String username ="片叶不沾身";
        System.out.println(redisUtils.getExpire(username));
    }

    private String getToken(TbUser user,Date date){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256").setIssuedAt(date) // 设置签发时间
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60 * 24 * 1)) //1天有效
                .claim("username",String.valueOf(user.getUsername())) // 设置内容
                .setIssuer("panda")// 设置签发人
                .signWith(signatureAlgorithm, "token"); // 签名，需要算法和key
        return builder.compact();
    }
    @Autowired
    private JmsTemplate jmsTemplate;
    @Test
    public void testSendWall(){
        TbWaller waller = new TbWaller();
        waller.setId(10000004L);
        waller.setSendUserid("532310E37A7E4BD48E5EA92AB5DE1819");
        waller.setSendUsername("万花丛中过");
        waller.setAddress("安徽#蚌埠");
        waller.setSchool("蚌埠学院");
        waller.setWaller("这是测试留言");
        waller.setEmotion(null);
        waller.setPicture(null);
        waller.setSendtime(new Date());
        jmsTemplate.send("wallMessage", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(waller);
                System.out.println("留言消息发送至消息队列");
               return message;
           }
        });
    }
    @Autowired
    private WallServiceImpl wallService;
    @Test
    public void setWall(){
        TbWaller waller = new TbWaller();
        waller.setId(10000003L);
        waller.setSendUserid("532310E37A7E4BD48E5EA92AB5DE1819");
        waller.setSendUsername("万花丛中过");
        waller.setAddress("安徽#蚌埠");
        waller.setSchool("蚌埠学院");
        waller.setWaller("这是测试留言");
        waller.setEmotion(null);
        waller.setPicture(null);
        waller.setSendtime(new Date());
        wallService.sendWall(waller);
    }

    @Test
    public void code() throws IOException {
        ImgResult imgResult = VerifyCodeUtils.VerifyCode(120, 40, 4);
        System.out.println(imgResult.getImg());
        System.out.println(imgResult.getCode());
    }

    @Test
    public void getWaller(){
        List<WallView> wallViews = wallService.selcetWallByUserId("90281FF732C5437C8FA236FA72E16D19");
        for (WallView t: wallViews
             ) {
            System.out.println(t.toString());
        }


    }
    @Test
    public void getWaller2(){
        List<WallView> wallers = wallService.selectWallBySchool("安徽财经大学", 10, 1);
        for (WallView t:wallers) {
            System.out.println(t.toString());
        }
    }

    @Test
    public void deleteWall(){
        wallService.deleteWallById(106L);
    }
    @Test
    public void test2(){
        boolean b = wallService.contrastIdAndUsername(107L, "片叶不沾身");
        System.out.println(b);
    }

    @Autowired
    ProductServiceImpl productServiceImp;
    @Test
    public void selectByProid(){
        TbProduct tb=productServiceImp.selectTbproductByProId(1L);
        System.out.println(tb.toString());
    }

    @Test
    public  void selectByProplace(){
       List<TbProduct> products = productServiceImp.selectTbproductByProPlace("安徽财经");
       for (TbProduct pro:products){
           System.out.println(pro.toString());
       }
    }
    @Test
    public  void insertProductTest(){
        TbProduct tbProduct = new TbProduct();
        tbProduct.setProDescribe("good");
        tbProduct.setProImages("main.jpg");
        tbProduct.setProName("西瓜");
        tbProduct.setProPlace("安徽蚌埠学院");
        tbProduct.setProPrice(12.0);
        tbProduct.setProStock(2);
        tbProduct.setProTime(new Date());
        tbProduct.setUserId("5F75752348394FDCABC0BF3C7593C36B");
        Boolean flog= productServiceImp.insertTbproduct(tbProduct);
       System.out.println(flog);
    }

    @Test
    public void selecctProductByplaceAndName(){
       List<TbProduct> products=productServiceImp.selectTbproductByProPlaceAndProName("安徽财经","面包");
       for(TbProduct pro:products){
           System.out.println(pro.toString());
       }
    }

    /* --------------收藏-------------*/

    @Autowired
    CollectServiceImp collectServiceImp;
    @Test
    public void insertCollectPro(){
       Boolean flog=collectServiceImp.isCollect("90281FF732C5437C8FA236FA72E16D19",3L);
     //   Boolean flog=collectServiceImp.selectCollect("90281FF732C5437C8FA236FA72E16D19",2L);
        System.out.println(flog);
    }

    @Test
    public  void  selectCollect(){
        List<TbProduct> tbProducts=collectServiceImp.selectCollectPro("90281FF732C5437C8FA236FA72E16D19");
        for(TbProduct tb:tbProducts){
            System.out.println(tb.toString());
        }
    }

    /*   ---------------喜欢--------------------*/
    @Autowired
    LikeProServiceImp likeProServiceImp;

    @Test
    public  void insertLikePro(){
       Boolean flog=likeProServiceImp.islikePro("90281FF732C5437C8FA236FA72E16D19",2L);
       // Boolean flog=likeProServiceImp.selectLikePro("90281FF732C5437C8FA236FA72E16D19",1L);
        System.out.println(flog);
    }

    @Test
    public  void  selectLike() {
        List<TbProduct> tbProducts = likeProServiceImp.selectLikeProAll("90281FF732C5437C8FA236FA72E16D19");
        for(TbProduct tb:tbProducts){
            System.out.println(tb.toString());
        }

    }
}
