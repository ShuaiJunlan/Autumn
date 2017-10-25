package com.autumnframework.login.shiroconfig.filter;

import com.autumnframework.login.dao.bomapper.ResourceMapper;
import com.autumnframework.login.domain.vo.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:51 2017/9/2.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {
    private static final Logger logger = LogManager.getLogger(ChainDefinitionSectionMetaSource.class);

    @Autowired
    private ResourceMapper resourceMapper;

    private String filterChainDefinitions;
    /**
     * 通过filterChainDefinitions对默认的url过滤定义
     *
     * @param filterChainDefinitions 默认的url过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
    /**
     * 默认premission字符串
     */
    public static final String PERMISSION_STRING="perms[{0}]";

    @Override
    public Ini.Section getObject() throws Exception {
        //获取所有Resource
        List<Resource> list = resourceMapper.selectResUrlAllList();

        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (Iterator<Resource> it = list.iterator(); it.hasNext();) {

            Resource resource = it.next();
            //如果不为空值添加到section中
            if(StringUtils.isNotEmpty(resource.getResLinkAddress()) && StringUtils.isNotEmpty(resource.getResModelCode())) {
                section.put(resource.getResLinkAddress(),  MessageFormat.format(PERMISSION_STRING,resource.getResModelCode()));
            }
        }
        section.put("/**", "authc");
        logger.debug("the list of filter url:" + section.values() + "---Total:" +section.values().size());
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
