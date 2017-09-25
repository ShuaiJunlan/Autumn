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

    <link rel="stylesheet" href="${ctx}/static/tree/tree.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">


    <script src="${ctx}/static/layui_v2/layui.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${ctx}/static/tree/tree.min.js" ></script>
    <script type="text/javascript" src="${ctx}/static/tree/extend.tree.js" ></script>


</head>
<body style="font-size:12px;">
<fieldset class="layui-elem-field">
    <legend  style="font-size: 12px;color:#FF5722;">请选择菜单信息</legend>
    <div class="layui-field-box" style="height: 375px; overflow: auto;">
        <ul id="resourceTree"></ul>
    </div>
</fieldset>
<input id="roleId" type="hidden"  value="${role.roleId}" >
<div class="layui-form-item" style="text-align: center;">
    <button class="layui-btn" id="saveRoleGrant">保存</button>
    <button type="layui-btn" id="cancle" class="layui-btn layui-btn-primary">取消</button>
</div>




<script type="text/javascript">
    var resourceTree;
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['tree', 'layer','form','common'], function() {
        var $ = layui.$,
                form = layui.form,
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer;

        //加载菜单资源信息
        initResourceAllTree();



        /**角色菜单信息保存*/
        $("#saveRoleGrant").click(function(){
            //角色Id
            var roleId = $("#roleId").val();
            var checknodes = resourceTree.tree('getCheckedExt');
            //资源Id
            var resourceIds = [];
            if (checknodes && checknodes.length > 0) {
                for ( var i = 0; i < checknodes.length; i++) {
                    resourceIds.push(checknodes[i].id);
                }
            }
            var roleGranLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

            $.ajax({
                url : '${ctx}/role/ajax_save_role_res.do',
                type : 'post',
                async: false,
                data : {
                    roleId:roleId,
                    resourceIds:resourceIds
                },
                success : function(data) {
                    if(data.returnCode == 0000){
                        top.layer.close(roleGranLoading);
                        common.cmsLaySucMsg("角色授权信息保存成功")
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(roleGranLoading);
                        common.cmsLayErrorMsg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(roleGranLoading);
                }
            });

        });
        //取消
        $("#cancle").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });
    });


    /**获取所有有效的资源菜单*/
    function initResourceAllTree(){
        resourceTree =  $('#resourceTree').tree({
            url:'${ctx}/role/ajax_resource_tree_list.do',
            parentField : 'pid',
            checkbox : true,
            cascadeCheck : false,
            lines : true,
            cache:false,
            onCheck: function (node,checked) {
                if(checked){
                    var parentNode = resourceTree.tree('getParent', node.target);
                    if(parentNode != null){
                        resourceTree.tree('check', parentNode.target);
                    }

                }else{
                    var childNode = resourceTree.tree('getChildren', node.target);
                    if (childNode.length > 0) {
                        for (var i = 0; i < childNode.length; i++) {
                            resourceTree.tree('uncheck', childNode[i].target);
                        }
                    }
                }
            },
            onLoadSuccess : function(node, data) {
                //取得后台传递的资源ID的值
                var ids = $.stringToList('${role.resourceIds}');
                if (ids.length > 0) {
                    for ( var i = 0; i < ids.length; i++) {
                        if (resourceTree.tree('find', ids[i])) {
                            resourceTree.tree('check', resourceTree.tree('find', ids[i]).target);
                        }
                    }
                }
            }
        });
    }

</script>
</body>
</html>