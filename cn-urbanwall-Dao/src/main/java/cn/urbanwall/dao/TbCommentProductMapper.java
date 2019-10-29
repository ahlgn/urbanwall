package cn.urbanwall.dao;

import java.util.List;

import cn.urbanwall.model.TbCommentProduct;
import cn.urbanwall.model.TbCommentProductExample;
import org.apache.ibatis.annotations.Param;

public interface TbCommentProductMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int countByExample(TbCommentProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int deleteByExample(TbCommentProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long comId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int insert(TbCommentProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int insertSelective(TbCommentProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    List<TbCommentProduct> selectByExample(TbCommentProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    TbCommentProduct selectByPrimaryKey(Long comId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TbCommentProduct record, @Param("example") TbCommentProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TbCommentProduct record, @Param("example") TbCommentProductExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TbCommentProduct record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_comment_product
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TbCommentProduct record);
}