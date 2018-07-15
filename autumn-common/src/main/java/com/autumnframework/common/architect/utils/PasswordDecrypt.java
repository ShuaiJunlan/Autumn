package com.autumnframework.common.architect.utils;

import com.alibaba.druid.filter.config.ConfigTools;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 5:11 PM 2018/07/15.
 */
public class PasswordDecrypt {
    public static void main(String[] args) throws Exception {
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJBMyqWCAu3arw9FIlmO+9rPjo+Djve6krSgVHVHAPIPPXvaxvzVSLTuBLUQJU5gBv7rjd7+IJjGukCcThzrzHcCAwEAAQ==";
        String password = "V77ro97aG18B5i3GG/71UUuSDPuNTluZzMcFxAjP7TmTxJu6HN5BXPJqeQBC9vE//RyZIe3ccAlem3mAP80iPg==";

        System.out.println( ConfigTools.decrypt(publickey, password) );

    }
}
