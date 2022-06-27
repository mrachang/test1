package com.example.linemessagereply.message;

import com.example.linemessagereply.message.BaseMessage;

public class TextMessage extends BaseMessage {
	private String text;
	private boolean wrap;
	
	public TextMessage(String text) {
		super("text");
		this.text = text;
		this.wrap = true;
	}
	
	@Override
	public String toString() {
		return "{\"text\":\"" + text + "\", \"wrap\":" + wrap + ",\"type\":\"text\"}";
	}

	
}
