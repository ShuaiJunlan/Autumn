
layui.config({
    base : "/static/js/"
}).use(['jquery', 'common','layer','element','bodyTab'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        element = layui.element ,  //导航的hover效果、二级菜单等功能，需要依赖element模块
        tab = layui.bodyTab()
        ;



    //退出
    $('#logout').on('click', function () {
        var url = '/logout.do';
        common.logOut('退出登陆提示！', '你真的确定要退出系统吗？', url)
    })
    // 添加新窗口
    $("body").on("click",".layui-left-nav .layui-nav-item a",function(){
        tab.tabAdd($(this));
        $(this).parent("li").siblings().removeClass("layui-nav-itemed");

        //$(this).parent("li").siblings().removeClass("layui-nav-itemed");
    });

    /**打开或隐藏选项卡*/
    $(".side-menu-switch").click(function () {
        $(".layui-layout-admin").toggleClass("showMenu");
        $(".layui-body,.layui-footer").css("left", ($(".layui-layout-admin").hasClass("showMenu")) ? "0" : "203px")
    });

    /**关闭当前*/
    $(".closeCurrent").on("click",function(){
        if($("#top_tabs li").length>1 && $("#top_tabs li.layui-this cite").text()!="后台首页"){
            var menu = JSON.parse(window.sessionStorage.getItem("menu"));
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != '' && $(this).hasClass("layui-this")){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    //此处将当前窗口重新获取放入session，避免一个个删除来回循环造成的不必要工作量
                    for(var i=0;i<menu.length;i++){
                        if($("#top_tabs li.layui-this cite").text() == menu[i].title){
                            menu.splice(0,menu.length,menu[i]);
                            window.sessionStorage.setItem("menu",JSON.stringify(menu));
                        }
                    }
                }
            });
        }else{
            top.layer.msg('首页不能关闭',{icon: 0});
        }
    });

    /**关闭其他*/
    $(".closeOther").on("click",function(){
        if($("#top_tabs li").length>2 && $("#top_tabs li.layui-this cite").text()!="后台首页"){
            var menu = JSON.parse(window.sessionStorage.getItem("menu"));
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    //此处将当前窗口重新获取放入session，避免一个个删除来回循环造成的不必要工作量
                    for(var i=0;i<menu.length;i++){
                        if($("#top_tabs li.layui-this cite").text() == menu[i].title){
                            menu.splice(0,menu.length,menu[i]);
                            window.sessionStorage.setItem("menu",JSON.stringify(menu));
                        }
                    }
                }
            });
        }else if($("#top_tabs li.layui-this cite").text()=="后台首页" && $("#top_tabs li").length>1){
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    window.sessionStorage.removeItem("menu");
                    menu = [];
                    window.sessionStorage.removeItem("curmenu");
                }
            })
        }else{
            top.layer.msg('没有可关闭的窗口',{icon: 0});
        }

    });
    /**关闭全部*/
    $(".closeAll").on("click",function(){
        if($("#top_tabs li").length > 1 ){
            $("#top_tabs li").each(function(){
                if($(this).attr("lay-id") != ''){
                    element.tabDelete("bodyTab",$(this).attr("lay-id")).init();
                    window.sessionStorage.removeItem("menu");
                    menu = [];
                    window.sessionStorage.removeItem("curmenu");
                }
            })
        }else{
            top.layer.msg('没有可关闭的窗口',{icon: 0});
        }
    })

    $('#dianzhan').click(function (event) {
        layer.open({
            type: 1,
            title: false,
            closeBtn: true,
            shadeClose: false,
            shade: 0.15,
            area: ['500px', '357px'],
            content: '<img src="/static/img/dianzhan.jpg"/>'
        })
    });


    $('#refresh_iframe').on('click', function () {

        $(".layui-tab-content .layui-tab-item").each(function () {
            if ($(this).hasClass('layui-show')) {
                $(this).children('iframe')[0].contentWindow.location.reload(true)
            }
        })

    });



});
