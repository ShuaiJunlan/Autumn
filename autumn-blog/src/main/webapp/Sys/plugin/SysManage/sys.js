/**
 * Created by Mr SJL on 2017/9/4.
 */
$(function() {
    var init = function () {
        layui.use(['layer', 'element', 'table', 'form', 'layedit', 'laydate'], function () {
                Fv.config.layer = layui.layer;
                Fv.config.element = layui.element;
                Fv.config.table = layui.table;
                Fv.config.form = layui.form;
                Fv.config.layedit = layui.layedit;
                Fv.config.laydate = layui.laydate;

                Fv.ajax.loadJs(["Sys/plugin/SysConfig/RegisterPage/RegisterPage.js"]);
                Fv.ajax.loadJs(["Sys/plugin/SysConfig/LoginPage/LoginPage.js"]);
                Fv.config.user = {
                    username : 'admin'
                    ,id : -1
                };
            }
        )
    }();
    Fv.login = function () {

        layui.$.post('Sys/plugin/SysConfig/LoginPage/LoginPage.html', {}, function (str) {
            var index = layer.open({
                type: 1
                , title: '登录窗口'
                , offset: 'auto'
                , area: []
                , id: 'makeSuggestion'
                , content: str
                , shade: 0
                , skin: 'layui-layer-molv'
            });
            Fv.config.form.render();

        });
    };
    Fv.register = function () {
        layui.$.post('Sys/plugin/SysConfig/RegisterPage/RegisterPage.html', {}, function (str) {
            var index = layer.open({
                type: 1
                , title: '注册窗口'
                , offset: 'auto'
                , area: []
                , id: 'registerPage'
                , content: str
                , shade: 0
                , skin: 'layui-layer-molv'
            });
            Fv.config.form.render();
        });
    }
    Fv.logout = function () {
        window.top.location.href="logout.do";;
    }

})