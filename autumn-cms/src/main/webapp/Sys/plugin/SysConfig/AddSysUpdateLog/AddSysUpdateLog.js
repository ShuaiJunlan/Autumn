/**
 * Created by Mr SJL on 2017/11/3.
 */
namespace("Fv.plugin.AddSysUpdateLog");

Fv.plugin.AddSysUpdateLog = function () {
  return{
      init :Fv.plugin.AddSysUpdateLog.init
      ,start :Fv.plugin.AddSysUpdateLog.start
  }
}();
Fv.plugin.AddSysUpdateLog.init = function () {
    return{
        div : {

        }
        ,active : {

        }
    }
}();
Fv.plugin.AddSysUpdateLog.start = function () {
    Fv.config.layedit.build("demo");
    Fv.config.laydate.render({
        elem: '#date' //指定元素
        ,type: 'date'
        ,theme: '#393D49'
        // ,value: '1989-10-14'
        ,min: new Date().toLocaleDateString()
    });
    Fv.config.form.on('submit(submit)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
}();
