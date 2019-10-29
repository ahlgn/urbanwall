package cn.urbanwall.serviceImpl;

import cn.urbanwall.dao.TbProductMapper;
import cn.urbanwall.model.TbProduct;
import cn.urbanwall.model.TbProductExample;
import cn.urbanwall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    TbProductMapper tbProductMapper;

    /**参数：产品的id
     * 描述：根据参评的id搜索产品
     * 返回：产品实体
    * */
    @Override
    public TbProduct selectTbproductByProId(Long proId) {
        return tbProductMapper.selectProductByproid(proId);
    }
    /**参数：产品的发布地
     * 描述：根据产品的发布地址搜索产品
     * 返回：产品的实体
     * */
    @Override
    public List<TbProduct> selectTbproductByProPlace(String proPlace) {
        return tbProductMapper.selectProductByproPlace(proPlace);
    }

    /**参数：产品对象
    * 描述：发布产品
     * 返回：插入成功返回true
    * */
    @Override
    public Boolean insertTbproduct(TbProduct tbProduct) {

        int i=tbProductMapper.insert(tbProduct);
        if (i==0){
            return false;
        }
            return true;
    }

    /**参数：发布地  产品名称
     * 描述：根据用户地还有产品的名称模糊搜索产品
     * 返回：产品的集合
     * */
    @Override
    public List<TbProduct> selectTbproductByProPlaceAndProName(String proPlace, String proName) {

        TbProductExample example = new TbProductExample();
        TbProductExample.Criteria criteria =example.createCriteria();
        criteria.andProPlaceEqualTo(proPlace);
        criteria.andProNameLike("%"+proName+"%");
        List<TbProduct> products = tbProductMapper.selectByExample(example);

        System.out.println(products.size()+"##");
        List<TbProduct>  tbProducts = new ArrayList<TbProduct>();
                for (TbProduct pro:products){
                    TbProduct newpro=tbProductMapper.selectProductByproid(pro.getProId());
                    tbProducts.add(newpro);
                }
        return tbProducts;
    }


}
