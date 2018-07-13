namespace("Fv.plugin.ArticleList");
Fv.plugin.ArticleList = function () {
    return{
        init : Fv.plugin.ArticleList.init
        ,start: Fv.plugin.ArticleList.start
    }
}();
Fv.plugin.ArticleList.init = function () {
    return{
        div: {url : "Sys/plugin/SysConfig/ArticleList/ArticleList.html", js: [], css: [], id: "body"}
        ,active:{
        }
    }
}();
Fv.plugin.ArticleList.start = function () {
    $('#ArticleList').on('click', function () {
        var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0});
        Fv.ajax.loadDiv(
            Fv.plugin.ArticleList.init.div
            , function (data, a) {
                var data1;
                try {
                    data1 = JSON.parse(data);
                }catch(err) {
                    console.log("请求成功")
                }finally {
                    $("#" + a.id).html(data);
                }
                if (data1 !== undefined && data1.code !== undefined && data1.code === "3333"){
                    Fv.config.layer.close(loading);
                    main.unauthorized();
                    return;
                }
                Fv.plugin.ArticleList.addElementModule();
                Fv.plugin.ArticleList.addFormModule();
                Fv.plugin.ArticleList.addArticleData('manage/article/list/');
                layui.$('.layui-inline .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    Fv.plugin.ArticleList.init.active[type] ? Fv.plugin.ArticleList.init.active[type].call(this) : '';
                });
                Fv.config.layer.close(loading);
            }
            , function () {
                Fv.config.layer.close(loading);
                layui.layer.msg("加载失败")
            }
        )
    });
}();

Fv.plugin.ArticleList.addElementModule = function () {
    var $ = layui.jquery; //Tab的切换功能，切换事件监听等，需要依赖element模块

    $('.layui-tab-title li').on('click', function(){
        var othis = $(this), type = othis.data('type');
        Fv.plugin.LoginInfoManage.init.active[type] ? Fv.plugin.LoginInfoManage.init.active[type].call(this, othis) : '';
    });
};

Fv.plugin.ArticleList.addFormModule = function () {
    Fv.config.form.render();
}
Fv.plugin.ArticleList.addArticleData = function (url) {
    // var loading = layer.msg('数据加载中，请稍后', {icon: 16, time: false, shade: 0.5});
    Fv.config.table.render({
        id : "article_table"
        ,elem : '#article_table'
        ,url : url
        ,where : {
        }
        ,cols: [[
            {checkbox: true, LAY_CHECKED: true}
            ,{field: 'visit_id', title:'ID', width: 200, sort:true}
            ,{field: 'user_name', title:'作者', width:100}
            ,{field: 'post_time', title:'发表时间', width:150}
            ,{field: 'title', title:'标题', width:200}
            ,{field: 'visit_times', title:'访问次数', width:160}
            ,{field: 'state', title:'状态', width:70}
            ,{fixed: 'right', width:170, align:'center', toolbar: '#bar'}
        ]]
        ,limits: [10,30,60,90,150]
        ,limit: 10
        ,response: {
            statusCode:"1111"
        }
        ,page : false
        ,even: true
        ,done: function(){
            // layer.close(loading);
            layer.msg('数据加载完成');
        }
    });

    //监听表格复选框选择
    Fv.config.table.on('checkbox(article)', function(obj){
        console.log(obj)
    });

    //监听工具条
    Fv.config.table.on('tool(article)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){

            window.open('https://shuaijunlan.cn/autumn-blog/article/' + data.visit_id);
        } else if(obj.event === 'del'){
            layer.confirm('确定删除么？', function(index){
                layer.close(index);
            });
        }
    });
}