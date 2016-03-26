package com.control.meta;

public class BaseMessage {
	private String ToUserName;
	private String FromUserName;
	private long CreateTime;
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String userName) {
		ToUserName = userName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String userName) {
		FromUserName = userName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long time) {
		CreateTime = time;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String type) {
		MsgType = type;
	}

}
