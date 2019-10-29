package cn.urbanwall.model;

import java.util.Date;

public class TbProduct {
    private Long proId;

    private String proName;

    private String proType;

    private String proImages;

    private Double proPrice;

    private String proPlace;

    private Integer proStock;

    private Date proTime;

    private String userId;

    private String proDescribe;


    /** 一对一的关系映射
     * 产品--》用户
     * */
    private TbUserbase tbUserbase;



    public void setTbUserbase(TbUserbase tbUserbase) {
        this.tbUserbase = tbUserbase;
    }

    public TbUserbase getTbUserbase() {
        return tbUserbase;
    }
    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType == null ? null : proType.trim();
    }

    public String getProImages() {
        return proImages;
    }

    public void setProImages(String proImages) {
        this.proImages = proImages == null ? null : proImages.trim();
    }

    public Double getProPrice() {
        return proPrice;
    }

    public void setProPrice(Double proPrice) {
        this.proPrice = proPrice;
    }

    public String getProPlace() {
        return proPlace;
    }

    public void setProPlace(String proPlace) {
        this.proPlace = proPlace == null ? null : proPlace.trim();
    }

    public Integer getProStock() {
        return proStock;
    }

    public void setProStock(Integer proStock) {
        this.proStock = proStock;
    }

    public Date getProTime() {
        return proTime;
    }

    public void setProTime(Date proTime) {
        this.proTime = proTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getProDescribe() {
        return proDescribe;
    }

    public void setProDescribe(String proDescribe) {
        this.proDescribe = proDescribe == null ? null : proDescribe.trim();
    }

    @Override
    public String toString() {
        return "TbProduct{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proType='" + proType + '\'' +
                ", proImages='" + proImages + '\'' +
                ", proPrice=" + proPrice +
                ", proPlace='" + proPlace + '\'' +
                ", proStock=" + proStock +
                ", proTime=" + proTime +
                ", userId='" + userId + '\'' +
                ", proDescribe='" + proDescribe + '\'' +
                ", tbUserbase=" + tbUserbase +
                '}';
    }
}