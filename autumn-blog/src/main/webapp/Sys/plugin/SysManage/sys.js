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
                Fv.ajax.loadJs(["Sys/plugin/SysConfig/ShareArticle/ShareArticle.js"]);
                layer.msg('编辑器只支持Markdown语法,且无法在手机端编写文章', {time: 6000, icon:6});

            }
        )
    }();

    Fv.ajax.get("init.do", {}, function (data) {
            $("#username").append(data.username);
            Fv.config.user = data;

        }
        ,function () {
            layer.alert("System Exception, Please contact manager!", {
                icon : 2
            })
        }
    );



    Fv.logout = function () {
        window.top.location.href="logout.do";;
    };
    Fv.share = function () {
        layui.$.post('Sys/plugin/SysConfig/ShareArticle/ShareArticle.html', {}, function (str) {
            Fv.config.layer.open({
                type: 1
                , title: "分享文章"
                , offset: 'auto'
                , area: []
                , id: 'shareArticle'
                , content: str
                , shade: 0.4
                , skin: 'layui-layer-molv'
            });
            Fv.config.form.render();

        });

    }

});