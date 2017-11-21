package com.autumnframework.common.architect.auth.email;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.stereotype.Component;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:17 2017/11/21.
 */
//@Component
public class RegisterAuth {
    public static void main(String[] args) {
        Configuration xmlConfig = new XmlConfiguration(RegisterAuth.class.getResource("/ehcache.xml"));
        try (CacheManager cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig)) {
            cacheManager.init();

            Cache<Long, String> basicCache = cacheManager.getCache("basicCache", Long.class, String.class);
            basicCache.put(1L, "da one!");
            String value = basicCache.get(1L);
            System.out.println(value);
        }
    }
}
