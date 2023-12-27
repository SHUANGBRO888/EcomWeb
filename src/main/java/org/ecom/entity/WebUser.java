package org.ecom.entity;

public class WebUser {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "WebUser{" +
                "userID=" + userID +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                '}';
    }

    private Integer userID;
    private String userEmail;
    private String userName;
    private String password;
    private Integer flag;
}
