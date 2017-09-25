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
    <link rel="stylesheet" href="${ctx}/static/css/global.css">

    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <script src="${ctx}/static/layui_v2/layui.js"></script>


<body>
<div class="larry-grid layui-anim layui-anim-upbit larryTheme-A">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote mylog-info-tit">
                <div class="layui-inline">
                    <form class="layui-form" id="roleSearchForm">
                        <div class="layui-input-inline" style="width:110px;">
                            <select name="searchTerm" >
                                <option value="roleNameTerm">角色名称</option>
                            </select>
                        </div>
                        <div class="layui-input-inline" style="width:145px;">
                            <input type="text" name="searchContent" value="" placeholder="请输入关键字" class="layui-input search_input">
                        </div>
                        <a class="layui-btn roleSearchList_btn" lay-submit lay-filter="roleSearchFilter"><i class="layui-icon larry-icon larry-chaxun7"></i>查询</a>
                    </form>
                </div>
                <shiro:hasPermission name="nxRVZA5i">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-normal  roleAdd_btn"> <i class="layui-icon larry-icon larry-xinzeng1"></i>新增角色</a>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="oCNcsKmk">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-normal excelRoleExport_btn"  style="background-color:#5FB878"> <i class="layui-icon larry-icon larry-danye"></i>导出</a>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="qsieHTy4">
                    <div class="layui-inline">
                        <a class="layui-btn layui-btn-danger roleBatchFail_btn"><i class="layui-icon larry-icon larry-shanchu"></i>批量失效</a>
                    </div>
                </shiro:hasPermission>

            </blockquote>
            <div class="larry-separate"></div>
            <!-- 角色列表 -->
            <div class="layui-tab-item  layui-show" style="padding: 10px 15px;">
                <table id="roleTableList" lay-filter="roleTableId"></table>
            </div>

        </div>
    </div>
</div>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'table', 'layer','common'], function () {
        var $ =  layui.$,
                form = layui.form,
                table = layui.table,
                layer = layui.layer,
                common = layui.common;

        /**角色表格加载*/
        var roleTableRender = table.render({
            elem: '#roleTableList',
            url: '${ctx}/role/ajax_role_list.do',
            id:'roleTableId',
            method: 'post',
            height:'400',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
                {checkbox: true,fixed:'left',},
                {field:'roleName', title: '角色名称',width: 120 },
                {field:'roleStatus', title: '角色状态',width: 90,templet: '#roleStatusTpl'},
                {field:'resourceNames', title: '菜单资源',width: 130},
                {field:'roleRemark', title: '角色说明',width: 120},
                {field:'creator', title: '创建人',width: 120},
                {field:'createTime', title: '创建时间',width: 150},
                {field:'modifier', title: '修改人',width: 120},
                {field:'modifierTime', title: '修改时间',width: 150},
                {fixed:'right', title: '操作', align:'center',width: 195, toolbar: '#roleBar'}

            ]],
            page: true,
            limit: 10//默认显示10条
        });

        /**查询*/
        $(".roleSearchList_btn").click(function(){
            //监听提交
            form.on('submit(roleSearchFilter)', function (data) {
                roleTableRender.reload({
                    where: {
                        searchTerm:data.field.searchTerm,
                        searchContent:data.field.searchContent
                    }
                });
            });

        });
        /**角色新增*/
        $(".roleAdd_btn").click(function(){
            var url = "${ctx}/role/role_add.do";
            common.cmsLayOpen('新增角色',url,'550px','340px');
        });


        /**导出角色信息*/
        $(".excelRoleExport_btn").click(function(){
            var url = '${ctx}/role/excel_role_export.do';
            $("#roleSearchForm").attr("action",url);
            $("#roleSearchForm").submit();
        });


        /**批量失效*/
        $(".roleBatchFail_btn").click(function(){

            //表格行操作
            var checkStatus = table.checkStatus('roleTableId');

            if(checkStatus.data.length == 0){
                common.cmsLayErrorMsg("请选择要失效的角色信息");
            }else{
                var roleStatus = false;
                var roleIds = [];
                $(checkStatus.data).each(function(index,item){
                    roleIds.push(item.roleId);
                    //角色已失效
                    if(item.roleStatus == 0){
                        roleStatus = true;
                    }else{
                        roleStatus = false;
                        return false;
                    }
                });

                if(roleStatus==false){
                    common.cmsLayErrorMsg("当前选择的角色已失效");
                    return false;
                }
                var url = "${ctx}/role/ajax_role_batch_fail.do";
                var param = {roleIds:roleIds};
                common.ajaxCmsConfirm('系统提示', '失效角色、解除角色、用户、菜单绑定关系?',url,param);

            }
        });

        /**监听工具条*/
        table.on('tool(roleTableId)', function(obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

            //修改角色
            if(layEvent === 'role_edit') {
                var roleId = data.roleId;
                var url = "${ctx}/role/role_update.do?roleId="+roleId;
                common.cmsLayOpen('编辑角色',url,'550px','340px');

            //角色授权
            }else if(layEvent === 'role_grant'){

                var roleId = data.roleId;
                var roleStatus = data.roleStatus;
                if(roleStatus == 1){
                    common.cmsLayErrorMsg("当前角色已失效,不能授权");
                    return false;
                }
                var url =  "${ctx}/role/role_grant.do?roleId="+roleId;
                common.cmsLayOpen('角色授权',url,'255px','520px');


            //角色失效
            }else if(layEvent === 'role_fail') {
                var roleId = data.roleId;
                var roleStatus = data.roleStatus;
                if(roleStatus == 1){
                    common.cmsLayErrorMsg("当前角色已失效");
                    return false;
                }

                var url = "${ctx}/role/ajax_role_fail.do";
                var param = {roleId:roleId};
                common.ajaxCmsConfirm('系统提示', '失效角色、解除角色、用户、菜单绑定关系?',url,param);

            }
        });
    });


</script>

<!-- 角色状态tpl-->
<script type="text/html" id="roleStatusTpl">

    {{# if(d.roleStatus == 0){ }}
    <span class="label label-success ">0-有效</span>
    {{# } else if(d.roleStatus == 1){ }}
    <span class="label label-danger ">1-失效</span>
    {{# } else { }}
    {{d.roleStatus}}
    {{# }  }}
</script>


<!--工具条 -->
<script type="text/html" id="roleBar">
    <div class="layui-btn-group">
        <shiro:hasPermission name="moHbdnjz">
            <a class="layui-btn layui-btn-mini role_edit" lay-event="role_edit"><i class="layui-icon larry-icon larry-bianji2"></i> 编辑</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="bSG7LAmU">
            <a class="layui-btn layui-btn-mini layui-btn-warm  role_grant" lay-event="role_grant"><i class="layui-icon larry-icon larry-jiaoseguanli3"></i>权限</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="tkwJk34z">
            <a class="layui-btn layui-btn-mini layui-btn-danger role_fail" lay-event="role_fail"><i class="layui-icon larry-icon larry-ttpodicon"></i>失效</a>
        </shiro:hasPermission>
    </div>
</script>


</body>
</html>