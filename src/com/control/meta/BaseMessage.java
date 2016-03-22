package com.control.meta;

public class BaseMessage {
	private String toUserName;
	private String fromUserName;
	private long createTime;
	private String msgType;
	private long msgId;
	private int funcFlag;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String userName) {
		toUserName = userName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String userName) {
		fromUserName = userName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long time) {
		createTime = time;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String type) {
		msgType = type;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long id) {
		msgId = id;
	}

	public int getFuncFlag() {
		return funcFlag;
	}

	public void setFuncFlag(int flag) {
		funcFlag = flag;
	}
}
