/**
 * Created by Mr SJL on 2017/9/4.
 */
$(function () {
    layui.use(['layer', 'element', 'table', 'form', 'layedit', 'laydate'], function(){
        Fv.config.layer = layui.layer;
        Fv.config.element = layui.element;
        Fv.config.table = layui.table;
        Fv.config.form = layui.form;
        Fv.config.layedit = layui.layedit;
        Fv.config.laydate = layui.laydate;
    });

    var sys = "01";
    Fv.ajax.syncGet("/sys/getMenu/" + sys,
        {}
        , function (data) {

            if (data != undefined && data.code != undefined && data.code == "3333"){
                alert("您没有访问权限");
                return;
            }
            main.menu.left_menu(data, "#left_menu");

            Fv.ajax.loadJs(["/Sys/plugin/SysConfig/LeftMenuManage/LeftMenuManage.js"]);
            Fv.ajax.loadJs(["/Sys/plugin/SysConfig/LoginInfoManage/LoginInfoManage.js"]);
            Fv.ajax.loadJs(["/Sys/plugin/SysConfig/SysUpdateLogManage/SysUpdateLogManage.js"]);
            Fv.ajax.loadJs(["/Sys/plugin/SysConfig/UserManage/UserManage.js"]);
            Fv.ajax.loadJs(["/Sys/plugin/SysConfig/MakeSuggestion/MakeSuggestion.js"]);

        },
        function () {
            layer.alert("System Exception, Please contact manager!", {
                icon : 2
            })
        }
    );


    Fv.ajax.get("/init.do", {}, function (data) {
            $("#username").append(data.username);
            Fv.config.user = data;
        }
        ,function () {
            layer.alert("System Exception, Please contact manager!", {
                icon : 2
            })
        }
    )
})