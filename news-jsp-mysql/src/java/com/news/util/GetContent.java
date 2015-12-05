package com.news.util;

import inet.util.Logger;
import java.util.Hashtable;

public class GetContent {
	public static Logger logger = new Logger(GetContent.class.getName());
	public static ReaderWeb readerWeb = new ReaderWeb();
	private static final long TK_TIMEOUT_DEFAULT = 60 * 1000 * 30;// 30 minutes
	private static Hashtable infoTables = new Hashtable();
	private static Hashtable loadTimeTables = new Hashtable();
	
	public static boolean isTimeout(String url) {
		Long loadTime = null;
		try {
			loadTime = (Long) loadTimeTables.get(url);
		} catch (Exception e) {
			System.out.println("Chua khoi tao lan nao==>loadTime=0");
		}
		if (loadTime == null)
			loadTime = new Long("0");
		long currTime = System.currentTimeMillis();
		if ((currTime - loadTime.longValue()) > TK_TIMEOUT_DEFAULT) {
			return true;
		}
		return false;
	}

	private static String getInfofromBuffer(String url) {
		return (String) infoTables.get(url);
	}

	public static String getInfo(String url) {
		String info = null;
		info = getInfofromBuffer(url);
		if (!isTimeout(url) && info != null)
			return info;
		// info=lay noi dung tren web
		info = getContentFromUrl(url);
		loadTimeTables.put(url, new Long(System.currentTimeMillis() + ""));
		if (url != null && info != null)
			infoTables.put(url, info);
		if (info == null)
			info = "";
		return info;
	}

	private static String getContentFromUrl(String url) {
		String domain = null;
		String uri = null;
		if (url == null || url.equals("")) {
			return null;
		}
		url = url.replaceFirst("http://", "");
		if (url.indexOf("/") < 0) {
			domain = url;
			uri = "/";
		} else {
			domain = url.substring(0, url.indexOf("/"));
			uri = url.substring(url.indexOf("/"));
		}

		int port = 80;
		if (domain != null && domain.contains(":8080")) {
			domain = domain.replace(":8080", "");
			port = 8080;
		}
		System.out.println("domain=" + domain + ", uri= " + uri);
		logger.log("domain=" + domain + ", uri= " + uri);
		readerWeb.doGet(domain, uri, port);
		byte[] b = readerWeb.getContent();
		String content = null;
		try {
			content = new String(b, "UTF-8");
		} catch (Exception e) {
			logger.log(e.toString());
			e.printStackTrace();
		}
		return content;
	}

	public static void main(String[] arg) {
		// System.out.println(GetContent.getInfo("http://link.inet.vn/seo-website/inet.html"));
		// System.out.println(GetContent.getInfo("http://localhost:8080/xoso.sms.vn.seo/rss.jsp"));
		// System.out.println(GetContent.getInfo("http://3g.wap.vn/include/top-ads.jsp?rid=2"));
		System.out.println(GetContent.getInfo("http://web.tin.vn/payment/transaction.jsp?postId=110").trim());
	}
}
