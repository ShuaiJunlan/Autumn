<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link rel="stylesheet" href="${ctx}/static/layui_v2/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/css/main.css">

    <script src="${ctx}/static/layui_v2/layui.js"></script>

</head>
<body class="childrenBody">
<blockquote class="layui-elem-quote">
    <p><span style="color:#1E9FFF;">项目简介：</span>
        contentManagerSystem,后台管理系统,采用SpringBoot构建整个项目框架,apacheShiro权限验证，mybatis+druid数据持久化动作
        前端框架采用layui<a class="layui-btn layui-btn-mini" target="_blank" href="http://www.layui.com">点此跳转</a>展示，
        整个项目全部通过注解方式进行配置,具体大家可以下载代码自行查看.
    </p>
    <p><span style="color:#1E9FFF;">友情提示：</span>
        由于此项目完全是在业余时间写的,部分功能和代码可能会有缺陷或者不足，但核心代码都已写完，大家可以下载下来在此基础上继续扩展，我也会一直维护，有问题我们可以一起交流.目前的版本代码刚写完只是测试版本，
        后续我会抽空继续，做一些封装和优化,敬请期待后续的版本.
    </p>
    <p><span style="color:#1E9FFF;">关于作者:</span>
        本人魔都纯后端Java程序员,前端技术确实比较弱，无意间看到layui社区的模板确实比较好看，但大多数都是静态的,于是就想做一套前后端交互的完整一点的项目，供大家一起交流和学习。
        <span style="color:#f00;">郑重声明：</span>
        本项目前端框架，借鉴layui社区,此模板 <a class="layui-btn layui-btn-mini" target="_blank" href="http://demo.larrycms.com/backstage/">点此跳转</a>，部分布局风格，如果有任何问题，
        请原作者联系我:联系方式  <span style="color:#f00;">QQ:873559947 微信:yxb873559947  qq交流群:187568013 </span>

    </p>
</blockquote>
<div class="row">
    <div class="sysNotice col">
        <blockquote class="layui-elem-quote title">项目信息</blockquote>
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col>
            </colgroup>
            <tbody>
            <tr>
                <td>系统名称:</td>
                <td class="version">contentManagerSystem(CMS)后台管理系统</td>
            </tr>
            <tr>
                <td>版本信息:</td>
                <td class="author"><span style="color:#f00;">beta-1.0.4</span></td>
            </tr>
            <tr>
                <td>开发作者</td>
                <td class="homePage">yangxiaobing</td>
            </tr>
            <tr>
                <td>项目下载：</td>
                <td class="homePage"><a class="layui-btn layui-btn-mini layui-btn-danger" target="_blank" href="http://fly.layui.com/case/u/5849928">我要点赞</a></td>
            </tr>
            <tr>
                <td>官网地址</td>
                <td class="server"><a href="http://www.yangxiaobing.org" class="official" target="_blank">http://www.yangxiaobing.org</a>
                </td>
            </tr>
            <tr>
                <td>服务器环境</td>
                <td class="dataBase">centos 7</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="sysNotice col">
        <blockquote class="layui-elem-quote title">License</blockquote>
        <div class="layui-elem-quote layui-quote-nm">
            <p><span style="color:#f00;">郑重提示：</span></p>
            <p>&nbsp;&nbsp;&nbsp;contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
                新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布. 关于GPL协议的细则请参考COPYING文件，
                您可以在contentManagerSystem的相关目录中获得GPL协议的副本， 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看.
            </p>

            <p><span style="color:#1E9FFF;">源码地址：</span>
                <a class="layui-btn layui-btn-mini" target="_blank"
                   href="http://git.oschina.net/yangxiaobing_175/contentManagerSystem">点此跳转</a>
            </p>

        </div>
    </div>

</div>
<div class="row">
    <div class="sysNotice col">
        <blockquote class="layui-elem-quote title">更新日志</blockquote>
        <div class="layui-elem-quote layui-quote-nm">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2017年8月22号</h3>
                        <p>beta-1.0.4</p>
                        <ul>
                            <li>layui版本升级至2.0.1</li>
                            <li>重写所有普通表格为新版本数据表格</li>
                            <li>新增登录页图片轮播功能</li>
                            <li>开放菜单管理新增功能</li>
                            <li>动态权限控制,可以根据不同账号查看不同菜单功能</li>
                            <li>部分代码优化</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2017年8月10号</h3>
                        <p>beta-1.0.3</p>
                        <ul>
                            <li>角色管理:新增查询功能</li>
                            <li>角色管理:新增导出功能</li>
                            <li>角色管理:新增失效、批量失效,解除用户、角色、菜单绑定关系功能</li>
                            <li>角色管理:新增、修改表单验证</li>
                            <li>角色管理:新增授权功能,tree菜单展示，并选择菜单</li>
                            <li>部分代码优化</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2017年8月6号</h3>
                        <p>beta-1.0.2</p>
                        <ul>
                            <li>用户管理:新增查询功能</li>
                            <li>用户管理:新增导出功能</li>
                            <li>用户管理:新增失效、批量失效功能</li>
                            <li>用户管理:新增、修改表单验证</li>
                            <li>部分代码优化</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2017年8月3号</h3>
                        <p>beta-1.0.1</p>
                        <ul>
                            <li>登陆页优化，加入H5视频效果，视频来源腾讯，仅供交流学习使用</li>
                            <li>实现角色新增修改功能</li>
                            <li>实现用户分配角色功能</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2017年7月31号</h3>
                        <p>beta-1.0.0</p>
                        <ul>
                            <li>SpringBoot项目构建</li>
                            <li>加入 mybatis+druid数据持久化功能</li>
                            <li>加入apacheShiro权限验证</li>
                            <li>新增用户管理、角色管理、菜单管理等部分功能实现</li>
                            <li>页面列表基于后台数据库交互实现table列表展示-分页、form表单提交</li>
                            <li>动态菜单导航,选项卡功能、弹层实现编辑保存功能</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="sysNotice col">
        <blockquote class="layui-elem-quote title">系统公告</blockquote>
        <div class="layui-elem-quote layui-quote-nm">
            <h3>目前开放两个测试账号:</h3>
            <h3>user_system/123456 此帐号拥有用户、角色、菜单、修改新增功能</h3>
            <h3>user_readonly/123456 此帐号为只读用户,只能查看数据不能做任何功能性操作</h3>
            <h3 style="color:#f00;">麻烦大家测试的时候,数据尽量造一些有意义的数据，不要写111或者222之类的，谢谢啦๑乛◡乛๑</h3>
            <h3>由于目前部分功能还未完善，暂不放开超级管理员权限:</h3>
        </div>
    </div>
</div>
</body>
</html>