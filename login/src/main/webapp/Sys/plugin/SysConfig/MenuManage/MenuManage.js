/**
 * Created by Mr SJL on 2017/9/5.
 */
$('#MenuManage').on('click', function () {
    // if ($("#body").hasChildNodes())
    $.ajaxSetup ({
        cache: false //关闭AJAX相应的缓存
        ,async:false
    });
    $("#body").empty();
    $("#body").load('/Sys/plugin/SysConfig/MenuManage/MenuManage.html');
    layui.use('table', function(){
        var level = 1;
        var table = layui.table;

        table.render({
            id : "menu_table"
            ,elem : '#menu_table'
            ,url : '/menu/getMenuList/'
            ,where : {level : level}
            // ,height : 423
            // ,width : 1166
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
                ,{fixed: 'right', width:150, align:'center', toolbar: '#bar'} //这里的toolbar值是模板元素的选择器
            ]]
            ,limits: [10,30,60,90,150,300]
            ,limit: 10
            ,page : true
            //  table style
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

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
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
                $.post('/Sys/plugin/SysConfig/AddMenu/AddMenu.html', {}, function(str){
                    layer.open({
                        type: 1
                        ,title : "添加菜单"
                        ,skin: 'layui-layer-rim' //加上边框
                        // area: [a], //宽高
                        ,content : str
                        ,btn : ['确定', '取消']
                        // ,zIndex : -1
                        ,btn1 : function () {
                            layer.msg("添加成功！");
                        }
                        ,btn2 : function () {
                            layer.msg("取消提交！")
                        }
                    });
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
})

//页面层

