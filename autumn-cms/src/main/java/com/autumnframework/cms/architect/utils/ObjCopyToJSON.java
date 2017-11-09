package com.autumnframework.cms.architect.utils;

import com.alibaba.fastjson.JSONObject;
import com.autumnframework.cms.model.po.IpInforModel;

import java.lang.reflect.Field;

/**
 * Created by Mr SJL on 2016/12/8.
 *
 * @Author Junlan Shuai
 */
public class ObjCopyToJSON
{
    public static Object reflect(Object obj, JSONObject jsonObject)
    {
        if (obj == null) {
            return null;
        }
        Field[] fields = obj.getClass().getDeclaredFields();
//        try{
//            Class obj1 = ClassLoader.loadClass(obj.getClass().getPackage().getName()+obj.getClass().getName());
//        }catch (ClassNotFoundException e)
//        {
//            e.printStackTrace();
//        }
        System.out.println(obj.getClass().getName());

        if (obj.getClass().getName().equals("com.sh.basefunc.dao.model.IpInforModel"))
        {
            IpInforModel obj1 = new IpInforModel();
            obj1.setIp(jsonObject.getString("ip"));
            obj1.setArea(jsonObject.getString("area"));
            obj1.setArea_id(jsonObject.getString("area_id"));
            obj1.setCity(jsonObject.getString("city"));
            obj1.setCity_id(jsonObject.getString("city_id"));
            obj1.setCountry(jsonObject.getString("country"));
            obj1.setCountry_id(jsonObject.getString("country_id"));
            obj1.setCounty(jsonObject.getString("county"));
            obj1.setCounty_id(jsonObject.getString("county_id"));
            obj1.setIsp(jsonObject.getString("isp"));
            obj1.setIsp_id(jsonObject.getString("isp_id"));
            obj1.setRegion(jsonObject.getString("region"));
            obj1.setRegion_id(jsonObject.getString("region_id"));
            return obj1;
        }

        for (int j = 0; j < fields.length; j++)
        {
            fields[j].setAccessible(true);
            fields[j].getName();                        //获取类的属性名称
        }
        return null;
    }
}
