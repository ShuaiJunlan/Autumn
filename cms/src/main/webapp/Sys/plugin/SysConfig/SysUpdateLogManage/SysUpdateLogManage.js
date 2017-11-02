/**
 * Created by Mr SJL on 2017/11/1.
 */
namespace("Fv.plugin.SysUpdateLogManage");

Fv.plugin.SysUpdateLogManage = function () {
    return{
        init : Fv.plugin.SysUpdateLogManage.init
        ,start : Fv.plugin.SysUpdateLogManage.start
    }
}();
Fv.plugin.SysUpdateLogManage.init = function () {
    return{
        div : {url : "/Sys/plugin/SysConfig/SysUpdateLogManage/SysUpdateLogManage.html"
            , js: []
            , css: [ ]
            , id: "body"
        }
    }
}();
Fv.plugin.SysUpdateLogManage.start = function () {
    $('#SystemUpdatingLogManage').on('click', function () {
        Fv.ajax.loadDiv(
            Fv.plugin.SysUpdateLogManage.init.div
            , function (data, a) {
                var data1;
                try {
                    data1 = JSON.parse(data);
                }catch(err) {
                    console.log("请求成功")
                }finally {
                    $("#" + a.id).html(data);
                }
                if (data1 != undefined && data1.code != undefined && data1.code == "3333"){
                    main.unauthorized();
                    return;
                }
            }
            , function () {
                layui.layer.msg("加载失败")
            }
        )
    });
}();
var testEditormd;


