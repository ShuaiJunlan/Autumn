package com.autumnframework.cms.dao.bomapper;

import com.autumnframework.cms.model.po.IpInforModel;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr SJL on 2016/12/8.
 *
 * @Author Junlan Shuai
 */
@Repository
public interface IIPInforDao
{
    /**
     * 将用户访问时使用的网络ip信息添加到数据库
     *
     * @param ipInforModel  ip信息模型
     */
    void addIpInfor(IpInforModel ipInforModel);
}
