/**
 * Created by Mr SJL on 2017/9/3.
 */
var main = {
    init : function(data){
        login_name = data.login_name;
        user_img = data.user_image_url
    },
    menu : {
        /**
         * the data style must be [[{name : "name", url : "url},
         *                          {name1 : "name1", url : "url1"}
         *                          ]...]
         * @param data
         */
        left_menu : function (data, left_menu_id) {
            if (data == null || data.length == 0)
                return;
            var menu = "";
            for (var  i = 0; i < data.length; i++) {
                var level_one = "<li class=\"layui-nav-item layui-icon\">\n" +
                    "<a class=\"left_menu\" href=\""+ data[i].href +"\">" +'<span class= \"left_menu_icon\" >'+ data[i].icon +  '  </span>'+ data[i].menu_name +"</a>";

                if (data[i].child_num > 0){
                    var level_two = "<dl class=\"layui-nav-child\">";
                    var temp_;
                    for (var j = 0; j < data[i].child_num; j++){
                        temp_ =  "<dd><a id=\""+ data[i].childes[j].href +"\" class=\"left_child_menu\">" + data[i].childes[j].menu_name +"</a></dd>";
                        level_two += temp_;
                    }
                    level_one += level_two;
                    level_one += "</dl></li>";
                    menu += level_one;
                    continue;
                }
                level_one += "</li>";
                menu += level_one;
            }
            $(left_menu_id).html(menu);
        },

        top_menu : function (data, top_menu_id) {
            if (data == null || data.length == 0)
                return;
            var menu = "";
            for (var  i = 0; i < data.length; i++) {
                var level_one = "<li class=\"layui-nav-item\">\n" +
                    "                <a href=\""+ data[i].href +"\">"+ data[i].menu_name +"</a>";
                if (data[i].child_num > 0){
                    var level_two = "<dl class=\"layui-nav-child\">";
                    var temp_;
                    for (var j = 0; j < data[i].child_num; j++){
                        temp_ = "<dd><a href=\""+ data[i].childes[j].href +"\">"+ data[i].childes[j].menu_name +"</a></dd>";
                        level_two += temp_;
                    }
                    level_one += level_two;
                    level_one += "</dl></li>";
                    menu += level_one;
                    continue;
                }
                level_one += "</li>";
                menu += level_one;
            }
            $(top_menu_id).html(menu);
        }
    },
    buttom : function () {

    }
    ,unauthorized : function () {
        //示范一个公告层
        Fv.config.layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['残忍离开']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 30px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' +
            '403-unauthorized<br>您知道吗？亲！<br>' +
            '<br>很遗憾您没有此功能访问权限。<br>' +
            '<br>想获得此功能访问权限吗？<br>' +
            '<br>那就快快联系管理员吧！' +
            '<br>shuaijunlan(at)gmail.com</div>'
            ,success: function(layero){
            }
        });
    }

}
