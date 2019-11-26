package com.roobtyan.pojo;

public class ChoiceCustom extends User {
    private Integer userId;

    private String userName;

    private String choiceId;

    private Integer choicedetailId;

    private Integer gId;

    private String gName;

    private String gAddress;

    private Double sizeTotal;

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    public Integer getChoicedetailId() {
        return choicedetailId;
    }

    public void setChoicedetailId(Integer choicedetailId) {
        this.choicedetailId = choicedetailId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    @Override
    public String toString() {
        return "ChoiceCustom{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", choiceId='" + choiceId + '\'' +
                ", choicedetailId=" + choicedetailId +
                ", gId=" + gId +
                ", gName='" + gName + '\'' +
                '}';
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress;
    }

    public Double getSizeTotal() {
        return sizeTotal;
    }

    public void setSizeTotal(Double sizeTotal) {
        this.sizeTotal = sizeTotal;
    }
}
