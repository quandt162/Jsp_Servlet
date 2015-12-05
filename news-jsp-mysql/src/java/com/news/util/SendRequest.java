package com.news.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendRequest {

    public static void main(String[] args) {
        String url = "http://data.inet.vn/api-adv-banner/";
        String param = "siteId=2&position=BOTTOM";
        String result = SendRequest.excutePost(url, param);
        System.out.println(result);
    }

    public static void executeGet(String targetUrl) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection        	
            url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET ");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(targetUrl.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            //System.out.println("--------"+connection.getContentEncoding());
            connection.setUseCaches(false);
            connection.setDoInput(false);
            connection.setDoOutput(true);

            //Send request
            java.io.DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.flush();
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String excutePost(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection        	
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            //System.out.println("--------"+connection.getContentEncoding());
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            java.io.DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            //Get Response	
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
