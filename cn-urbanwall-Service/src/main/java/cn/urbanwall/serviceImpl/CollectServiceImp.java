package cn.urbanwall.serviceImpl;

import cn.urbanwall.dao.TbCollectProductMapper;
import cn.urbanwall.dao.TbProductMapper;
import cn.urbanwall.model.TbCollectProduct;
import cn.urbanwall.model.TbCollectProductExample;
import cn.urbanwall.model.TbProduct;
import cn.urbanwall.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImp implements CollectService {


    @Autowired
    TbCollectProductMapper tbCollectProductMapper;

    @Autowired
    TbProductMapper tbProductMapper;

    /**参数：用户id  产品id
     * 描述：根据用户的id 和产品的id判断是否已经被收藏
     *  返回：true 收藏 false未收藏
     * */
    @Override
    public Boolean selectCollect(String userId, Long proId) {
        TbCollectProductExample example = new TbCollectProductExample();
        TbCollectProductExample.Criteria criteria=example.createCriteria();
        criteria.andColUserIdEqualTo(userId);
        criteria.andColProIdEqualTo(proId);
        List<TbCollectProduct> tbCollectProducts=tbCollectProductMapper.selectByExample(example);
        if (tbCollectProducts.size()!=0){
            return true;
        }else {
            return false;
        }
    }

    /**参数：用户id  产品id
     * 描述：根据用户id 和产品id查看是否有符合标准的数据如果有使用此方法就删除若是没有就收藏
     * 返回：true 收藏 false取消收藏
     *
     * */

    @Override
    public Boolean isCollect(String userId, Long proId) {
        TbCollectProductExample example = new TbCollectProductExample();
        TbCollectProductExample.Criteria criteria=example.createCriteria();
        criteria.andColUserIdEqualTo(userId);
        criteria.andColProIdEqualTo(proId);
        List<TbCollectProduct> tbCollectProducts=tbCollectProductMapper.selectByExample(example);
        if(tbCollectProducts.size()!=0){
            tbCollectProductMapper.deleteByPrimaryKey(tbCollectProducts.get(0).getColId());
            return false;
        }else {
            TbCollectProduct tbCollectProduct=new TbCollectProduct();
            tbCollectProduct.setColUserId(userId);
            tbCollectProduct.setColProId(proId);
            tbCollectProduct.setColTime(new Date());
            tbCollectProductMapper.insert(tbCollectProduct);
            return true;
        }
    }

    /**参数：用户账号
     * 描述：
     * 返回：返回收藏的产品
    * */
    @Override
    public List<TbProduct> selectCollectPro(String userId) {
        TbCollectProductExample example = new TbCollectProductExample();
        TbCollectProductExample.Criteria criteria =example.createCriteria();
        criteria.andColUserIdEqualTo(userId);

        List<TbCollectProduct> tbCollectProducts=tbCollectProductMapper.selectByExample(example);
        List<TbProduct> tbProducts = new ArrayList<TbProduct>();
        for (TbCollectProduct tbCollectProduct:tbCollectProducts){
           TbProduct tbProduct = tbProductMapper.selectProductByproid(tbCollectProduct.getColProId());
           tbProducts.add(tbProduct);
        }
        return tbProducts;
    }
}
