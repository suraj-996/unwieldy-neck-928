package com.bean;

public class Batch {
	private int bid;
	private String name;
	private int seat;
	
	public Batch() {
		
	}
	
	
	public Batch(int bid, String name, int seat) {
		super();
		this.bid = bid;
		this.name = name;
		this.seat = seat;
	}


	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", name=" + name + ", seat=" + seat + "]";
	}
	
	
}
