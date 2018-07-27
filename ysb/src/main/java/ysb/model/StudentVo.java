package ysb.model;

import java.util.Date;

public class StudentVo {
	private int id;
	private String std_id;
	private String password;
	private String name;
	private int call_cnt;
	private String addr1;
	private String addr2;
	private String zipcd;
	private String pic;
	private String picpath;
	private String picname;
	private Date reg_dt;
	
	public StudentVo(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStd_id() {
		return std_id;
	}

	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCall_cnt() {
		return call_cnt;
	}

	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcd() {
		return zipcd;
	}

	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", std_id=" + std_id + ", password="
				+ password + ", name=" + name + ", call_cnt=" + call_cnt
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd
				+ ", pic=" + pic + ", picpath=" + picpath + ", picname="
				+ picname + ", reg_dt=" + reg_dt + "]";
	}
}
