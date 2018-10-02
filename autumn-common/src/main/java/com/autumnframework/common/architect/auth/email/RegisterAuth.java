package com.autumnframework.common.architect.auth.email;

import com.alibaba.fastjson.JSONObject;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.HttpMethodUtil;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:17 2017/11/21.
 */
@Component
public class RegisterAuth {
    /**
     * 第三方邮箱验证接口
     */
    private static final String URL = "http://tool.chacuo.net/mailverify";

    public int checkEmailIsValid(String email){



        Map<String, String> map = new HashMap<>();
        map.put("data", email);
        map.put("type", "verify");
        map.put("arg", "");

        String str = HttpMethodUtil.doPost(URL ,map);
        JSONObject jsonObject = JSONObject.parseObject(str);
        //  判断邮箱是否有效
        if ("1".equals(jsonObject.get("status").toString())
                && "ok".equals(jsonObject.get("info").toString())
                && jsonObject.get("data").toString().contains("验证成功")){

            return 1;
        }
        return -1;
    }
}
