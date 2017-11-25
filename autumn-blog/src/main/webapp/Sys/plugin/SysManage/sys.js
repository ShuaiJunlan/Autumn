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
            //监听提交
            var submit_count = 0;
            Fv.config.form.on('submit(makeSuggestion)', function (data) {
                var loading = layer.msg('正在发给管理员，稍等下哦...', {icon: 16, time: false, shade: 0.5});
                if (submit_count > 3) {
                    layer.msg("请不要频发送!");
                    layer.close(loading);
                    return;
                }
                var data = {
                    content: data.field.content
                    , email: data.field.email
                };
                Fv.ajax.post("/send/admin/", data, function (data) {
                        submit_count++;
                        layer.close(loading);
                        if (data.code == '1111') {
                            layer.msg("发送成功！");
                            layer.close(index);
                        } else if (data.code == '0000') {
                            layer.msg("发送失败!")
                        }
                    }
                    , function () {
                        layer.close(loading);
                        layer.msg("系统异常!");
                    });
            })
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
            //监听提交
            var submit_count = 0;
            Fv.config.form.on('submit(makeSuggestion)', function (data) {
                var loading = layer.msg('正在发给管理员，稍等下哦...', {icon: 16, time: false, shade: 0.5});
                if (submit_count > 3) {
                    layer.msg("请不要频发送!");
                    layer.close(loading);
                    return;
                }
                var data = {
                    content: data.field.content
                    , email: data.field.email
                };
                Fv.ajax.post("send/admin/", data, function (data) {
                        submit_count++;
                        layer.close(loading);
                        if (data.code == '1111') {
                            layer.msg("发送成功！");
                            layer.close(index);
                        } else if (data.code == '0000') {
                            layer.msg("发送失败!")
                        }
                    }
                    , function () {
                        layer.close(loading);
                        layer.msg("系统异常!");
                    });
            })
        });
    }

})