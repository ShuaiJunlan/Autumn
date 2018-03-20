var div = {url : "Sys/plugin/SysConfig/MainLeftPage/MainLeftPage.html", js: [], css: [], id: "mainPageLeft"}
$(document).ready(function () {
    Fv.ajax.loadDiv(div, function (data, a) {
            $("#" + a.id).html(data);
        }
        ,function () {

        });
});
