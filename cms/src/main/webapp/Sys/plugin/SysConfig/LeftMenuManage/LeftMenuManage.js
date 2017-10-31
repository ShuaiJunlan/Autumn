/**
 * Created by Mr SJL on 2017/9/5.
 */
namespace("Fv.plugin.LeftMenuManage");
Fv.plugin.LeftMenuManage = function () {
    return{
        init : Fv.plugin.LeftMenuManage.init
        ,start : Fv.plugin.LeftMenuManage.start
        ,
    }
}();
Fv.plugin.LeftMenuManage.init = function () {
    return{
        div : {url : "/Sys/plugin/SysConfig/LeftMenuManage/LeftMenuManage.html", js: [], css: [], id: "body"}
        ,active : {
            switch_level_one: function () {
                var level = 1;
                Fv.plugin.LeftMenuManage.addMenuData(level, 'leftMenu', '01', '/menu/getMenuList/');
            }
            ,switch_level_two: function () {
                var level = 2;
                Fv.plugin.LeftMenuManage.addMenuData(level, 'leftMenu', '01', '/menu/getMenuList/');
            }
            ,getCheckData: function(){ //获取选中数据
                var checkStatus = Fv.config.table.checkStatus('menu_table')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = Fv.config.table.checkStatus('menu_table')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,addMenu : function () {
                layui.$.post('/Sys/plugin/SysConfig/AddMenu/AddMenu.html', {}, function(str){
                    layer.open({
                        type: 1
                        ,title: '添加菜单'
                        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                        ,id: 'addMenuLayer'+1 //防止重复弹出
                        ,content: str
                        ,shade: 0 //不显示遮罩
                    });
                    Fv.ajax.loadJs(["/Sys/plugin/SysConfig/AddMenu/AddMenu.js"]);
                });
            }
        }
    }
}();

Fv.plugin.LeftMenuManage.start = function () {
    $('#LeftMenuManage').on('click', function () {
        Fv.ajax.loadDiv(
            Fv.plugin.LeftMenuManage.init.div
            , function () {         //  successful 成功回调
                Fv.plugin.LeftMenuManage.addElementModule();
                Fv.plugin.LeftMenuManage.addMenuData(1, 'leftMenu', '01', '/menu/getMenuList/');
                layui.$('.demoTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.LeftMenuManage.init.active[type] ? Fv.plugin.LeftMenuManage.init.active[type].call(this) : '';
                });
            }
            , function () {         //  fail 失败回调
                layui.layer.msg("加载失败")
            }
        )
    });
}();

Fv.plugin.LeftMenuManage.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    $('.layui-tab-title li').on('click', function(){
        var othis = $(this), type = othis.data('type');
        Fv.plugin.LeftMenuManage.init.active[type] ? Fv.plugin.LeftMenuManage.init.active[type].call(this, othis) : '';
    });

    //Hash地址的定位
    var layid = location.hash.replace(/^#test=/, '');
    Fv.config.element.tabChange('docDemoTabBrief', layid);

    Fv.config.element.on('tab(docDemoTabBrief)', function(elem){
        location.hash = 'test='+ $(this).attr('lay-id');
    });
};


Fv.plugin.LeftMenuManage.addMenuData = function (level, type, sys, url) {
    // var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
    Fv.config.table.render({
        id : "menu_table"
        ,elem : '#menu_table'
        ,url : url
        ,where : {
            level : level
            ,type : type
            ,sys : sys
        }
        ,cols: [[
            {checkbox: true, LAY_CHECKED: true}
            ,{field: 'id', title:'ID', width: 100, sort:true}
            ,{field: 'sys', title:'系统号', width:100}
            ,{field: 'name', title:'菜单名称', width:100}
            ,{field: 'status', title:'菜单状态', width:100}
            ,{field: 'disporder', title:'排列顺序', width:100}
            ,{field: 'type', title:'菜单类型', width:100}
            ,{field: 'level', title:'菜单级别', width:100}
            ,{field: 'parent_name', title:'上级菜单', width:100}
            ,{fixed: 'right', width:200, align:'center', toolbar: '#bar'} //这里的toolbar值是模板元素的选择器
        ]]
        ,limits: [10,30,60,90,150]
        ,limit: 10
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
    Fv.config.table.on('tool(menu)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });
};
Fv.plugin.LeftMenuManage.destroy = function () {

};