/**
 * Created by Mr SJL on 2017/11/5.
 */
layui.use('form', function(){
    var form = layui.form;
    form.render();

    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
    // $('#menu_level').on("click", function () {
    //     alert("lll");
    // })
});
