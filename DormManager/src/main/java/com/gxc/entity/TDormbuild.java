package com.gxc.entity;

public class TDormbuild {
    private Integer dormbuildid;

    private String dormbuildname;

    private String dormbuilddetail;

    public Integer getDormbuildid() {
        return dormbuildid;
    }

    public void setDormbuildid(Integer dormbuildid) {
        this.dormbuildid = dormbuildid;
    }

    public String getDormbuildname() {
        return dormbuildname;
    }

    public void setDormbuildname(String dormbuildname) {
        this.dormbuildname = dormbuildname == null ? null : dormbuildname.trim();
    }

    public String getDormbuilddetail() {
        return dormbuilddetail;
    }

    public void setDormbuilddetail(String dormbuilddetail) {
        this.dormbuilddetail = dormbuilddetail == null ? null : dormbuilddetail.trim();
    }
}