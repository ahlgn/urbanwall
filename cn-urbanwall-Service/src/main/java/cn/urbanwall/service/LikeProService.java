package cn.urbanwall.service;

import cn.urbanwall.model.TbLikeProduct;
import cn.urbanwall.model.TbProduct;

import java.util.List;

public interface LikeProService {
    Boolean selectLikePro(String userId,Long proId);//判断是否有对应的喜欢的产品
    Boolean islikePro(String userId,Long proId);//执行是否喜欢若是喜欢则调用变不喜欢 若是不喜欢调用变成喜欢
    List<TbProduct> selectLikeProAll(String userId);//根据用户的账号返回用户喜欢的产品
}
