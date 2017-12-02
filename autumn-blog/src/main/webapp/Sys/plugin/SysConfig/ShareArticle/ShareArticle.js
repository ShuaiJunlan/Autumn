/**
 * Created by Mr SJL on 2017/11/13.
 */
namespace("Fv.plugin.ShareArticle");
Fv.plugin.ShareArticle = function () {
    return{
        init: Fv.plugin.ShareArticle.init
        ,start: Fv.plugin.ShareArticle.start
    }
}();
Fv.plugin.ShareArticle.init = function () {
    return {

    };
}();
Fv.plugin.ShareArticle.start = function () {
    Fv.config.form.render();
    //监听提交
    Fv.config.form.on('submit(shareArticle)', function(data){

            var blogDetail = {
                username: Fv.config.user.username
                , title: data.field.title
                , content_md: Fv.config.blog.content_md
                , content_html: Fv.config.blog.content_html
            }
            Fv.ajax.post("blog/shareBlog/", blogDetail, function (data) {
                    if (data.code == '1111'){
                        Fv.config.layer.closeAll("page");
                        layer.confirm("https://shuaijunlan.cn/autumn-blog/blog/getBlogByIdD/" + data.data, {icon: 3, title:'提示'}, function(index){

                            layer.close(index);
                        });

                    }else if (data.code == '5000'){
                        layer.msg("登录名已存在")
                    }else {
                        layer.msg("注册失败，请稍后再试");
                    }
                }
                ,function () {
                    layer.msg("系统异常")
                });
    });
}();
