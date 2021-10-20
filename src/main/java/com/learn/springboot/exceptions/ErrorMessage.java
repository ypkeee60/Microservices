package com.learn.springboot.exceptions;

import java.util.Date;

public class ErrorMessage {
	
	private String msg;
	private Date date;
	
	public ErrorMessage() {
		
	}

	public ErrorMessage(String msg, Date date) {
		super();
		this.msg = msg;
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
