package com.roobtyan.pojo;

import java.io.Serializable;

public class Game implements Serializable {
    private Integer gId;

    private String gName;

    private String gAddress;

    private Double gSize;

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
        this.gName = gName == null ? null : gName.trim();
    }

    public String getgAddress() {
        return gAddress;
    }

    public void setgAddress(String gAddress) {
        this.gAddress = gAddress == null ? null : gAddress.trim();
    }

    public Double getgSize() {
        return gSize;
    }

    public void setgSize(Double gSize) {
        this.gSize = gSize;
    }
}