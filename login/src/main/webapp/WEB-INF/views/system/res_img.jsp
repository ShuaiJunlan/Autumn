<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="后台管理系统">
    <meta name="description" content="致力于提供通用版本后台管理解决方案">
    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">

    <link rel="stylesheet" href="${ctx}/static/layui_v2/css/layui.css">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">

    <script src="${ctx}/static/layui_v2/layui.js"></script>
    <style type="text/css">
        a {
            cursor: pointer;
        }

    </style>
</head>
<body class="childrenBody" style="font-size:12px;margin: 10px 10px 0;">
<fieldset class="layui-elem-field ">
    <legend style="font-size: 12px;color:#FF5722;">双击选择图标</legend>
    <div class="layui-field-box">
        <form class="layui-form layui-form-pane">
        <div class="layui-form-item" style="margin-bottom:0px;">
            <div class="layui-inline" style="margin-bottom:0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xitongshezhi1" title="系统管理"><i class="layui-icon larry-icon larry-xitongshezhi1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux" >
                    <a class="select_img" data-id="larry-neirongguanli" title="内容管理"><i class="layui-icon larry-icon larry-neirongguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-10103" title="用户管理"><i class="layui-icon larry-icon larry-10103"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-jiaoseguanli1" title="角色管理"><i class="layui-icon larry-icon larry-jiaoseguanli1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-caidanguanli" title="菜单管理"><i class="layui-icon larry-icon larry-caidanguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-liuyan" title="留言"><i class="layui-icon larry-icon larry-liuyan"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tuichu1" title="退出"><i class="layui-icon larry-icon larry-tuichu1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontxiazai" title="下载"><i class="layui-icon larry-icon larry-iconfontxiazai"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu" title="删除"><i class="layui-icon larry-icon larry-shanchu"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tags" title="tags"><i class="layui-icon larry-icon larry-tags"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu6" title="删除"><i class="layui-icon larry-icon larry-shanchu6"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xitongrizhi" title="系统日志"><i class="layui-icon larry-icon larry-xitongrizhi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu1" title="删除"><i class="layui-icon larry-icon larry-shanchu1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-jiekouguanli" title="接口管理"><i class="layui-icon larry-icon larry-jiekouguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-huishouzhan1" title="回收站"><i class="layui-icon larry-icon larry-huishouzhan1"></i></a>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom: 0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tianjia2" title="添加"><i class="layui-icon larry-icon larry-tianjia2"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-unie614" title="密码"><i class="layui-icon larry-icon larry-unie614"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-circularxiangxi" title="参数"><i class="layui-icon larry-icon larry-circularxiangxi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shuaxin4" title="刷新"><i class="layui-icon larry-icon larry-shuaxin4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-bianji2" title="编辑"><i class="layui-icon larry-icon larry-bianji2"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-ttpodicon" title="删除"><i class="layui-icon larry-icon larry-ttpodicon"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xitongshezhi" title="系统设置"><i class="layui-icon larry-icon larry-xitongshezhi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu7" title="删除"><i class="layui-icon larry-icon larry-shanchu7"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-logoshuiyin" title="logo水印"><i class="layui-icon larry-icon larry-logoshuiyin"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-guanbi1" title="关闭"><i class="layui-icon larry-icon larry-guanbi1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconzfb" title="支付宝"><i class="layui-icon larry-icon larry-iconzfb"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontadd" title="添加"><i class="layui-icon larry-icon larry-iconfontadd"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xiazai1" title="下载"><i class="layui-icon larry-icon larry-xiazai1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-chaxun2" title="查询"><i class="layui-icon larry-icon larry-chaxun2"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-bianji3" title="编辑"><i class="layui-icon larry-icon larry-bianji3"></i></a>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom:0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tianjia3" title="添加"><i class="layui-icon larry-icon larry-tianjia3"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconshanchu" title="删除"><i class="layui-icon larry-icon larry-iconshanchu"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu8" title="删除"><i class="layui-icon larry-icon larry-shanchu8"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-bianji4" title="编辑"><i class="layui-icon larry-icon larry-bianji4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-zhandianneirong" title="站点内容"><i class="layui-icon larry-icon larry-zhandianneirong"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontfilesfill" title="文章"><i class="layui-icon larry-icon larry-iconfontfilesfill"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-chaxun3" title="查询"><i class="layui-icon larry-icon larry-chaxun3"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-nav" title="栏目"><i class="layui-icon larry-icon larry-nav"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-close" title="关闭"><i class="layui-icon larry-icon larry-close"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shanchu9" title="删除"><i class="layui-icon larry-icon larry-shanchu9"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-11" title="验证"><i class="layui-icon larry-icon larry-11"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-zidingyicaidan" title="自定义菜单"><i class="layui-icon larry-icon larry-zidingyicaidan"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontcolor16" title="图片"><i class="layui-icon larry-icon larry-iconfontcolor16"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-guanwangicon31319" title="主题风格"><i class="layui-icon larry-icon larry-guanwangicon31319"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-rizhi1" title="日志"><i class="layui-icon larry-icon larry-rizhi1"></i></a>
                </div>
            </div>

            <div class="layui-inline" style="margin-bottom:0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-zidian" title="字典"><i class="layui-icon larry-icon larry-zidian"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-duanxin1" title="短信"><i class="layui-icon larry-icon larry-duanxin1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shenhe" title="审核"><i class="layui-icon larry-icon larry-shenhe"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-bianji5" title="编辑"><i class="layui-icon larry-icon larry-bianji5"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-wangzhanneirong" title="网站内容"><i class="layui-icon larry-icon larry-wangzhanneirong"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xiugai3" title="修改"><i class="layui-icon larry-icon larry-xiugai3"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tianjia5" title="添加"><i class="layui-icon larry-icon larry-tianjia5"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-gerenxinxi3" title="个人信息"><i class="layui-icon larry-icon larry-gerenxinxi3"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tianjia6" title="添加"><i class="layui-icon larry-icon larry-tianjia6"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-gerenxinxi4" title="个人信息"><i class="layui-icon larry-icon larry-gerenxinxi4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-zhifubao" title="支付宝"><i class="layui-icon larry-icon larry-zhifubao"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-dianzan" title="点赞"><i class="layui-icon larry-icon larry-dianzan"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-diannao3" title="电脑"><i class="layui-icon larry-icon larry-diannao3"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-icon040" title="电脑"><i class="layui-icon larry-icon larry-icon040"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-dengjipingdingguanli" title="等级评定管理"><i class="layui-icon larry-icon larry-dengjipingdingguanli"></i></a>
                </div>
            </div>

            <div class="layui-inline" style="margin-bottom: 0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-gongzuoneirong" title="工作内容"><i class="layui-icon larry-icon larry-gongzuoneirong"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-icwindowzoom48px" title="全屏"><i class="layui-icon larry-icon larry-icwindowzoom48px"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-gengxin" title="更新"><i class="layui-icon larry-icon larry-gengxin"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shuaxin4" title="刷新"><i class="layui-icon larry-icon larry-shuaxin4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontbiaodandingyi" title="表单定义"><i class="layui-icon larry-icon larry-iconfontbiaodandingyi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-chongfuzhaopian" title="重复图片"><i class="layui-icon larry-icon larry-chongfuzhaopian"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xitonghuancun" title="系统缓存"><i class="layui-icon larry-icon larry-xitonghuancun"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-databasesql" title="database-sql"><i class="layui-icon larry-icon larry-databasesql"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-youqinglianjie" title="友情链接"><i class="layui-icon larry-icon larry-youqinglianjie"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-jiankong" title="监控"><i class="layui-icon larry-icon larry-jiankong"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-chaxun4" title="查询"><i class="layui-icon larry-icon larry-chaxun4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-wenjianguanli" title="文件管理"><i class="layui-icon larry-icon larry-wenjianguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfontpinglun" title="评论"><i class="layui-icon larry-icon larry-iconfontpinglun"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-chaxun2" title="查询"><i class="layui-icon larry-icon larry-chaxun2"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-configuration-theme" title="配置主题"><i class="layui-icon larry-icon larry-configuration-theme"></i></a>
                </div>
            </div>
            <div class="layui-inline" style="margin-bottom:0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xiugaimima" title="修改密码"><i class="layui-icon larry-icon larry-xiugaimima"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-xitongshezhi1" title="系统设置"><i class="layui-icon larry-icon larry-xitongshezhi1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconfonthuishouzhan" title="删除"><i class="layui-icon larry-icon larry-iconfonthuishouzhan"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-bianji4" title="回收站"><i class="layui-icon larry-icon larry-bianji4"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-dianzan1" title="点赞"><i class="layui-icon larry-icon larry-dianzan1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-daohanglanmu" title="导航栏目"><i class="layui-icon larry-icon larry-daohanglanmu"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-guanggaolianmeng" title="广告联盟"><i class="layui-icon larry-icon larry-guanggaolianmeng"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-shenheguanli" title="审核管理"><i class="layui-icon larry-icon larry-shenheguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-linshi" title="临时"><i class="layui-icon larry-icon larry-linshi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-daimaguanli" title="代码管理"><i class="layui-icon larry-icon larry-daimaguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tequanneirong" title="特权内容"><i class="layui-icon larry-icon larry-tequanneirong"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tupianguanli" title="图片管理"><i class="layui-icon larry-icon larry-tupianguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-zhandianguanli" title="站点管理"><i class="layui-icon larry-icon larry-zhandianguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-dengji" title="等级"><i class="layui-icon larry-icon larry-dengji"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-moxing" title="模型"><i class="layui-icon larry-icon larry-moxing"></i></a>
                </div>
            </div>

            <div class="layui-inline" style="margin-bottom:0px;">
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-pingjiaguanli1" title="评价管理"><i class="layui-icon larry-icon larry-pingjiaguanli1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-yonghuliebiao" title="用户列表"><i class="layui-icon larry-icon larry-yonghuliebiao"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-iconguanggaoguanli" title="广告管理"><i class="layui-icon larry-icon larry-iconguanggaoguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-diannao" title="电脑"><i class="layui-icon larry-icon larry-diannao"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-fabu" title="发布"><i class="layui-icon larry-icon larry-fabu"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-tihuan" title="替换"><i class="layui-icon larry-icon larry-tihuan"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-jueseguanli" title="角色管理"><i class="layui-icon larry-icon larry-jueseguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-kechengguanli" title="课程管理"><i class="layui-icon larry-icon larry-kechengguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-gonggaoguanli" title="公告管理"><i class="layui-icon larry-icon larry-gonggaoguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-quanxianguanli" title="权限管理"><i class="layui-icon larry-icon larry-quanxianguanli"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-hrrq_xtrz" title="系统日志"><i class="layui-icon larry-icon larry-hrrq_xtrz"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-weixingongzhongpingtai" title="微信公众平台"><i class="layui-icon larry-icon larry-weixingongzhongpingtai"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-caidanguanli1" title="菜单管理"><i class="layui-icon larry-icon larry-caidanguanli1"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-neirongfenxi" title="内容分析"><i class="layui-icon larry-icon larry-neirongfenxi"></i></a>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <a class="select_img" data-id="larry-guanli" title="管理"><i class="layui-icon larry-icon larry-guanli"></i></a>
                </div>
            </div>

        </div>
    </form>
    </div>
</fieldset>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form','layer','jquery','common'],function(){
        var $ = layui.$,
                form = layui.form,
                common = layui.common,
                layer = layui.layer;

        /**选择图标*/
        $("body").on("dblclick",".select_img",function(){
            //得到当前iframe层的索引
            var index = parent.layer.getFrameIndex(window.name);
            //赋值
            var resImage = $(this).attr("data-id");
            $('#resImage', window.parent.document).val(resImage);
            parent.layer.close(index); //执行关闭
        });




    });
</script>
</body>
</html>