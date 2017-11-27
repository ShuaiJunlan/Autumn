package com.autumnframework.common.architect.utils;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 9:30 2017/11/22.
 */
public class CheckEmailValidityUtil {

    public static boolean isEmailValid(String email) {
        String soapRequestData = ""
                + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "  <soap:Body>"
                + "   <IsValidEmail xmlns=\"http://www.webservicex.net\">"
                + "    <Email>" + email + "</Email>" + "   </IsValidEmail>"
                + "  </soap:Body>" + "</soap:Envelope>";

        try {
            URL u = new URL(
                    "http://www.webservicex.net/ValidateEmail.asmx?op=IsValidEmail");
            URLConnection uc = u.openConnection();
            uc.setDoOutput(true);
            uc.setRequestProperty("Content-Type",
                    "application/soap+xml; charset=utf-8");
            PrintWriter pw = new PrintWriter(uc.getOutputStream());
            pw.println(soapRequestData);
            pw.close();

            DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = bf.newDocumentBuilder();
            Document document = db.parse(uc.getInputStream());

            String res = document.getElementsByTagName("IsValidEmailResult")
                    .item(0).getTextContent();

            return Boolean.parseBoolean(res);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
