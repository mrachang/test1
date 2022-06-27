package com.example.linemessagereply.connector;

import java.io.IOException;

import com.example.linemessagereply.message.ReplyMessage;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class LineConnector {

	private final String LINE_REPLY_API = "https://api.line.me/v2/bot/message/reply";


	private static LineConnector instance;
	private OKHttpExecuter executer;

	private LineConnector() {
		executer = new OKHttpExecuter();
	}

	public static LineConnector getInstance() {
		if (instance == null) {
			synchronized (LineConnector.class) {
				if (instance == null) {
					instance = new LineConnector();
				}
			}
		}
		return instance;
	}

	public void replyMessage(String LINE_TOKEN, ReplyMessage replyMessage) {
		;
		executer.sendPostByJson(LINE_REPLY_API, LINE_TOKEN, replyMessage.toString(), new Callback() {
			public void onResponse(Call call, Response response) throws IOException {
				System.out.println("發送成功");
				System.out.println(response.body().string());
			}

			public void onFailure(Call call, IOException e) {
				System.err.println("發送失敗");
				e.printStackTrace();
			}
		});
	}


}
