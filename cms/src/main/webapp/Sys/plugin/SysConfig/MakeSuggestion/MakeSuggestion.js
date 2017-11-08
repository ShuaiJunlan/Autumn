/**
 * Created by Mr SJL on 2017/11/8.
 */
/**
 * Created by Mr SJL on 2017/11/5.
 */
namespace("Fv.plugin.MakeSuggestion");
Fv.plugin.MakeSuggestion = function () {
    return{
        init: Fv.plugin.MakeSuggestion.init
        ,start: Fv.plugin.MakeSuggestion.start
    }
}();
Fv.plugin.MakeSuggestion.init = function () {
    return {

    };
}();
Fv.plugin.MakeSuggestion.start = function () {

    $('#MakeSuggestion').on('click', function () {
        layui.$.post('/Sys/plugin/SysConfig/MakeSuggestion/MakeSuggestion.html', {}, function(str){
            var index = layer.open({
                type: 1
                ,title: '发表意见'
                ,offset: 'auto'
                ,area: ['450px']
                ,id: 'makeSuggestion'
                ,content: str
                ,shade: 0
                ,skin: 'layui-layer-molv'
            });
            Fv.config.form.render();
            //监听提交
            Fv.config.form.on('submit(makeSuggestion)', function(data){
                var data = {
                    content: data.field.content
                    ,email: data.field.email
                };
                Fv.ajax.post("/send/admin/", data, function (data) {
                        if (data.code == '1111'){
                            layer.msg("发送成功！");
                        }else if (data.code == '0000'){
                            layer.msg("发送失败!")
                        }
                    }
                    ,function () {
                        layer.msg("系统异常!")
                    });
            })
        });
    });


}();

