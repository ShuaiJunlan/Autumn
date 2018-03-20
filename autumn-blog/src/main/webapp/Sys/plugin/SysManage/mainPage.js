$(function() {
    var init = function () {
        layui.use(['layer', 'element', 'table', 'form', 'layedit', 'laydate'], function () {
                Fv.config.layer = layui.layer;
                Fv.config.element = layui.element;
                Fv.config.table = layui.table;
                Fv.config.form = layui.form;
                Fv.config.layedit = layui.layedit;
                Fv.config.laydate = layui.laydate;

                Fv.ajax.loadJs(["Sys/plugin/SysConfig/MainLeftPage/MainLeftPage.js"]);
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
    Fv.logout = function () {
        window.top.location.href="logout.do";;
    };
});