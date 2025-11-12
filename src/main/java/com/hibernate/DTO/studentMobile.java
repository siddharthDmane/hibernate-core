package com.hibernate.DTO;

import java.util.List;

import com.hibernate.Mobile;

public class studentMobile {
    private int sId;
    private String sName;
    private char sGender;

    private List<Mobile> sMobiles;

    public studentMobile(int sId, String sName, char sGender, List<Mobile> sMobiles) {
        this.sId = sId;
        this.sName = sName;
        this.sGender = sGender;
        this.sMobiles = sMobiles;
    }

    public studentMobile() {
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public char getsGender() {
        return sGender;
    }

    public void setsGender(char sGender) {
        this.sGender = sGender;
    }

    public List<Mobile> getsMobiles() {
        return sMobiles;
    }

    public void setsMobiles(List<Mobile> sMobiles) {
        this.sMobiles = sMobiles;
    }

    @Override
    public String toString() {
        return "studentMobile [sId=" + sId + ", sName=" + sName + ", sGender=" + sGender + ", sMobiles=" + sMobiles
                + "]";
    }



}
