package com.example.linemessagereply.handler;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.linemessagereply.listener.MessageListener;

import com.example.linemessagereply.message.BaseMessage;
import com.example.linemessagereply.message.StickerMessage;
import com.example.linemessagereply.message.TextMessage;
import com.example.linemessagereply.message.ReplyMessage;
import com.example.linemessagereply.connector.LineConnector;



@Component
public class MessageHandler {
	
	@Value("${line.user.channel.token}")
	private String LINE_TOKEN;
	public void doAction(JSONObject event) {
		doAction(this.messageListener, event);
	}
	public void doAction(MessageListener messageListener, JSONObject event) {
		switch (event.getJSONObject("message").getString("type")) {
		case "text":
			messageListener.text(event.getString("replyToken"), event.getJSONObject("message").getString("text"));
			break;
		case "sticker":
			messageListener.sticker(event.getString("replyToken"), event.getJSONObject("message").getString("packageId"), event.getJSONObject("message").getString("stickerId"));
			break;
	}
	}

	private MessageListener messageListener = new MessageListener() {

		@Override
		public void text(String replyToken, String text) {
			System.out.printf("%s\t%s\n", replyToken, "text");
			switch(text) {
			case "你好":{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("你好啊"),new StickerMessage("446","1988")}));
			break;
			}
			case "哈囉":{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("哈囉你好")}));
			break;	
			}
			case "台中天氣":{
					LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("今天台中天氣 https://www.cwb.gov.tw/V8/C/W/County/County.html?CID=66")}));
					break;
			}
			case "台北天氣":{
					LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("今天台北天氣 https://www.cwb.gov.tw/V8/C/W/County/County.html?CID=63")}));
					break;
			}
			default :{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("抱歉我還看不懂這句話")}));
			break;	
			}
			}
			}
		
		@Override
		public void sticker(String replyToken, String packageId, String stickerId) {
			System.out.printf("%s\t%s\n", replyToken, "sticker");
			switch(stickerId) {
			case "52002738":{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new StickerMessage("11537","52002738")}));
				break;
				
			}
			case "52002735":{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new StickerMessage("11537","52002752")}));
				break;
				
			}
			default :{
				LineConnector.getInstance().replyMessage(LINE_TOKEN, new ReplyMessage(replyToken, new BaseMessage[] {new TextMessage("抱歉我還看不懂這個貼圖")}));
				break;
			}
			
			}
		}
		};
}
