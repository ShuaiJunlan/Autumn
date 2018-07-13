$(function() {
    var init = function () {
        layui.use(['layer', 'element', 'table', 'form', 'layedit', 'laydate'], function () {
                Fv.config.layer = layui.layer;
                Fv.config.element = layui.element;
                Fv.config.table = layui.table;
                Fv.config.form = layui.form;
                Fv.config.layedit = layui.layedit;
                Fv.config.laydate = layui.laydate;

                Fv.ajax.loadJs(["Sys/plugin/SysConfig/MainLeftPage/MainLeftPage.js"]);
            }
        )
    }();

    Fv.logout = function () {
        window.top.location.href="logout.do";;
    };
    Fv.login = function () {

        layui.$.post('Sys/plugin/SysConfig/LoginPage/LoginPage.html', {}, function (str) {
            var index = layer.open({
                type: 1
                , title: '登录窗口'
                , offset: 'auto'
                , area: ['300px']
                , id: 'login'
                , content: str
                , shade: 0.6
                , skin: 'layui-layer-molv'
            });
            Fv.config.form.render();

            /**重新生成验证码*/
            function reqCaptcha() {
                var url = "captcha.do?nocache=" + new Date().getTime()
                $('.code img').attr("src",url)
            }
            /**点击验证码重新生成*/
            $('.code img').on('click', function () {
                reqCaptcha();
            });
            /**监听登陆提交*/
            Fv.config.form.on('submit(login)', function (data) {
                //弹出loading
                var loginLoading = top.layer.msg('登陆中，请稍候', {icon: 16, time: false, shade: 0.8});
                //记录ajax请求返回值
                var ajaxReturnData;

                //登陆验证
                $.ajax({
                    url: 'loginCheck.do',
                    type: 'post',
                    async: false,
                    data: data.field,
                    success: function (data) {
                        ajaxReturnData = data;
                    }
                });
                //登陆成功
                if (ajaxReturnData.code == 0000) {
                    Fv.ajax.get("init.do", {}, function (data) {
                            $("#username").html(data.username);
                            Fv.config.user = data;
                        }
                        ,function () {
                            layer.alert("System Exception, Please contact manager!", {
                                icon : 2
                            })
                        }
                    );
                    top.layer.close(loginLoading);
                    Fv.config.layer.close(index);
                    return false;
                } else if (ajaxReturnData.code == 4005){
                    layer.confirm('此账号没有进行验证，为保证您的数据安全，请您注册新的账号。', {icon: 3, title:'提示'});
                    reqCaptcha();
                    return false;
                } else {
                    top.layer.close(loginLoading);
                    reqCaptcha();
                    return false;
                }
            });

        });
    };
    Fv.register = function () {
        layui.$.post('Sys/plugin/SysConfig/RegisterPage/RegisterPage.html', {}, function (str) {
            var init = {
                username : 'admin'
                ,id : -1
            };
            layer.open({
                type: 1
                ,title: "新用户注册"
                ,shade: 0.6
                ,id: 'registerPage  ' //设定一个id，防止重复弹出
                ,btnAlign: 'c'
                ,moveType: 1 //拖拽模式，0或者1
                ,content: str
                , skin: 'layui-layer-molv'
                ,success: function(layero){
                }
            });
            Fv.config.form.render();
            Fv.config.form.on('submit(RegisterPage)', function(data){
                var loginLoading = layer.msg('注册中，请稍候...', {icon: 16, time: false, shade: 0.8});
                if (data.field.password != data.field.repassword){
                    layer.msg("两次密码不一致");
                    layer.close(loginLoading);
                }else {
                    var user = {
                        user_login_name : data.field.user_login_name
                        ,email : data.field.email
                        ,password : data.field.password
                        ,creator : init.username
                        ,creator_id : init.id
                        ,modifier : init.username
                        ,modifier_id : init.id
                        ,status : 2
                    }
                    Fv.ajax.post("register/userRegister/", user, function (data) {
                            if (data.code === '1111'){
                                layer.closeAll("page");
                                layer.confirm('请查收您的激活邮件(可能在垃圾箱中)，点击链接激活，否则无法使用此账号登录?', {icon: 1, title:'提示'});
                            }else if (data.code === '4001'){
                                layer.msg("邮件发送失败");
                            }else if (data.code === '5000'){
                                layer.msg("登录名已存在");
                            }else {
                                layer.msg("注册失败，请稍后再试");
                            }
                            layer.close(loginLoading);
                        }
                        ,function () {
                            layer.close(loginLoading);
                            layer.msg("系统异常");
                        });
                }
                return false;
            });
        })

    };
});

