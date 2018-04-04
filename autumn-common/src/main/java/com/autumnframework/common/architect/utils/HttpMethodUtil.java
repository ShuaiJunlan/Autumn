package com.autumnframework.common.architect.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:55 2017/9/5.
 */
public class HttpMethodUtil {
    private static String str = null;
    private static URL url;        //根据参数创建URL对象
    private static HttpURLConnection con;

    public static String doPost(String url, Map<String, String> params) {
        try {
            HttpURLConnection con = doHttp(url, 500000, "POST", true, true);                                                          //指示应用程序要将数据写入 URL 连接。
            String content = getContent(params);                                            //解析参数（请求的内容）
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");    //设置内容
            con.setRequestProperty("Content-Length", content.length() + "");                //设置内容长度
            OutputStream os = con.getOutputStream();
            os.write(content.getBytes("utf-8"));                                            //发送参数内容
            os.flush();
            os.close();
            if (con.getResponseCode() == 200) {
                str = formatIsToString(con.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String doGet(String url) {
        try {
            HttpURLConnection con = doHttp(url, 500000, "GET", true, false);
            if (con.getResponseCode() == 200)                                               //当请求成功时，接收数据（状态码“200”为成功连接的意思“ok”）
            {
                InputStream is = con.getInputStream();
                str = formatIsToString(is);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static HttpURLConnection doHttp(String url, int timeout, String method, boolean doinput, boolean dooutput) {
        HttpURLConnection con = null;
        try {
            URL url1 = new URL(url);
            con = (HttpURLConnection) url1.openConnection();
            con.setReadTimeout(timeout);                                                        //将读超时设置为指定的超时，以毫秒为单位。用一个非零值指定在建立到资源的连接后从 Input 流读入时的超时时间。如果在数据可读取之前超时期满，则会引发一个 java.net.SocketTimeoutException。
            con.setDoInput(doinput);                                                            //指示应用程序要从 URL 连接读取数据。
            con.setDoOutput(dooutput);
            con.setRequestMethod(method);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return con;

    }

    private static String getContent(Map params) throws UnsupportedEncodingException {
        String content = null;
        StringBuilder sb = new StringBuilder();
        Set<String> key = params.keySet();
        for (String i : key) {
            sb.append(i).append("=")
                    .append(params.get(i))
                    .append("&");
        }
        if (sb.length() > 1) {
            content = sb.substring(0, sb.length() - 1);

        }
        return content;
    }

    private static String formatIsToString(InputStream is) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while ((len = is.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            baos.flush();
            baos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(baos.toByteArray(), "UTF-8");
    }
}
