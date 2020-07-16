package vn.itsol.MSWallet.dto;

import javax.persistence.Column;

public class UsersDto
{
    private long userId;
    private String userName;
    private String name;
    private String passWord;
    private long phoneNumber;
    private String gender;
    private String pathAva;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPathAva() {
        return pathAva;
    }

    public void setPathAva(String pathAva) {
        this.pathAva = pathAva;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender='" + gender + '\'' +
                ", pathAva='" + pathAva + '\'' +
                '}';
    }
}
