package com.autumnframework.login.service.impl;

import com.autumnframework.login.dao.bomapper.ResourceMapper;
import com.autumnframework.login.model.po.Resource;
import com.autumnframework.login.service.interfaces.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:04 2017/10/29.
 */
@Service
public class ResourceServiceImpl implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public List<Resource> selectResListByUserId(Integer userId) {
        return resourceMapper.selectResListByUserId(userId);
    }
}
