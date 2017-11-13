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
        div : {url : "Sys/plugin/SysConfig/SysUpdateLogManage/SysUpdateLogManage.html"
            , js: []
            , css: [ ]
            , id: "body"
        }
        ,active:{
            addSysUpdateLog : function () {
                layui.$.post('Sys/plugin/SysConfig/AddSysUpdateLog/AddSysUpdateLog.html', {}, function(str){
                    var index = layer.open({
                        type: 1
                        ,title: '添加日志'
                        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                        ,id: 'addSysUpdateLog' //防止重复弹出
                        ,content: str
                        ,shade: 0 //不显示遮罩
                        ,offset: '50px'
                        ,skin: 'layui-layer-molv'
                    });
                    Fv.ajax.loadJs(["Sys/plugin/SysConfig/AddSysUpdateLog/AddSysUpdateLog.js"]);
                });
            }
        }
    }
}();
Fv.plugin.SysUpdateLogManage.start = function () {
    $('#SystemUpdatingLogManage').on('click', function () {
        var loading = Fv.config.layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
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
                    Fv.config.layer.close(loading);
                    main.unauthorized();
                    return;
                }
                layui.$('.demoTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.SysUpdateLogManage.init.active[type] ? Fv.plugin.SysUpdateLogManage.init.active[type].call(this) : '';
                });
                Fv.config.layer.close(loading);
            }
            , function () {
                Fv.config.layer.close(loading);
                layui.layer.msg("加载失败");
            }
        )
    });
}();


