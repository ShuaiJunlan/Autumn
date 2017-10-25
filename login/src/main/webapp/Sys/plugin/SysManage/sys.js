/**
 * Created by Mr SJL on 2017/9/4.
 */
$(function () {
    var layer;
    layui.use('layer', function(){
        layer = layui.layer;
    });
    var sys = "01"
    Fv.ajax.get("/sys/getMenu/" + sys, {}, function (data) {
        main.menu.left_menu(data, "#left_menu");
        main.menu.top_menu(data, "#top_menu");
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });
    },
    function () {
        layer.alert("System Exception, Please contact manager!", {
            icon : 2
        })
    })
})