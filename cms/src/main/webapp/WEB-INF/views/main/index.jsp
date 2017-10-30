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
    <link rel="stylesheet" href="${ctx}/static/css/global.css">

    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <link rel="stylesheet" href="${ctx}/static/css/main.css">
    <link rel="stylesheet" href="${ctx}/static/css/backstage.css">
    <script src="${ctx}/static/layui_v2/layui.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/index.js"></script>


</head>
<body class="main_body larryTheme-A">

    <div class="layui-layout layui-layout-admin ">
        <!-- 顶部-->
        <div class="layui-header header header-sysMenu ">
            <div class="layui-main ">
                <a href="#" class="logo">CMS后台管理系统</a>
                <!-- 左侧导航收缩开关 -->
                <div class="side-sysMenu-switch" id="toggle"><span class="switch" ara-hidden="true"></span></div>
                <!-- 顶级菜单 -->
                <div class="larry-top-sysMenu posb topMenu" id="topMenu"></div>
                <!-- 右侧常用菜单导航 -->
                <div class="larry-right-sysMenu posb" >
                    <ul class="layui-nav clearfix ">
                        <button class="layui-btn layui-btn-small" id="dianzhan">
                            <i class="larry-icon larry-dianzan"></i>
                            打赏作者
                        </button>
                        <%--<li style="" class="layui-nav-item">--%>
                            <%--<a class="onFullScreen" id="FullScreen"><i class="larry-icon larry-quanping"></i>全屏</a>--%>
                        <%--</li>--%>
                        <li style="" class="layui-nav-item">
                            <a id="lock"><i class="larry-icon larry-diannao5"></i>锁屏</a>
                        </li>
                        <%--<li style="" class="layui-nav-item">--%>
                            <%--<a id="clearCached"><i class="larry-icon larry-qingchuhuancun"></i>清除缓存</a>--%>
                        <%--</li>--%>
                        <%--<li style="" class="layui-nav-item">--%>
                            <%--<a id="larryTheme"><i class="larry-icon larry-theme1"></i>设置主题</a>--%>
                        <%--</li>--%>
                        <li class="layui-nav-item kjfs posb" >
                            <a class="kuaijiefangshi"><i class="larry-icon larry-kuaijie"></i><cite>快捷方式</cite><span class="layui-nav-more"></span></a>
                            <dl class="layui-nav-child">
                                <dd>
                                    <a href="/about/about_brief.html" target="_blank">关于我们</a>
                                </dd>
                                <dd>
                                    <a href="http://fly.layui.com/" target="_blank">Layui社区</a>
                                </dd>
                                <dd>
                                    <a href="http://www.layui.com/doc/" target="_blank">Layui文档</a>
                                </dd>
                                <dd>
                                    <a href="http://fly.layui.com/case/u/5849928" target="_blank">我的案例</a>
                                </dd>


                            </dl>
                        </li>
                        <li class="layui-nav-item exit">
                            <a id="logout"><i class="larry-icon larry-exit"></i><cite>退出</cite></a>
                        </li>
                    </ul>

                </div>
            </div>
        </div>

        <!-- 左侧导航-->
        <div class="layui-side layui-bg-black">
            <div class="user-photo">
                <a class="img" title="我的头像" ><img src="${ctx}/static/img/face.jpg"></a>
                <p>你好！<span class="userName" id="userNameSpan" title="${LOGIN_NAME.userName}">${LOGIN_NAME.userName}</span>, 欢迎登录</p>
            </div>
            <!-- 左侧菜单-->
            <div class="navBar layui-side-scroll" id="navBarId"></div>

        </div>
        <!--中间内容 -->
        <div class="layui-body layui-form" id="larry-body">
            <div class="layui-tab marg0" id="larry-tab" lay-filter="bodyTab">
                <! -- 选项卡-->
                <ul class="layui-tab-title top_tab" id="top_tabs">
                    <li class="layui-this" lay-id=""><i class="larry-icon larry-houtaishouye"></i> <cite>后台首页</cite></li>
                </ul>
                <div class="larry-title-box" style="height: 41px;" >
                    <div class="go-left key-press pressKey" id="titleLeft" title="滚动至最右侧"><i class="larry-icon larry-weibiaoti6-copy"></i> </div>
                    <div class="title-right" id="titleRbox">
                        <div class="go-right key-press pressKey" id="titleRight" title="滚动至最左侧"><i class="larry-icon larry-right"></i></div>
                        <div class="refresh key-press" id="refresh_iframe"><i class="larry-icon larry-shuaxin2"></i><cite>刷新</cite></div>

                        <div class="often key-press">
                            <ul class="layui-nav posr">
                                <li class="layui-nav-item posb">
                                    <a class="top"><i class="larry-icon larry-caozuo"></i><cite>常用操作</cite><span class="layui-nav-more"></span></a>
                                    <dl class="layui-nav-child">
                                        <dd>
                                            <a href="javascript:;" class="closeCurrent"><i class="larry-icon larry-guanbidangqianye"></i>关闭当前选项卡</a>
                                        </dd>
                                        <dd>
                                            <a href="javascript:;" class="closeOther"><i class="larry-icon larry-guanbiqita"></i>关闭其他选项卡</a>
                                        </dd>
                                        <dd>
                                            <a href="javascript:;" class="closeAll"><i class="larry-icon larry-guanbiquanbufenzu"></i>关闭全部选项卡</a>
                                        </dd>
                                    </dl>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="layui-tab-content clildFrame" style="height:793px;">
                    <div class="layui-tab-item layui-show layui-anim layui-anim-upbit">
                        <iframe src="${ctx}/main/home.do" data-id="0" name="ifr_0" id="ifr0"></iframe>
                    </div>
                </div>
            </div>
        </div>
        <!-- 底部-->
        <div class="layui-footer footer layui-larry-foot">

            <div class="layui-main">
                <p>Copyright 2017 © yangxiaobing,873559947@qq.com(推荐使用IE9+,Firefox、Chrome 浏览器访问)</p>
            </div>
        </div>
    </div>


</body>
</html>

<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'layer','common'], function () {
        var $ = layui.jquery,
                form = layui.form,
                layer = layui.layer,
                common = layui.common;



        if($("#userNameSpan").text().length > 6){
            $("#userNameSpan").text($("#userNameSpan").text().substring(0,6) +"...");

        }
    });

</script>