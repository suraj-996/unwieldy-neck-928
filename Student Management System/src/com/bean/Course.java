package com.bean;

public class Course {
	private int cid;
	private String cname;
	private int fee;
	private int bid;
	public Course() {
		
	}
	public Course(int cid, String cname, int fee, int bid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fee = fee;
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", fee=" + fee + ", bid=" + bid + "]";
	}

	
	
	
}
