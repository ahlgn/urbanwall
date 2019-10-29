package cn.urbanwall.model;

import java.util.Date;

public class TbUserbase {
    private Long id;

    private String userid;

    private String username;

    private String usericon;

    private Integer usersex;

    private Date userbirthday;

    private String userphone;

    private String useremail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon == null ? null : usericon.trim();
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public Date getUserbirthday() {
        return userbirthday;
    }

    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    @Override
    public String toString() {
        return "TbUserbase{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", usericon='" + usericon + '\'' +
                ", usersex=" + usersex +
                ", userbirthday=" + userbirthday +
                ", userphone='" + userphone + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}