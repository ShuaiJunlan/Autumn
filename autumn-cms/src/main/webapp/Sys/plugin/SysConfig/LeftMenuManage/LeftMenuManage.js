/**
 * Created by Mr SJL on 2017/9/5.
 */
namespace("Fv.plugin.LeftMenuManage");
Fv.plugin.LeftMenuManage = function () {
    return{
        init : Fv.plugin.LeftMenuManage.init
        ,start : Fv.plugin.LeftMenuManage.start
    }
}();
Fv.plugin.LeftMenuManage.init = function () {
    return{
        div : {url : "Sys/plugin/SysConfig/LeftMenuManage/LeftMenuManage.html", js: [], css: [], id: "body"}
        ,active : {
            switch_level_one: function () {
                var level = 1;
                Fv.plugin.LeftMenuManage.addMenuData(level, 'leftMenu', '01', 'menu/getMenuList/');
            }
            ,switch_level_two: function () {
                var level = 2;
                Fv.plugin.LeftMenuManage.addMenuData(level, 'leftMenu', '01', 'menu/getMenuList/');
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
                layui.$.post('Sys/plugin/SysConfig/AddMenu/AddMenu.html', {}, function(str){
                    var index = layer.open({
                        type: 1
                        ,title: '添加菜单'
                        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                        ,id: 'addMenuLayer'+1 //防止重复弹出
                        ,content: str
                        ,shade: 0 //不显示遮罩
                        ,skin: 'layui-layer-molv'
                    });
                    Fv.ajax.loadJs(["Sys/plugin/SysConfig/AddMenu/AddMenu.js"]);
                });
            }
        }
    }
}();

Fv.plugin.LeftMenuManage.start = function () {
    $('#LeftMenuManage').on('click', function () {
        var loading = Fv.config.layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
        Fv.ajax.loadDiv(
            Fv.plugin.LeftMenuManage.init.div
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
                Fv.plugin.LeftMenuManage.addElementModule();
                Fv.plugin.LeftMenuManage.addMenuData(1, 'leftMenu', '01', 'menu/getMenuList/');
                layui.$('.layui-inline .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.LeftMenuManage.init.active[type] ? Fv.plugin.LeftMenuManage.init.active[type].call(this) : '';
                });
                Fv.config.layer.close(loading);
            }
            , function () {         //  fail 失败回调
                Fv.config.layer.close(loading);
                layui.layer.msg("加载失败")
            }
        );
    });
}();

Fv.plugin.LeftMenuManage.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    $('.layui-tab-title li').on('click', function(){
        var othis = $(this), type = othis.data('type');
        Fv.plugin.LeftMenuManage.init.active[type] ? Fv.plugin.LeftMenuManage.init.active[type].call(this, othis) : '';
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
            ,{field: 'namec', title:'菜单名称', width:150}
            ,{field: 'status', title:'菜单状态', width:100}
            ,{field: 'disporder', title:'排列顺序', width:100}
            ,{field: 'type', title:'菜单类型', width:100}
            ,{field: 'level', title:'菜单级别', width:100}
            ,{field: 'parent_name', title:'上级菜单', width:100}
            ,{fixed: 'right', width:200, align:'center', toolbar: '#bar'} //这里的toolbar值是模板元素的选择器
        ]]
        ,limits: [10,30,60,90,150]
        ,limit: 10
        ,response: {
            statusCode:"1111"
        }
        ,page : true
        ,even: true
        ,loading: true
        ,done: function(res, curr, count){
            // if (res.code == "0000"){
            //     main.unauthorized();
            // }
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            console.log(res);

            //得到当前页码
            console.log(curr);

            //得到数据总量
            console.log(count);
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
            layer.confirm('确定删除么？', function(index){
                layer.close(index);
                var level = 0;      //  菜单级别
                if (obj.data.level == "1级菜单"){
                    level = 1;
                }else if (obj.data.level = "2级菜单"){
                    level = 2;
                }
                Fv.ajax.post("menu/deleteMenu/", {level:level, id:obj.data.id}, function (data) {
                    if (data.code == "1111"){
                        obj.del();
                        layer.msg("删除成功！");
                    }else if (data.code == "3333"){
                        main.unauthorized();
                    }
                })
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });
};
Fv.plugin.LeftMenuManage.destroy = function () {

};