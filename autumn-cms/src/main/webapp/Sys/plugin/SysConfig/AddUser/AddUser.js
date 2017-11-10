/**
 * Created by Mr SJL on 2017/11/5.
 */
namespace("Fv.plugin.AddUser");
Fv.plugin.AddUser = function () {
    return{
        init: Fv.plugin.AddUser.init
        ,start: Fv.plugin.AddUser.start
    }
}();
Fv.plugin.AddUser.init = function () {
    return {

    };
}();
Fv.plugin.AddUser.start = function () {
    Fv.config.form.render();
    //监听提交
    Fv.config.form.on('submit(addUser)', function(data){
        if (data.field.password != data.field.repassword){
            layer.msg("密码不一致")
        }else {
            var user = {
                username : data.field.username
                ,user_login_name : data.field.user_login_name
                ,password : data.field.password
                ,creator : Fv.config.user.username
                ,creator_id : Fv.config.user.id
                ,modifier : Fv.config.user.username
                ,modifier_id : Fv.config.user.id
                ,status : data.field.status == '有效' ? 1 : 0
            }
            Fv.ajax.post("/user/insert/", user, function (data) {
                if (data.code == '1111'){
                    layer.msg("添加成功");
                    Fv.config.form.render(null, "addUser");
                }else if (data.code == '0000'){
                    layer.msg("添加失败")
                }else if (data.code == '5000'){
                    layer.msg("登录名已存在")
                }
            }
            ,function () {
                    layer.msg("系统异常")
            });
        }
        return false;
    });
}();
