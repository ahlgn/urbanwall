package cn.urbanwall.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table tb_collect_product
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class TbCollectProduct {
    /**
     * Database Column Remarks:
     *   id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_collect_product.col_id
     *
     * @mbggenerated
     */
    private Long colId;

    /**
     * Database Column Remarks:
     *   产品id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_collect_product.col_pro_id
     *
     * @mbggenerated
     */
    private Long colProId;

    /**
     * Database Column Remarks:
     *   收藏者
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_collect_product.col_user_id
     *
     * @mbggenerated
     */
    private String colUserId;

    /**
     * Database Column Remarks:
     *   收藏时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_collect_product.col_time
     *
     * @mbggenerated
     */
    private Date colTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_collect_product.col_id
     *
     * @return the value of tb_collect_product.col_id
     *
     * @mbggenerated
     */
    public Long getColId() {
        return colId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_collect_product.col_id
     *
     * @param colId the value for tb_collect_product.col_id
     *
     * @mbggenerated
     */
    public void setColId(Long colId) {
        this.colId = colId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_collect_product.col_pro_id
     *
     * @return the value of tb_collect_product.col_pro_id
     *
     * @mbggenerated
     */
    public Long getColProId() {
        return colProId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_collect_product.col_pro_id
     *
     * @param colProId the value for tb_collect_product.col_pro_id
     *
     * @mbggenerated
     */
    public void setColProId(Long colProId) {
        this.colProId = colProId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_collect_product.col_user_id
     *
     * @return the value of tb_collect_product.col_user_id
     *
     * @mbggenerated
     */
    public String getColUserId() {
        return colUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_collect_product.col_user_id
     *
     * @param colUserId the value for tb_collect_product.col_user_id
     *
     * @mbggenerated
     */
    public void setColUserId(String colUserId) {
        this.colUserId = colUserId == null ? null : colUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_collect_product.col_time
     *
     * @return the value of tb_collect_product.col_time
     *
     * @mbggenerated
     */
    public Date getColTime() {
        return colTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_collect_product.col_time
     *
     * @param colTime the value for tb_collect_product.col_time
     *
     * @mbggenerated
     */
    public void setColTime(Date colTime) {
        this.colTime = colTime;
    }
}