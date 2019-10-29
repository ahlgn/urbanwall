package cn.urbanwall.dao;

import cn.urbanwall.model.TbUserbase;
import cn.urbanwall.model.TbUserbaseExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbUserbaseMapper {
    int countByExample(TbUserbaseExample example);

    int deleteByExample(TbUserbaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUserbase record);

    int insertSelective(TbUserbase record);

    List<TbUserbase> selectByExample(TbUserbaseExample example);

    TbUserbase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUserbase record, @Param("example") TbUserbaseExample example);

    int updateByExample(@Param("record") TbUserbase record, @Param("example") TbUserbaseExample example);

    int updateByPrimaryKeySelective(TbUserbase record);

    int updateByPrimaryKey(TbUserbase record);
    /** 查询Tbproduct通过userid查询
     * */
    @Select("select *from tb_userbase where userId=#{userid}")
    TbUserbase selectByUserId(String userid);

}