package com.autumnframework.common.service.impl;

import com.autumnframework.common.dao.bomapper.ResourceMapper;
import com.autumnframework.common.model.po.Resource;
import com.autumnframework.common.service.interfaces.IResourceService;
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

    @Override
    public int deleteResById(Integer id, Integer level) {
        String table = "";
        if (level == 1){
            table = "af_funcgrp";
        }else if (level == 2){
            table = "af_func";
        }
        return resourceMapper.deleteResById(id, table);
    }
}
