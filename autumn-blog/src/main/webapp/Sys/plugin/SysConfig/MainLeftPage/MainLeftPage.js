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
    var loading = Fv.config.layer.msg('加载中', {
        icon: 16
        ,shade: 0.5
    });
    var div = {url : "Sys/plugin/SysConfig/MainLeftPage/MainLeftPage.html", js: [], css: [], id: "mainPageLeft"}

    Fv.ajax.loadDiv(
        div
        ,function (data, a) {
            $("#" + a.id).html(data);

            Fv.ajax.syncGet("blog/list", {},function (data) {
                    var article_item = {url : "Sys/plugin/SysConfig/ArticleItem/ArticleItem.html", js: [], css: [], id: "article_item"}
                    Fv.ajax.loadDiv(article_item, function (item, a) {
                            var str = "";
                            for (var i = 0; i < data.count; i++){
                                var img_base64 = Fv.plugin.MainLeftPage.getHashByName(data.data[i].username);
                                str += item
                                    .replace("{user-name}", data.data[i].username)
                                    .replace("{article-title}", data.data[i].title)
                                    .replace("{visit-times}", data.data[i].visit_times)
                                    .replace("{time}", Fv.plugin.MainLeftPage.timeAgo(data.data[i].time))
                                    .replace("{article-link}", "blog/getBlogByIdD/" + data.data[i].id)
                                    .replace("{user-image-base64}", img_base64)
                                    .replace("{zan-times}", 0)
                                    .replace("{comment-times}", 0);
                            }
                            $("#" + a.id).html(str);
                        }
                        ,function () {
                        });
                }
                ,function () {
                }
            );
            Fv.config.layer.close(loading);
        }
        ,function () {
            Fv.config.layer.close(loading);
        }
    );
}();
//dateTimeStamp是一个时间毫秒，注意时间戳是秒的形式，在这个毫秒的基础上除以1000，就是十位数的时间戳。13位数的都是时间毫秒。
Fv.plugin.MainLeftPage.timeAgo = function(dateTimeStamp){
    var minute = 1000 * 60;      //把分，时，天，周，半个月，一个月用毫秒表示
    var hour = minute * 60;
    var day = hour * 24;
    var week = day * 7;
    var halfamonth = day * 15;
    var month = day * 30;
    var now = new Date().getTime();   //获取当前时间毫秒
    console.log(now)
    var diffValue = now - dateTimeStamp;//时间差

    if(diffValue < 0){
        return;
    }
    var minC = diffValue/minute;  //计算时间差的分，时，天，周，月
    var hourC = diffValue/hour;
    var dayC = diffValue/day;
    var weekC = diffValue/week;
    var monthC = diffValue/month;
    if(monthC >= 1 && monthC <= 12){
        result = " " + parseInt(monthC) + "月前"
    }else if(weekC >= 1 && weekC <= 4){
        result = " " + parseInt(weekC) + "周前"
    }else if(dayC >= 1 && dayC <= 7){
        result = " " + parseInt(dayC) + "天前"
    }else if(hourC >= 1 && hourC <= 24){
        result = " " + parseInt(hourC) + "小时前"
    }else if(minC >= 1 && minC <= 60){
        result =" " + parseInt(minC) + "分钟前"
    }else if(diffValue >= 0 && diffValue <= minute){
        result = "刚刚"
    }else {
        var datetime = new Date();
        datetime.setTime(dateTimeStamp);
        var Nyear = datetime.getFullYear();
        var Nmonth = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
        var Ndate = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
        var Nhour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
        var Nminute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
        var Nsecond = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
        result = Nyear + "-" + Nmonth + "-" + Ndate
    }
    return result;
};
Fv.plugin.MainLeftPage.getHashByName = function (username) {
    var salt = 0;
    var rounds = 1;
    var size = 168;
    var shaObj = new jsSHA(username+salt, "TEXT");
    var hash = shaObj.getHash("SHA-512", "HEX",rounds);
    var data = new Identicon(hash, size).toString();
    console.log(hash);
    return data;
};
