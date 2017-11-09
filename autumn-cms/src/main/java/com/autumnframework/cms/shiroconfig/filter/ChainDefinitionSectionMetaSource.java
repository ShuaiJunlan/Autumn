package com.autumnframework.cms.shiroconfig.filter;

import com.autumnframework.cms.dao.bomapper.PluginMapper;
import com.autumnframework.cms.dao.bomapper.ResourceMapper;
import com.autumnframework.cms.model.po.Plugin;
import com.autumnframework.cms.model.po.Resource;
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

    @Autowired
    private PluginMapper pluginMapper;

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
    public synchronized Ini.Section getObject() throws Exception {
        //获取所有Resource
        List<Resource> list = resourceMapper.selectResourceAllList();

        //获取所有的插件
        List<Plugin> pluginList = pluginMapper.selectAllStatus1Plugin();

        Ini ini = new Ini();
        //加载默认的url
        ini.load(filterChainDefinitions);
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        //循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
        //里面的键就是链接URL,值就是存在什么条件才能访问该链接
        for (Iterator<Resource> it = list.iterator(); it.hasNext();) {

            Resource resource = it.next();
            //如果不为空值添加到section中
            if(StringUtils.isNotEmpty(resource.getLink_address())) {
                section.put(resource.getLink_address(),  MessageFormat.format(PERMISSION_STRING,resource.getId()));
            }
        }

        for (Iterator<Plugin> iterator = pluginList.iterator(); iterator.hasNext();){
            Plugin plugin = iterator.next();
            if (StringUtils.isNotEmpty(plugin.getDir()) && StringUtils.isNotEmpty(plugin.getHtmlcurl())){
                section.put(plugin.getDir()+plugin.getHtmlcurl(), MessageFormat.format(PERMISSION_STRING,plugin.getId()));
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
