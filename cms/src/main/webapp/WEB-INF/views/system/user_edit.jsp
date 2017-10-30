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

    <script src="${ctx}/static/layui_v2/layui.js"></script>

</head>
<body class="childrenBody" style="font-size: 12px;margin: 10px 10px 0;">
<form class="layui-form layui-form-pane">
    <input id="userId" name="userId" type="hidden" value="${user.userId}">

    <input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
        <label class="layui-form-label">登陆账号</label>
        <div class="layui-input-block">
            <c:if test="${pageFlag == 'addPage' }">
             <input type="text" class="layui-input" name="userLoginName" lay-verify="required|userLoginName" maxlength="20" value="" placeholder="请输入登陆账号">
            </c:if>
            <c:if test="${pageFlag == 'updatePage' }">
                <input type="text" class="layui-input" name="userLoginName" lay-verify="required|userLoginName" maxlength="20"  value="${user.userLoginName}" placeholder="请输入登陆账号" disabled>
            </c:if>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户姓名</label>
        <div class="layui-input-block">
            <input type="text" class="layui-input" name="userName" lay-verify="required|userName" maxlength="20" value="${user.userName}" placeholder="请输入用户姓名">
        </div>
    </div>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">用户状态</label>
        <div class="layui-input-block">
            <c:if test="${pageFlag == 'addPage' }">
                <input type="radio" name="userStatus" value="0" title="有效" checked disabled>
                <input type="radio" name="userStatus" value="1" title="失效" disabled>
            </c:if>
            <c:if test="${pageFlag == 'updatePage' and  user.userStatus == '0' }">
                <input type="radio" name="userStatus" value="0" title="有效"  disabled <c:if test="${user.userStatus ==0 }">checked</c:if>/>
                <input type="radio" name="userStatus" value="1" title="失效" disabled  <c:if test="${user.userStatus ==1 }">checked</c:if>/>
            </c:if>
            <c:if test="${pageFlag == 'updatePage' and  user.userStatus == '1' }">
                <input type="radio" name="userStatus" value="0" title="有效"   <c:if test="${user.userStatus ==0 }">checked</c:if>/>
                <input type="radio" name="userStatus" value="1" title="失效"   <c:if test="${user.userStatus ==1 }">checked</c:if>/>
            </c:if>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
            <button class="layui-btn" lay-submit="" lay-filter="saveUser">保存</button>
            <button type="layui-btn" id="cancle" class="layui-btn layui-btn-primary">取消</button>

    </div>
</form>
<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form','layer','jquery','common'],function(){
        var $ = layui.$,
                form = layui.form,
                common = layui.common,
                layer = parent.layer === undefined ? layui.layer : parent.layer;

        /**表单验证*/
        form.verify({
            userLoginName: function(value, item){
                //验证登陆账号
                if(!new RegExp("^[0-9A-Za-z_]{2,20}$").test(value)){
                    return '登陆账号只能为英文、数字、下划线，长度2-20位';
                }
                //验证登陆账号是否存在

            },
            userName: function(value, item){
                //验证用户名
                if(!new RegExp("^([\u4e00-\u9fa5]){2,10}$").test(value)){
                    return '用户姓名只能为中文，长度2-7位';
                }
            }
        });

        /**保存*/
        form.on("submit(saveUser)",function(data){
            var pageFlag = $("#pageFlag").val();
            var userSaveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            //登陆验证
            $.ajax({
                url : '${ctx}/user/ajax_save_user.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.returnCode == 0000){
                        top.layer.close(userSaveLoading);
                        if(pageFlag == 'addPage'){
                            common.cmsLaySucMsg("保存成功,默认密码123456,请及时修改")
                        }else {
                            common.cmsLaySucMsg("保存成功")
                        }
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }else{
                        top.layer.close(userSaveLoading);
                        common.cmsLayErrorMsg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(index);

                }
            });
            return false;
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