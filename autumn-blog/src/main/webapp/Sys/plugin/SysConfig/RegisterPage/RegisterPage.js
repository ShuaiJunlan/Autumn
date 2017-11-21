/**
 * Created by Mr SJL on 2017/11/13.
 */
namespace("Fv.plugin.RegisterPage");
Fv.plugin.RegisterPage = function () {
    return{
        init: Fv.plugin.RegisterPage.init
        ,start: Fv.plugin.RegisterPage.start
    }
}();
Fv.plugin.RegisterPage.init = function () {
    return {

    };
}();
Fv.plugin.RegisterPage.start = function () {
    Fv.config.form.render();
    //监听提交
    Fv.config.form.on('submit(RegisterPage)', function(data){
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
                ,status : 2
            }
            Fv.ajax.post("register/userRegister/", user, function (data) {
                    if (data.code == '1111'){
                        Fv.config.layer.closeAll("page");
                        layer.msg("添加成功，请刷新表格查看新添加的记录");
                        // Fv.config.form.render(null, "RegisterPage");

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
