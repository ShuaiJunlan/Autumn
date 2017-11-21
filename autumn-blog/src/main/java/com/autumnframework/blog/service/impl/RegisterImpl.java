package com.autumnframework.blog.service.impl;

import com.autumnframework.blog.service.interfaces.IRegister;
import com.autumnframework.common.dao.bomapper.UserMapper;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:59 2017/11/21.
 */
@Service
public class RegisterImpl implements IRegister {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseMsg doRegister() {
       return null;
    }
}
