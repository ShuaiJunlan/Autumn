package com.autumnframework.common.architect.utils;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 18:59 2017/11/27.
 */
public class RandomNumUtil {
    public static long generateNbitNum(int n){
        long a = (long)(Math.random() * Math.pow(10, n));
        return a;
    }
}
