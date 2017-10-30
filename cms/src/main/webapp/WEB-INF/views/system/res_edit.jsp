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
</head>
<body class="childrenBody" style="font-size: 12px;margin: 10px 10px 0;">
<%--<blockquote class="layui-elem-quote layui-quote-nm"--%>
        <%--style="border-radius:0.25em;color: #31708f;background-color: #d9edf7;border-width:1px; padding:6px; border-color:#bce8f1;">--%>
        <%--温馨提示:1.菜单类型为菜单时父级菜单可以为空;2.菜单类型为按钮时父级菜单不能为空;3.父级菜单选中时，资源路径不能为空--%>
<%--</blockquote>--%>
<form class="layui-form layui-form-pane">
    <input id="resId" name="resId" type="hidden" value="${res.resId}">

    <input id="pageFlag"  type="hidden" value="${pageFlag}">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-inline">
                <input type="text" id="resName" name="resName" class="layui-input" maxlength="20" value="${res.resName}" lay-verify="required|resName" placeholder="请输入菜单名称">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">菜单类型</label>
            <div class="layui-input-inline">
                <select id="resType" name="resType" lay-filter="resTypeFilter" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="0">0-菜单</option>
                    <option value="1">1-按钮</option>
                </select>
            </div>
        </div>


    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜单级别</label>
            <div class="layui-input-inline">
                <select id="resLevel" name="resLevel" lay-filter="resLevelFilter" lay-verify="required">
                    <option value="">请选择</option>
                    <option value="1">一级菜单</option>
                    <option value="2">二级菜单</option>
                    <option value="3">三级菜单</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">父级菜单</label>
            <div class="layui-input-inline">
                <select id="resParentid" name="resParentid" lay-verify="resParentid">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">菜单路径</label>
            <div class="layui-input-inline">
                <input type="text" id="resLinkAddress" name="resLinkAddress" class="layui-input" maxlength="50" lay-verify="resLinkAddress"  value="${res.resLinkAddress}">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">菜单图标</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="resImage" name="resImage" lay-verify="required" value="${res.resImage}" disabled>
            </div>
            <div class="layui-form-mid layui-word-aux">
                <a class="layui-btn layui-btn-mini select_img" data-id="" title="选择图标"><i class="layui-icon larry-icon larry-tupianguanli"></i></a>'
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">菜单状态</label>
            <div class="layui-input-inline" style="border: 1px solid #e6e6e6;background-color: #fff;height: 36px;">
                <c:if test="${pageFlag == 'addPage' }">
                    <input type="radio" name="resStatus" value="0" title="有效" checked disabled>
                    <input type="radio" name="resStatus" value="1" title="失效" disabled>
                </c:if>
                <c:if test="${pageFlag == 'updatePage' and  res.resStatus == '0' }">
                    <input type="radio" name="resStatus" value="0" title="有效"  disabled <c:if test="${res.resStatus ==0 }">checked</c:if>/>
                    <input type="radio" name="resStatus" value="1" title="失效" disabled  <c:if test="${res.resStatus ==1 }">checked</c:if>/>
                </c:if>
                <c:if test="${pageFlag == 'updatePage' and  res.resStatus == '1' }">
                    <input type="radio" name="resStatus" value="0" title="有效"   <c:if test="${res.resStatus ==0 }">checked</c:if>/>
                    <input type="radio" name="resStatus" value="1" title="失效"   <c:if test="${res.resStatus ==1 }">checked</c:if>/>
                </c:if>

            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">排序</label>
            <div class="layui-input-inline">
                <input type="text" id="resDisplayOrder" name="resDisplayOrder" class="layui-input" lay-verify="resDisplayOrder" maxlength="10" value="${res.resDisplayOrder}">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea id="resRemark" name="resRemark" placeholder="请输入内容" class="layui-textarea" maxlength="50" style="resize:none;min-height:40px;">${res.resRemark}</textarea>
        </div>
    </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
        <button class="layui-btn" lay-submit="" lay-filter="saveRes">保存</button>
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


        /**菜单新增初始化*/
        resInit();

        /***菜单新增初始化**/
        function resInit(){
            var pageFlag = $("#pageFlag").val();
            if(pageFlag == "addPage"){
                //默认菜单级别不可点击
                $("#resLevel").attr("disabled","disabled");
            }
            //更新标识
            if(pageFlag == "updatePage"){
                 resTypeVal = ${res.resType}
                 resLevelVal = ${res.resLevel}
                 resParentIdVal = ${res.resParentid}
                 resParentCount = ${resParentCount}

                //菜单类型选中，不能点击
                $("#resType option[value='"+resTypeVal+"']").prop("selected","selected");
                $("#resType").attr("disabled","disabled");

                //菜单级别选中
                $("#resLevel option[value='"+resLevelVal+"']").prop("selected","selected");
                if(resTypeVal == 1 || (resTypeVal == 0 && resParentCount > 0)){
                    $("#resLevel").attr("disabled","disabled");

                }
                if(resLevelVal == 1){
                    $("#resLinkAddress").val('');
                    $("#resLinkAddress").attr("disabled","disabled");
                }


                //加载父级菜单
                loadParentMenu();

                $("#resParentid option[value='"+resParentIdVal+"']").prop("selected","selected");



            }

            form.render('select');
        }
        /**监听菜单类型选择*/
        form.on('select(resTypeFilter)', function(data){
            //如果菜单类型为按钮, 菜单级别选中三级菜单,并禁用选择
            if(data.value == 1){
                $("#resLevel option[value='3']").prop("selected","selected");
                $("#resLevel").attr("disabled","disabled");
            }else{
                $('#resParentid option').not(":first").remove();
                $("#resLevel").removeAttr("disabled");
                $("#resLevel option:first").prop("selected", 'selected');
                $("#resLinkAddress").removeAttr("disabled","disabled");

            }
            form.render('select');

            //加载父级菜单
            loadParentMenu();
        });

        /**监听菜单级别选择*/
        form.on('select(resLevelFilter)', function(data){
            if(data.value == 1){
                $("#resLinkAddress").val('');
                $("#resLinkAddress").attr("disabled","disabled");
            }else{
                $("#resLinkAddress").removeAttr("disabled","disabled");

            }
            //加载父级菜单
            loadParentMenu();

        });

        /**加载父级菜单*/
        function loadParentMenu(resType,resLevel){
            var resType =  $("#resType option:selected").val();
            var resLevel =  $("#resLevel option:selected").val();
            var resId = $("#resId").val();

            if(resType != "" && resLevel != "" ){
                //1级菜单、父级菜单为空
                if(resLevel == 1){
                    $('#resParentid option').not(":first").remove();
                    form.render('select');
                    return;
                }
                //加载父级菜单
                $.ajax({
                    url : '${ctx}/res/ajax_res_parent_menu.do',
                    type : 'post',
                    async: false,
                    data : {
                        resType:resType,
                        resLevel:resLevel,
                        resId:resId
                    },
                    success : function(data) {
                        if(data != "" ){
                            $('#resParentid option').not(":first").remove();
                            $(data).each(function(index,item){
                                $("#resParentid").append(
                                        '<option value="'+item.resId+'">'+item.resName+'</option>'
                                );


                            });

                        }
                    }
                });
                form.render('select');


            }


        }

        /**选择图标*/
        $(".select_img").click(function(){
            var url = "${ctx}/res/res_img.do";
            common.cmsLayOpen('选择图标',url,'485px','370px');
        });

        /**表单验证*/
        form.verify({
            resName: function(value, item){
                //验证菜单名称
                if(!new RegExp("^[0-9a-zA-Z\u4e00-\u9fa5]+$").test(value)){
                    return '菜单名称只能为中文数字或者字母';
                }

            },
            resParentid:function(value,item){
                //验证父级菜单
                var  resLevel = $("#resLevel").val();
                if((resLevel == 2 || resLevel == 3)&& value == ''){
                    return '父级菜单不能为空';
                }
            },
            resLinkAddress: function(value, item){
                //验证菜单路径
                var  resLevel = $("#resLevel").val();
                resParentCount = ${resParentCount};

                if((resLevel == 2 || resLevel == 3)&& value == '' && resParentCount <0){
                    return '菜单路径不能为空';
                }
                if(value != '' && !new RegExp("^[a-zA-Z_/.]+$").test(value)){
                    return '菜单路径只能为英文下划线斜杠和点';
                }

            },
            resDisplayOrder: function(value, item){
                //验证排序
                if(value != '' && !new RegExp("^[0-9]*$").test(value)){
                    return '排序只能为数字';
                }

            }
        });


        /**保存菜单资源信息*/
        form.on("submit(saveRes)",function(data){
            var resSaveLoading = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
            $.ajax({
                url : '${ctx}/res/ajax_save_resource.do',
                type : 'post',
                async: false,
                data : data.field,
                success : function(data) {
                    if(data.returnCode == 0000){
                        location.reload();
                        top.layer.close(resSaveLoading);
                        common.cmsLaySucMsg("保存成功")
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        parent.location.reload();



                    }else{
                        top.layer.close(resSaveLoading);
                        common.cmsLayErrorMsg(data.returnMessage);
                    }
                },error:function(data){
                    top.layer.close(resSaveLoading);
                    top.layer.close(index);

                }
            });
            return false;
        })


        /**取消*/
        $("#cancle").click(function(){
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });

    });

</script>
</body>
</html>