package com.roobtyan.pojo;

import java.io.Serializable;
import java.util.Map;

public class Choice implements Serializable {
    private String choiceId;

    private Integer userId;

    private Map<Integer,Choicedetail> cartMap;

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId == null ? null : choiceId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<Integer, Choicedetail> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Integer, Choicedetail> cartMap) {
        this.cartMap = cartMap;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choiceId='" + choiceId + '\'' +
                ", userId=" + userId +
                ", cartMap=" + cartMap +
                '}';
    }
}