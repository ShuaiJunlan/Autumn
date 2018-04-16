package com.autumnframework.cms.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 11:32 2018/4/16.
 *
 * 这个控制器主要提供给一些系统的统计信息，
 * 包括：系统访问量地域分布，近十天系统访问量分布，注册认证用户总数等
 */
@Controller
@RequestMapping(value = "statistics", method = RequestMethod.GET)
@ResponseBody
public class SystemStatisticsController {

}
