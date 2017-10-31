/**
 * Created by Mr SJL on 2017/9/5.
 */
var table;
$('#MenuManage').on('click', function () {

    var div = {
        url : "/Sys/plugin/SysConfig/MenuManage/LeftMenuManage.html"
        , js: []
        , css: []
        , id: "body"
    }
    Fv.ajax.loadDiv(
        div
        , function () {         //  successful 成功回调
            addElementModule();
            addMenuData(1, 'leftMenu', '01', '/menu/getMenuList/');
            layui.$('.demoTable .layui-btn').on('click', function(){
                var type = $(this).data('type');
                active[type] ? active[type].call(this) : '';
            });
        }
        , function () {         //  fail 失败回调
            layui.layer.msg("加载失败")
        }
    )
});
var active = {
    switch_level_one: function () {
        var level = 1;
        addMenuData(level, 'leftMenu', '01', '/menu/getMenuList/');
    }
    ,switch_level_two: function () {
        var level = 2;
        addMenuData(level, 'leftMenu', '01', '/menu/getMenuList/');
    }
    ,getCheckData: function(){ //获取选中数据
        var checkStatus = table.checkStatus('menu_table')
            ,data = checkStatus.data;
        layer.alert(JSON.stringify(data));
    }
    ,getCheckLength: function(){ //获取选中数目
        var checkStatus = table.checkStatus('menu_table')
            ,data = checkStatus.data;
        layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
        var checkStatus = table.checkStatus('menu_table');
        layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
    ,addMenu : function () {

        //Ajax获取
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
};
var addElementModule = function () {
    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('docDemoTabBrief', layid);

        element.on('tab(docDemoTabBrief)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
}


var addMenuData = function (level, type, sys, url) {
    layui.use('table', function(){
        table = layui.table;
        // table.render();
        var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
        table.render({
            id : "menu_table"
            ,elem : '#menu_table'
            ,url : url
            ,where :
                {level : level
                    ,type : type
                    ,sys : sys}
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
            ,even: true //开启隔行背景
            ,done: function(res, curr, count){
                top.layer.close(loading);
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                console.log(res);

                //得到当前页码
                console.log(curr);

                //得到数据总量
                console.log(count);
            }
        })

        //监听表格复选框选择
        table.on('checkbox(menu)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(menu)', function(obj){
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

    });
}
