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
    <link rel="stylesheet" href="${ctx}/static/css/main.css">


    <script src="${ctx}/static/layui_v2/layui.js"></script>

</head>
<body class="childrenBody" style="font-size: 12px;">
<div class="row" style="height:330px;overflow: auto;">
    <div class="sysNotice col" style="width: 49%;">
        <blockquote class="layui-elem-quote title">待分配的角色</blockquote>
        <div class="layui-form" style="height: 270px;  border: 1px solid #e2e2e2;">
            <table class="layui-table" style="border: 0px;" >
                <colgroup>
                    <col width="10">
                </colgroup>
                <tbody id="undistributedRole">
                </tbody>
            </table>
        </div>

    </div>
    <div style="width:20px;  position: absolute; top: 138px; left:240px;">
        <a id="selectRoleRight" title="右移" style="cursor: pointer"><i class="layui-icon" style="color:#009688;">&#xe602;</i></a>
        <a id="selectRoleLeft"  title="左移" style="cursor: pointer"><i class="layui-icon" style="color:#009688;">&#xe603;</i></a>
    </div>
    <div class="sysNotice col" style="width: 49%;margin-left: 8px;">
        <blockquote class="layui-elem-quote title">已分配的角色</blockquote>
        <div class="layui-form" style="height: 270px;  border: 1px solid #e2e2e2;">
            <table class="layui-table" style="border: 0px;" >
                <colgroup>
                    <col width="10">
                </colgroup>
                <tbody id="deceasedRole">


                </tbody>
            </table>
        </div>
    </div>
</div>
<input id="userIds"  name="userIds" type="hidden" value="${user.userId}">
<input id="roleIds" name="roleIds" type="hidden" value="${user.roleIds}">
<div class="layui-form-item" style="text-align: center;">
    <button class="layui-btn" id="saveRole">保存</button>
    <button type="layui-btn" id="cancle" class="layui-btn layui-btn-primary">取消</button>
</div>

<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form','layer','jquery','common'],function(){
        var $ = layui.$,
                form = layui.form,
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer;

        //查询待分配的角色
        getUndistributedRoleList();
        //查询已分配的角色*
        getDeceasedRolelist();

        /**查询待分配的角色*/
        function getUndistributedRoleList(){
            var pageLoading = layer.load(2);
            var roleIds = $("#roleIds").val();
            $.ajax({
                url : '${ctx}/user/ajax_undistributed_role_list.do',
                type : 'post',
                async: false,
                data :{
                    roleIds: roleIds
                },
                success : function(data) {
                    if (data != "") {
                        var pdata = $.parseJSON(data);
                        $(pdata.rows).each(function(index,item){
                            $("#undistributedRole").append(
                                    '<tr>'+
                                        '<td><input name="undistributed" lay-skin="primary" type="checkbox" alt="'+item.roleName+'"  value="'+item.roleId+'"></td>'+
                                        '<td>'+item.roleName+'</td>'+
                                    '</tr>'
                            );
                            form.render();

                        });

                    }
                    layer.close(pageLoading);

                },
                error: function() {
                    layer.close(pageLoading);

                }


            });

        }
        /**查询已分配的角色*/
        function getDeceasedRolelist(){
            var roleIds = $("#roleIds").val();
            //用户对应角色Id为空，则已分配角色为空
            if($.trim($("#roleIds").val())){
                var pageLoading = layer.load(2);
                $.ajax({
                    url : '${ctx}/user/ajax_deceased_role_list.do',
                    type : 'post',
                    async: false,
                    data :{
                        roleIds: roleIds
                    },
                    success : function(data) {
                        if(data != "" ){
                            var pdata = $.parseJSON(data);
                            $(pdata.rows).each(function(index,item){
                                $("#deceasedRole").append(
                                        '<tr>'+
                                        '<td><input name="deceased" lay-skin="primary" type="checkbox" alt="'+item.roleName+'" value="'+item.roleId+'"></td>'+
                                        '<td>'+item.roleName+'</td>'+
                                        '</tr>'
                                );
                                form.render();

                            });

                        }
                        layer.close(pageLoading);


                    },
                    error: function() {
                        layer.close(pageLoading);

                    }
                });
            }

        };
        /**角色选择右移*/
        $("#selectRoleRight").click(function(){

            if($("input:checkbox[name='undistributed']:checked").length > 0){
                $("input:checkbox[name='undistributed']:checked").each(function(){
                    var roleName = $(this).attr('alt');
                    var roleId = $(this).val();

                    $(this).parent().parent().closest('tr').remove();
                    $("#deceasedRole").append(
                            '<tr>'+
                            '<td><input name="deceased" lay-skin="primary" type="checkbox" alt="'+roleName+'" value="'+roleId+'"></td>'+
                            '<td>'+roleName+'</td>'+
                            '</tr>'
                    );
                    form.render();


                });
            }else{
                common.cmsLayErrorMsg("请选择需要分配的角色信息");
            }
        });

        /**角色选择左移*/
        $("#selectRoleLeft").click(function(){

            if($("input:checkbox[name='deceased']:checked").length > 0){
                $("input:checkbox[name='deceased']:checked").each(function(){
                    var roleName = $(this).attr('alt');
                    var roleId = $(this).val();

                    $(this).parent().parent().closest('tr').remove();
                    $("#undistributedRole").append(
                            '<tr>'+
                            '<td><input name="undistributed" lay-skin="primary" type="checkbox" alt="'+roleName+'" value="'+roleId+'"></td>'+
                            '<td>'+roleName+'</td>'+
                            '</tr>'
                    );
                    form.render();


                });
            }else{
                common.cmsLayErrorMsg("请选择需要移除的已分配角色信息");

            }
        });


        /**角色保存*/
        $("#saveRole").click(function(){
            //角色ID
            var ids = [];
            //得到全部已分配的角色Id
            $("input:checkbox[name='deceased']").each(function(){
                var roleId = $(this).val();
                ids.push(roleId);
            });

            $('#roleIds').val(ids);

            var userRoleLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});

            $.ajax({
                url : '${ctx}/user/ajax_save_user_role.do',
                type : 'post',
                async: false,
                data : {
                    userId:$('#userIds').val(),
                    roleIds:$('#roleIds').val()
                },
                success : function(data) {
                    if(data.returnCode == 0000){
                        top.layer.close(userRoleLoading);
                        common.cmsLaySucMsg("用户角色信息保存成功.")
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(userRoleLoading);
                        common.cmsLayErrorMsg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(userRoleLoading);

                }
            });

        });
        //取消
        $("#cancle").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });

    });

</script>
</body>
</html>