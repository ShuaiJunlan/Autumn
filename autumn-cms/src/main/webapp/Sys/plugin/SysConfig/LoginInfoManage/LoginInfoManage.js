/**
 * Created by Mr SJL on 2017/10/31.
 */
namespace("Fv.plugin.LoginInfoManage");
Fv.plugin.LoginInfoManage = function () {
    return {
        init : Fv.plugin.LoginInfoManage.init
        , start : Fv.plugin.LoginInfoManage.start
    }
}();
Fv.plugin.LoginInfoManage.init = function () {
    return{
        div : {url : "/Sys/plugin/SysConfig/LoginInfoManage/LoginInfoManage.html", js: [], css: [], id: "body"}
        ,active : {

        }
    };
}();
Fv.plugin.LoginInfoManage.start = function () {

    $('#LoginInfoManage').on('click', function () {
        var loading = Fv.config.layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
        Fv.ajax.loadDiv(
            Fv.plugin.LoginInfoManage.init.div
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
                Fv.plugin.LoginInfoManage.addElementModule();
                Fv.plugin.LoginInfoManage.addFormModule();
                Fv.plugin.LoginInfoManage.addLoginInfoData('/log/allLoginLog/');
                layui.$('.demoTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.LeftMenuManage.init.active[type] ? Fv.plugin.LeftMenuManage.init.active[type].call(this) : '';
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

Fv.plugin.LoginInfoManage.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    $('.layui-tab-title li').on('click', function(){
        var othis = $(this), type = othis.data('type');
        Fv.plugin.LoginInfoManage.init.active[type] ? Fv.plugin.LoginInfoManage.init.active[type].call(this, othis) : '';
    });
};

Fv.plugin.LoginInfoManage.addFormModule = function () {
    Fv.config.form.render();
}

Fv.plugin.LoginInfoManage.addLoginInfoData = function (url) {
    Fv.config.table.render({
        id : "loginlog_table"
        ,elem : '#loginlog_table'
        ,url : url
        ,where : {
        }
        ,cols: [[
            {checkbox: true, LAY_CHECKED: true}
            ,{field: 'id', title:'ID', width: 70, sort:true}
            ,{field: 'user_login_name', title:'登录名', width:100}
            ,{field: 'ip', title:'ip', width:130, sort:true}
            ,{field: 'country', title:'国家', width:100}
            ,{field: 'area', title:'地区', width:60}
            ,{field: 'region', title:'省份', width:100}
            ,{field: 'city', title:'城市', width:100}
            ,{field: 'isp', title:'运营商', width:120}
            ,{field: 'visit_time', title:'访问时间', width:180, sort:true}
            ,{fixed: 'right', width:120, align:'center', toolbar: '#bar'}
        ]]
        ,limits: [10,30,60,90,150]
        ,limit: 10
        ,response: {
            statusCode:"1111"
        }
        ,page : true
        ,even: true
        ,done: function(){
            // layer.close(loading);
            layer.msg('数据加载完成');
        }
    })

    //监听表格复选框选择
    Fv.config.table.on('checkbox(loginInfo)', function(obj){
        console.log(obj)
    });
    
    //监听工具条
    Fv.config.table.on('tool(loginInfo)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('确定删除么？', function(index){
                layer.close(index);
            });
        }
    });
}