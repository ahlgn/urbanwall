package cn.urbanwall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
@ApiModel(value="TbWaller",description="留言墙")
public class TbWaller implements Serializable {

    private Long id;
    @ApiModelProperty(value="发送人Id",name="sendUserid",required = true)
    private String sendUserid;
    @ApiModelProperty(value="发送人",name="sendUsername",required = true)
    private String sendUsername;
    @ApiModelProperty(value="留言信息",name="waller",required = true)
    private String waller;
    @ApiModelProperty(value="图片地址",name="picture")
    private String picture;

    private String emotion;
    @ApiModelProperty(value="地址",name="address",required = true)
    private String address;
    @ApiModelProperty(value="学校",name="school",required = true)
    private String school;

    private Date sendtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSendUserid() {
        return sendUserid;
    }

    public void setSendUserid(String sendUserid) {
        this.sendUserid = sendUserid == null ? null : sendUserid.trim();
    }

    public String getSendUsername() {
        return sendUsername;
    }

    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername == null ? null : sendUsername.trim();
    }

    public String getWaller() {
        return waller;
    }

    public void setWaller(String waller) {
        this.waller = waller == null ? null : waller.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion == null ? null : emotion.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public String toString() {
        return "TbWaller{" +
                "id=" + id +
                ", sendUserid='" + sendUserid + '\'' +
                ", sendUsername='" + sendUsername + '\'' +
                ", waller='" + waller + '\'' +
                ", picture='" + picture + '\'' +
                ", emotion='" + emotion + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", sendtime=" + sendtime +
                '}';
    }
}