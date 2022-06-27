package com.example.linemessagereply.listener;

public interface MessageListener{
	public void text(String replyToken, String text);
	public void sticker(String replyToken, String packageId, String stickerId);
}
