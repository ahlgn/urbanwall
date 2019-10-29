package cn.urbanwall.dao;

import cn.urbanwall.model.*;
import cn.urbanwall.quervo.WallView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbWallerMapper {
    int countByExample(TbWallerExample example);

    int deleteByExample(TbWallerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbWaller record);

    int insertSelective(TbWaller record);

    List<TbWaller> selectByExample(TbWallerExample example);

    TbWaller selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbWaller record, @Param("example") TbWallerExample example);

    int updateByExample(@Param("record") TbWaller record, @Param("example") TbWallerExample example);

    int updateByPrimaryKeySelective(TbWaller record);

    int updateByPrimaryKey(TbWaller record);

    List<TbWaller> selectBySchoolAndPage(Map<String,Object> map);

    List<WallView> selectWallView(Map<String,Object> map);

    List<WallView> selectWallByUserId(String userid);
}