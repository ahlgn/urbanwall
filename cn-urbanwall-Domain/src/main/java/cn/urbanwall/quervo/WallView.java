package cn.urbanwall.quervo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class WallView {
    private Long id;

    private String sendUserid;

    private String sendUsername;

    private String usericon;

    private String waller;

    private String picture;

    private String emotion;

    private String address;

    private String school;

    private Date sendtime;

    @Override
    public String toString() {
        return "WallView{" +
                "id=" + id +
                ", sendUserid='" + sendUserid + '\'' +
                ", sendUsername='" + sendUsername + '\'' +
                ", usericon='" + usericon + '\'' +
                ", waller='" + waller + '\'' +
                ", picture='" + picture + '\'' +
                ", emotion='" + emotion + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", sendtime=" + sendtime +
                '}';
    }

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
        this.sendUserid = sendUserid;
    }

    public String getSendUsername() {
        return sendUsername;
    }

    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    public String getWaller() {
        return waller;
    }

    public void setWaller(String waller) {
        this.waller = waller;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}
