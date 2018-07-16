package com.autumnframework.common.architect.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 7:59 PM 2018/07/16.
 */
public class PasswordEncrypt {
    public static void main(String[] args) throws Exception {
        String password = "your_password";
        String[] arr = ConfigTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + ConfigTools.encrypt(arr[0], password));
    }
}
