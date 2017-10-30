package com.autumnframework.login.service.interfaces;

import com.autumnframework.login.model.po.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:03 2017/10/29.
 */
public interface IResourceService {
    /**
     * 根据用户id，返回请求接口
     * @param userId
     * @return
     */
    List<Resource> selectResListByUserId(@Param("userId") Integer userId);
}
