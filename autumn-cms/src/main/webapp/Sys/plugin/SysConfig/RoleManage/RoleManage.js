/**
 * Created by Mr SJL on 2017/11/10.
 */
namespace("Fv.plugin.RoleManage");
Fv.plugin.RoleManage = function () {
    return{
        init : Fv.plugin.RoleManage.init
        ,start : Fv.plugin.RoleManage.start
    }
}();
Fv.plugin.RoleManage.init = function () {
    return{
        div: {url : "Sys/plugin/SysConfig/RoleManage/RoleManage.html", js: [], css: [], id: "body"}
    }
}();
Fv.plugin.RoleManage.start = function () {
    $('#RoleManage').on('click', function () {
        var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0});
        Fv.ajax.loadDiv(
            Fv.plugin.RoleManage.init.div
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
                Fv.plugin.RoleManage.addElementModule();
                Fv.plugin.RoleManage.addFormModule();
                Fv.plugin.RoleManage.addRoleData('role/getAllRole/');
                // layui.$('.layui-inline .layui-btn').on('click', function(){
                //     var type = $(this).data('type');
                //     Fv.plugin.RoleManage.init.active[type] ? Fv.plugin.RoleManage.init.active[type].call(this) : '';
                // });
                Fv.config.layer.close(loading);
            }
            , function () {
                Fv.config.layer.close(loading);
                layui.layer.msg("加载失败");
            }
        )
    });
}();

Fv.plugin.RoleManage.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    // $('.layui-tab-title li').on('click', function(){
    //     var othis = $(this), type = othis.data('type');
    //     Fv.plugin.LoginInfoManage.init.active[type] ? Fv.plugin.LoginInfoManage.init.active[type].call(this, othis) : '';
    // });
};

Fv.plugin.RoleManage.addFormModule = function () {
    Fv.config.form.render();
}
Fv.plugin.RoleManage.addRoleData = function (url) {

    Fv.config.table.render({
        id : "role_table"
        ,elem : '#role_table'
        ,url : url
        ,where : {
        }
        ,cols: [[
            {checkbox: true, LAY_CHECKED: true}
            ,{field: 'id', title:'ID', width: 70, sort:true}
            ,{field: 'role_name', title:'角色名称', width:160}
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
            layer.msg('数据加载完成');
        }
    })

    //监听表格复选框选择
    Fv.config.table.on('checkbox(user)', function(obj){
        console.log(obj)
    });

    //监听工具条
    Fv.config.table.on('tool(role)', function(obj){
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
