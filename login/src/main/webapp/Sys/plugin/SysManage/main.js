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
                var level_one = "<li class=\"layui-nav-item\">\n" +
                    "                    <a class=\"\" href=\""+ data[i].href +"\">" + data[i].menu_name +"</a>";

                if (data[i].child_num > 0){
                    var level_two = "<dl class=\"layui-nav-child\">";
                    var temp_;
                    for (var j = 0; j < data[i].child_num; j++){
                        temp_ =  "<dd><a id=\""+ data[i].childes[j].href +"\">" + data[i].childes[j].menu_name +"</a></dd>";
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
}
