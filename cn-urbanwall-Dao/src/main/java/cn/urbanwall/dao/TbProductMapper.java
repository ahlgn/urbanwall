package cn.urbanwall.dao;

import cn.urbanwall.model.TbProduct;
import cn.urbanwall.model.TbProductExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

public interface TbProductMapper {
    int countByExample(TbProductExample example);

    int deleteByExample(TbProductExample example);

    int deleteByPrimaryKey(Long proId);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    List<TbProduct> selectByExampleWithBLOBs(TbProductExample example);

    List<TbProduct> selectByExample(TbProductExample example);

    TbProduct selectByPrimaryKey(Long proId);

    int updateByExampleSelective(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExample(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKeyWithBLOBs(TbProduct record);

    int updateByPrimaryKey(TbProduct record);

    /**注解通过产品的id实现一对一的查询
     *返回的单件产品
     * */
    @Select("select *from tb_product where pro_id=#{proId}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "tbUserbase" ,column = "user_id",
                    one=@One(select ="cn.urbanwall.dao.TbUserbaseMapper.selectByUserId"))
    })
    TbProduct selectProductByproid(Long proId);

    /**通过产品的发布地点查询返回的是一个列表
     * */
   @Select("select *from tb_product where pro_place=#{proPlace}")
   @Results({
           @Result(property = "userId",column = "user_id"),
           @Result(property = "tbUserbase" ,column = "user_id",
                   one=@One(select ="cn.urbanwall.dao.TbUserbaseMapper.selectByUserId"))
   })
    List<TbProduct> selectProductByproPlace(String proPlace);
}