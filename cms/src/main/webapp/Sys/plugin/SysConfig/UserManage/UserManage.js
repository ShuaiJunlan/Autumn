/**
 * Created by Mr SJL on 2017/11/5.
 */
namespace("Fv.plugin.UserManage");
Fv.plugin.UserManage = function () {
    return{
        init : Fv.plugin.UserManage.init
        ,start: Fv.plugin.UserManage.start
    }
}();
Fv.plugin.UserManage.init = function () {
    return{
        div: {url : "/Sys/plugin/SysConfig/UserManage/UserManage.html", js: [], css: [], id: "body"}
        ,active:{
            addUser: function () {
                layui.$.post('/Sys/plugin/SysConfig/AddUser/AddUser.html', {}, function(str){
                    var index = layer.open({
                        type: 1
                        ,title: '添加用户'
                        ,offset: 'auto'
                        ,id: 'addUserLayer'
                        ,content: str
                        ,shade: 0
                        ,skin: 'layui-layer-molv'
                    });
                    Fv.ajax.loadJs(["/Sys/plugin/SysConfig/AddUser/AddUser.js"]);
                });
            }
        }
    }
}();
Fv.plugin.UserManage.start = function () {
    $('#UserManage').on('click', function () {
        Fv.ajax.loadDiv(
            Fv.plugin.UserManage.init.div
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
                Fv.plugin.UserManage.addElementModule();
                Fv.plugin.UserManage.addFormModule();
                Fv.plugin.UserManage.addUserData('/user/getAllUser/');
                layui.$('.layui-inline .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.UserManage.init.active[type] ? Fv.plugin.UserManage.init.active[type].call(this) : '';
                });
            }
            , function () {
                layui.layer.msg("加载失败")
            }
        )
    });
}();

Fv.plugin.UserManage.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    $('.layui-tab-title li').on('click', function(){
        var othis = $(this), type = othis.data('type');
        Fv.plugin.LoginInfoManage.init.active[type] ? Fv.plugin.LoginInfoManage.init.active[type].call(this, othis) : '';
    });
};

Fv.plugin.UserManage.addFormModule = function () {
    Fv.config.form.render();
}
Fv.plugin.UserManage.addUserData = function (url) {
    // var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
    Fv.config.table.render({
        id : "user_table"
        ,elem : '#user_table'
        ,url : url
        ,where : {
        }
        ,cols: [[
            {checkbox: true, LAY_CHECKED: true}
            ,{field: 'id', title:'ID', width: 70, sort:true}
            ,{field: 'user_login_name', title:'登录名', width:80}
            ,{field: 'username', title:'用户名', width:80}
            ,{field: 'password', title:'密码', width:100}
            ,{field: 'status', title:'状态', width:70}
            ,{field: 'creator', title:'创建者', width:80}
            ,{field: 'create_time', title:'创建时间', width:180}
            ,{field: 'modifier', title:'修改者', width:80}
            ,{field: 'modifier_time', title:'修改时间', width:180}
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
    Fv.config.table.on('checkbox(menu)', function(obj){
        console.log(obj)
    });

    //监听工具条
    Fv.config.table.on('tool(user)', function(obj){
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