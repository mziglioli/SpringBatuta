package com.batuta.model.json;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;

	private String msgid;
	private String sender;
	private String receiver;
	private String msg;
	private Date date;
	private boolean mine;


	public Chat() {
		setMsgID();
		date = Calendar.getInstance().getTime();
	}

	public Chat(String to, String from, String msg,boolean mine) {
		super();
		setMsgID();
		this.sender = to;
		this.receiver = from;
		this.msg = msg;
		this.date = Calendar.getInstance().getTime();
		this.mine = mine;
	}

	public Chat(String sender, String receiver, String msg, Date date,boolean mine) {
		super();
		setMsgID();
		this.sender = sender;
		this.receiver = receiver;
		this.msg = msg;
		this.date = date;
		this.mine = mine;
	}

	public void setMsgID() {
		msgid += "-" + String.format("%02d", new Random().nextInt(100));
		;
	}

	public String getMsgid() {
		return msgid;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
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

	public void setMine(boolean mine) {
		this.mine = mine;
	}
	
	public boolean isMine() {
		return mine;
	}

	@Override
	public String toString() {
		return "Chat{" +
				"msgid='" + msgid + '\'' +
				", sender='" + sender + '\'' +
				", receiver='" + receiver + '\'' +
				", msg='" + msg + '\'' +
				", date=" + date +
				", isMine=" + mine +
				'}';
	}
}


