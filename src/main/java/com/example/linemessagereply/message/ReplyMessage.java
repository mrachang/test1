package com.example.linemessagereply.message;

import java.util.Arrays;


public class ReplyMessage {
	private String replyToken;
	private BaseMessage[] messages;
	
	public ReplyMessage(String replyToken, BaseMessage[] messages) {
		this.replyToken = replyToken;
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "{\"replyToken\":\""+replyToken+"\", \"messages\":"+Arrays.toString(messages)+"}";
	}
}
