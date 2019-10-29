package cn.urbanwall.service;

import cn.urbanwall.model.TbCollectProduct;
import cn.urbanwall.model.TbProduct;

import java.util.List;


public interface CollectService {

   Boolean selectCollect(String userId,Long proId); //根据用户的id 和产品的id判断是否已经被收藏
   Boolean isCollect(String userId,Long proId);//根据用户id 和产品id查看是否有符合标准的数据如果有使用此方法就删除若是没有就收藏
   List<TbProduct> selectCollectPro(String userId);//返回对应用户的所有收藏的产品

}
