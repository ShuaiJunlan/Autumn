/**
 * Created by Mr SJL on 2017/9/5.
 */
$('#MenuManage').on('click', function () {
    $.ajaxSetup ({
        cache: false //关闭AJAX相应的缓存
        ,async:false
    });
    $("#body").load('/Sys/plugin/SysConfig/MenuManage/MenuManage.html');
    addMenuData(1, 'leftMenu', '01');
})
var active = {
    switch_level_one: function () {
        var level = 1;
        addMenuData(level, 'leftMenu', '01');
    }
    ,switch_level_two: function () {
        var level = 2;
        addMenuData(level, 'leftMenu', '01');
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

var addMenuData = function (level, type, sys) {
    layui.use('table', function(){
        var table = layui.table;
        table.render();

        table.render({
            id : "menu_table"
            ,elem : '#menu_table'
            ,url : '/menu/getMenuList/'
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

        layui.$('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });
}
