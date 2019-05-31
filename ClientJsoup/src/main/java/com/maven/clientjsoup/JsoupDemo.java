package com.maven.clientjsoup;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JsoupDemo {
	public static void main(String[] args) {
		String url="https://www.baidu.com";
		Connection connect = Jsoup.connect(url);
		System.out.println(connect);
		try {
			Response response = connect.execute();
			String body = response.body();
			System.out.println("body:"+body);
			Document dom = response.parse();
			Elements elementsByTag = dom.getElementsByTag("a");
			for (Element e : elementsByTag) {
				System.out.println(e.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
