layui.define(["jquery", "layer"], function (e) {
    var o = layui.jquery, layer = layui.layer, d = {
        column: 0,
        retract: 16,
        icon: ["&#xe623;", "&#xe625;"],
        iconClass: "layui-icon",
        icD: ".layui-icon",
        topId: 0,
    }, i = function (e) {
        this.options = e
    };
    i.prototype.init = function (e) {
        e.find("tbody tr").each(function (i, c) {
            var t = o(c), pid = t.data("tb-pid"), ic = e.find("tbody tr[data-tb-pid='" + t.data("tb-id") + "']").length, icH = '<i class="' + d.iconClass + '">' + (ic ? d.icon[0] : "") + "</i>", px = e.find("tbody tr[data-tb-id='" + pid + "']").find(d.icD).css("margin-left");
            pid == d.topId || t.hide();
            t.find("td").eq(d.column).prepend(icH);
            t.find(d.icD).css("margin-left", (parseInt(px) + d.retract) + "px")
        });
        this.on(e)
    }, i.prototype.packup = function (e, pid) {
        var t = this;
        e.find("tbody tr[data-tb-pid='" + pid + "']").each(function () {
            o(this).hide().find(d.icD).removeClass("sopen").html(o(this).find(d.icD).html() ? d.icon[0] : "");
            t.packup(e, o(this).data("tb-id"))
        })
    }, i.prototype.on = function (e) {
        var t = this;
        e.find("tbody tr").on("click", "td", function () {
            var ico = o(this).find(d.icD), id = o(this).parents("tr").data("tb-id");
            if (ico.length > 0 && ico.html()) {
                var isO = ico.hasClass("sopen");
                isO ? t.packup(e, id) : e.find("tbody tr[data-tb-pid='" + id + "']").show();
                ico.toggleClass("sopen").html(ico.html() ? d.icon[isO ? 0 : 1] : "");
                return false
            }
        })
    };
    e("tabletree", function (e) {
        var r = new i(e = e || {}), t = o(e.elem);
        return t[0] ? void r.init(t) : layer.alert("没有找到" + e.elem + "元素")
    })
});