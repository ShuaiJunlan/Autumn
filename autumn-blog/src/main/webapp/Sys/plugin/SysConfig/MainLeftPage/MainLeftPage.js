namespace("Fv.plugin.MainLeftPage");
Fv.plugin.MainLeftPage = function () {
    return{
        init: Fv.plugin.MainLeftPage.init
        ,start: Fv.plugin.MainLeftPage.start
    }
}();
Fv.plugin.MainLeftPage.init = function () {
    return {

    };
}();
Fv.plugin.MainLeftPage.start = function () {

    var div = {url : "Sys/plugin/SysConfig/MainLeftPage/MainLeftPage.html", js: [], css: [], id: "mainPageLeft"}

    Fv.ajax.loadDiv(div, function (data, a) {
            $("#" + a.id).html(data);
        }
        ,function () {

        }
    );

    Fv.ajax.get("blog/list/", {},function (data) {
        var article_item = {url : "Sys/plugin/SysConfig/ArticleItem/ArticleItem.html", js: [], css: [], id: "article_item"}
        Fv.ajax.loadDiv(article_item, function (item, a) {
            var str = "";
            for (var i = 0; i < data.count; i++){
                str += item
                    .replace("{user-name}", data.data[i].username)
                    .replace("{article-title}", data.data[i].title)
                    .replace("{visit-times}", data.data[i].visit_times)
                    .replace("{time}", data.data[i].time)
                    .replace("{article-link}", "blog/getBlogByIdD/" + data.data[i].id)
                    .replace("{user-image-link}", "https://avatars3.githubusercontent.com/u/13015473?s=460&v=4");
            }
            $("#" + a.id).html(str);
        }
        ,function () {


        });
        // alert(JSON.stringify(data));
    }
    ,function () {

    });
}();
