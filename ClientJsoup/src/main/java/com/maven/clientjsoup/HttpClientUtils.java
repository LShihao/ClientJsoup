package com.maven.clientjsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtils {
	public CloseableHttpResponse getUrl(String url){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response=null;
		try {
			response = httpClient.execute(get);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	public CloseableHttpResponse getPost(String url,Map<String,String> params){
		// 1.创建httpClient对象
				CloseableHttpClient httpClient = HttpClients.createDefault();

				HttpPost post = new HttpPost(url);

				// post.setParams("");
				List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();

				Set<String> keySet = params.keySet();
				for (String key : keySet) {
					BasicNameValuePair param1 = new BasicNameValuePair(key, params.get(key));
					list.add(param1);
				}

				CloseableHttpResponse response = null;
				try {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
					post.setEntity(entity);
					response = httpClient.execute(post);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return response;
	}
}
