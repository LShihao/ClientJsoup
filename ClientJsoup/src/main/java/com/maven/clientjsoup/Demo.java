package com.maven.clientjsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo {
	public static void main(String[] args) throws IOException {
		String url = "http://image.baidu.com/search/index?tn=baiduimage&ct=201326592&lm=-1&cl=2&ie=gb18030&word=%CD%BC%C6%AC&fr=ala&ala=1&alatpl=others&pos=0";
		// 1.创建httpClient对象
				CloseableHttpClient httpClient = HttpClients.createDefault();

				HttpGet get = new HttpGet(url);
				HttpPost post = new HttpPost(url);

				// 设置请求头
				// post.addHeader("Accept-Language", "zh-CN");

				// post.setParams("");
				List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
				BasicNameValuePair param1 = new BasicNameValuePair("tn", "baiduimage");
				list.add(param1);
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list);
				post.setEntity(entity);

				// 发送get请求，获取响应结果
				CloseableHttpResponse respones = httpClient.execute(get);

				// 获取响应内容
				HttpEntity entity2 = respones.getEntity();

				// 将响应内容转化为字符串
				String string = EntityUtils.toString(entity2);
				System.out.println("内容：" + string);

				// 将html字符串转换为文档对象
				Document dom = Jsoup.parse(string);
				// 设置绝对决定路径
				dom.setBaseUri(url);

				// 获取所有元素信息
				Elements allElements = dom.getAllElements();

				// 选择：选择器
				Elements imgs = allElements.select("img").select(".aaa");

				System.out.println(imgs.size());
				for (Element e : imgs) {
					System.out.println(e.attr("src"));
				}

				httpClient.close();
	}
}
