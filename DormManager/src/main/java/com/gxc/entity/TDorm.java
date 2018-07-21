package com.gxc.entity;

public class TDorm {
    private Integer dormid;

    private Integer dormbuildid;

    private String dormname;

    private String dormtype;

    private Integer dormnumber;

    private String dormtel;

    public Integer getDormid() {
        return dormid;
    }

    public void setDormid(Integer dormid) {
        this.dormid = dormid;
    }

    public Integer getDormbuildid() {
        return dormbuildid;
    }

    public void setDormbuildid(Integer dormbuildid) {
        this.dormbuildid = dormbuildid;
    }

    public String getDormname() {
        return dormname;
    }

    public void setDormname(String dormname) {
        this.dormname = dormname == null ? null : dormname.trim();
    }

    public String getDormtype() {
        return dormtype;
    }

    public void setDormtype(String dormtype) {
        this.dormtype = dormtype == null ? null : dormtype.trim();
    }

    public Integer getDormnumber() {
        return dormnumber;
    }

    public void setDormnumber(Integer dormnumber) {
        this.dormnumber = dormnumber;
    }

    public String getDormtel() {
        return dormtel;
    }

    public void setDormtel(String dormtel) {
        this.dormtel = dormtel == null ? null : dormtel.trim();
    }
}