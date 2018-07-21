package com.gxc.entity;

import java.util.Date;

public class TRecord {
    private Integer recordid;

    private String studentnumber;//

    private String studentname;//

    private Integer dormbuildid;//

    private String dormname;

    private Date date; //

    private String datail;//

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber == null ? null : studentnumber.trim();
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDatail() {
        return datail;
    }

    public void setDatail(String datail) {
        this.datail = datail == null ? null : datail.trim();
    }
}