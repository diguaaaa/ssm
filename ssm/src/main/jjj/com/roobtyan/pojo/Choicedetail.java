package com.roobtyan.pojo;

import java.io.Serializable;
import java.util.List;

public class Choicedetail implements Serializable {
    private Integer choicedetailId;

    private Integer gId;

    private String choiceId;

    private Integer count;

    private Double sizeTotal;

    private Double gSize;

    private Game gameList;

    public Game getGameList() {
        return gameList;
    }

    public void setGameList(Game gameList) {
        this.gameList = gameList;
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

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId == null ? null : choiceId.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSizeTotal() {
        return sizeTotal;
    }

    public void setSizeTotal(Double sizeTotal) {
        this.sizeTotal = sizeTotal;
    }

    public Double getgSize() {
        return gSize;
    }

    public void setgSize(Double gSize) {
        this.gSize = gSize;
    }

    @Override
    public String toString() {
        return "Choicedetail{" +
                "choicedetailId=" + choicedetailId +
                ", gId=" + gId +
                ", choiceId='" + choiceId + '\'' +
                ", count=" + count +
                ", sizeTotal=" + sizeTotal +
                ", gSize=" + gSize +
                ", gameList=" + gameList +
                '}';
    }
}