/**自定义模块*/
layui.define(['layer'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;
    var CmsCommon = {

        /**错误msg提示 */
        cmsLayErrorMsg:function (text) {
            top.layer.msg(text, {icon: 5});
        },
        /**成功 msg提示 */
        cmsLaySucMsg:function (text) {
            top.layer.msg(text, {icon: 6});
        },
        /**ajax Confirm 对话框*/
        ajaxCmsConfirm: function (title, text, url,param) {
            layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定', '取消'],
                btnAlign: 'c',
                anim:1,
                icon: 3
            }, function () {
                $.ajax({
                    url : url,
                    type : 'post',
                    async: false,
                    data : param,
                    success : function(data) {
                        if(data.returnCode == 0000){
                            top.layer.msg(data.returnMessage, {icon: 6});
                            location.reload();
                        }else{
                            top.layer.msg(data.returnMessage,{icon: 5});
                        }
                    },error:function(data){

                    }
                });

            }, function () {

            })

        },
        /**弹出层*/
        cmsLayOpen:function (title,url,width,height) {

            var index = layui.layer.open({
                title : '<i class="larry-icon larry-bianji3"></i>'+title,
                type : 2,
                skin : 'layui-layer-molv',
                content : url,
                area: [width, height],
                resize:false,
                anim:1,
                success : function(layero, index){

                }
            });
        },
        /**退出*/
        logOut: function (title, text, url, type, dataType, data, callback) {
            parent.layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定退出系统', '不，我点错了！'],
                btnAlign: 'c',
                icon: 3
            }, function () {
                location.href = url
            }, function () {
               
            })
        }
    };
    exports('common', CmsCommon)
})



