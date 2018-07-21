package com.gxc.entity;

public class TDormmanager {
    private Integer dormmanid;

    private String username;

    private String password;

    private Integer bordbuildid;

    private String name;

    private String sex;

    private String tel;

    public Integer getDormmanid() {
        return dormmanid;
    }

    public void setDormmanid(Integer dormmanid) {
        this.dormmanid = dormmanid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getBordbuildid() {
        return bordbuildid;
    }

    public void setBordbuildid(Integer bordbuildid) {
        this.bordbuildid = bordbuildid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

	@Override
	public String toString() {
		return "TDormmanager [dormmanid=" + dormmanid + ", username=" + username + ", password=" + password
				+ ", bordbuildid=" + bordbuildid + ", name=" + name + ", sex=" + sex + ", tel=" + tel + "]";
	}
    
    
}