package com.maven.clientjsoup;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class Client {
	public static void main(String[] args) {
		// 1、访问的url
		String url="https://www.baidu.com";
		HttpClientUtils httpClientUtils = new HttpClientUtils();
		// 2、创建HttpClient对象，发送HTTP请求
		CloseableHttpClient createDefault = HttpClients.createDefault();
		// 3、Get请求方法
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response;
		try {
			response = createDefault.execute(httpGet);
			System.out.println(response);
			HttpEntity entity = response.getEntity();
			System.out.println(entity);
			System.out.println(entity.getContentLength());
			createDefault.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
