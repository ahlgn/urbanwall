package cn.urbanwall.serviceImpl;

import cn.urbanwall.dao.TbLikeProductMapper;
import cn.urbanwall.dao.TbProductMapper;
import cn.urbanwall.model.TbLikeProduct;
import cn.urbanwall.model.TbLikeProductExample;
import cn.urbanwall.model.TbProduct;
import cn.urbanwall.service.LikeProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class LikeProServiceImp implements LikeProService {
    @Autowired
    TbLikeProductMapper tbLikeProductMapper;

    @Autowired
    TbProductMapper tbProductMapper;

    /**参数：用户id  产品 id
     * 描述：判断是否有对应的喜欢
     * 返回：true（喜欢） false（没有喜欢）
     * */
    @Override
    public Boolean selectLikePro(String userId, Long proId) {
        TbLikeProductExample example = new TbLikeProductExample();
        TbLikeProductExample.Criteria criteria =example.createCriteria();
        criteria.andLikeUserIdEqualTo(userId);
        criteria.andLikeProIdEqualTo(proId);

        List<TbLikeProduct> tbLikeProducts =tbLikeProductMapper.selectByExample(example);
        if(tbLikeProducts.size()==0){
            return false;
        }else {
            return true;
        }
    }
    /**参数：用户id  产品 id
     * 描述：执行是否喜欢若是喜欢则调用变不喜欢 若是不喜欢调用变成喜欢
     * 返回：true（喜欢） false（没有喜欢）
     * */
    @Override
    public Boolean islikePro(String userId, Long proId) {

        TbLikeProductExample example = new TbLikeProductExample();
        TbLikeProductExample.Criteria criteria =example.createCriteria();
        criteria.andLikeUserIdEqualTo(userId);
        criteria.andLikeProIdEqualTo(proId);

        List<TbLikeProduct> tbLikeProducts =tbLikeProductMapper.selectByExample(example);
        if(tbLikeProducts.size()==0){
            TbLikeProduct tbLikeProduct=new TbLikeProduct();
            tbLikeProduct.setLikeProId(proId);
            tbLikeProduct.setLikeTime(new Date());
            tbLikeProduct.setLikeUserId(userId);

            tbLikeProductMapper.insert(tbLikeProduct);
            return true;
        }else {
            tbLikeProductMapper.deleteByPrimaryKey(tbLikeProducts.get(0).getLikeId());
            return false;
        }
    }

    /**参数：用户的账号
     * 描述：根据用户的账号返回用户喜欢的产品
     * 返回：用户喜欢的产品的集合
     * */
    @Override
    public List<TbProduct> selectLikeProAll(String userId) {
        TbLikeProductExample example = new TbLikeProductExample();
        TbLikeProductExample.Criteria criteria =example.createCriteria();
        criteria.andLikeUserIdEqualTo(userId);
        List<TbLikeProduct> tbLikeProducts =tbLikeProductMapper.selectByExample(example);

        List<TbProduct> tbProducts = new ArrayList<TbProduct>();
        for(TbLikeProduct tblike:tbLikeProducts){
            TbProduct tbProduct=tbProductMapper.selectProductByproid(tblike.getLikeProId());
            tbProducts.add(tbProduct);
        }

        return tbProducts;
    }
}
