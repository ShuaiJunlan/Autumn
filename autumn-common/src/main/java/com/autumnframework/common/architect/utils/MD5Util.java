package com.autumnframework.common.architect.utils;

import java.security.MessageDigest;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 11:05 2017/11/5.
 */
public class MD5Util {

    public static String getMD5(String message) {
        String md5 = "";
        try {
            // Create a MD5 instance
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageByte = message.getBytes("UTF-8");
            // get md5 byte array
            byte[] md5Byte = md.digest(messageByte);
            // switch to Hex
            md5 = bytesToHex(md5Byte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }

    /**
     *
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String pwd = getMD5("sys1");
        System.out.println(pwd);
        System.out.println(pwd.length());
    }
}
