package cn.urbanwall.service;

import cn.urbanwall.model.TbProduct;

import java.util.List;

public interface ProductService {

    TbProduct selectTbproductByProId(Long proId);
    List<TbProduct> selectTbproductByProPlace(String proPlace);
    Boolean insertTbproduct(TbProduct tbProduct);
    List<TbProduct> selectTbproductByProPlaceAndProName(String proPlace,String proName);
}
