package com.example.linemessagereply.message;

import com.example.linemessagereply.message.BaseMessage;

public class StickerMessage extends BaseMessage {
	private String packageId;
	private String stickerId;
	public StickerMessage(String packageId, String stickerId) {
		super("sticker");
		this.packageId = packageId;
		this.stickerId = stickerId;
	}

	@Override
	public String toString() {
		return "{\"type\":\"sticker\",\"packageId\":\""+packageId+"\",\"stickerId\":\""+stickerId+"\"}";
	}
}
