var tabFilter,menu=[],liIndex,curNav,delMenu;
layui.define(["element","jquery"],function(exports){
	var element = layui.element,
		$ = layui.jquery,
		layId,
		Tab = function(){
			this.tabConfig = {
				closed : true,
				openTabNum : 10,
				tabFilter : "bodyTab"
			}
		};
//弹出loading
    var loginLoading = top.layer.msg('加载中，请稍候',{icon: 16,time:false,shade:0.8});

    $.ajax({
        url : '/res/ajax_res_menu_top.do',
        type : 'post',
        async: false,
        success : function(data) {
            if(data != ""){
               topNavBar(data);
            }else{
                $(".topMenu").empty();
            }

        }
    });
    function topNavBar(data){
        var pdata = $.parseJSON(data);
        // 显示上部菜单
        var topMenuContext = $.trim($("#topMenu").html());
        if(topMenuContext == null || topMenuContext.length == 0 ){
            var ulHtml = '<ul class="layui-nav clearfix layui-top-nav ">';
            $.each(pdata,function(index,item){

                if(index == 0){
                    ulHtml += '<li class="layui-nav-item layui-this" data-pid="'+item.pid+'">';
                    leftNavBar(item.pid);
                }else{
                    ulHtml += '<li class="layui-nav-item" data-pid="'+item.pid+'">';
                }
                ulHtml += '<a><i class="larry-icon '+item.icon+'"></i>';
                ulHtml += '<cite>'+item.title+'</cite></a>';
                ulHtml += '</li>'
            });
            ulHtml += '</ul>';
            $(".topMenu").html(ulHtml);
            element.init();  //初始化页面元素

        }
    };
    function leftNavBar(pid) {
        $.ajax({
            url : '/res/ajax_res_menu_left.do',
            type : 'post',
            async: false,
            data:{
                resParentid:pid
            },
            success : function(data) {
                if(data != "" ){
                    var pdata = $.parseJSON(data);
                        var ulHtml = '<ul class="layui-nav layui-nav-tree layui-left-nav">';
                        $.each(pdata,function(index,item){
                            if(index == 0){
                                ulHtml += '<li class="layui-nav-item layui-nav-itemed">';
                            }else{
                                ulHtml += '<li class="layui-nav-item">';
                            }

                            if(item.children != null ){
                                ulHtml += '<a href="javascript:;">';
                                ulHtml += '<i class="layui-icon larry-icon '+item.icon+' " data-icon="'+item.icon+'"></i>';
                                ulHtml += '<cite>'+item.title+'</cite>';
                                ulHtml += '<span class="layui-nav-more"></span>';
                                ulHtml += '</a>'
                                ulHtml += '<dl class="layui-nav-child">';
                                $.each(item.children,function(index,child){
                                    ulHtml += '<dd><a href="javascript:;" data-url="'+child.href+'">';
                                    if(child.icon != null){
                                        ulHtml += '<i class="layui-icon larry-icon '+child.icon+'" data-icon="'+child.icon+'"></i>';
                                    }
                                    ulHtml += '<cite>'+child.title+'</cite></a></dd>';
                                });
                                ulHtml += "</dl>"
                            }else{
                                ulHtml += '<a href="javascript:;" data-url="'+item.href+'">';
                                ulHtml += '<i class="layui-icon larry-icon '+item.icon+'" data-icon="'+item.icon+'"></i>';
                                ulHtml += '<cite>'+item.title+'</cite></a>';
                            }
                            ulHtml += '</li>'
                        });
                        ulHtml += '</ul>';
                        $(".navBar").html(ulHtml);
                        element.init();  //初始化页面元素



                }else{
                    $("#navBarId").empty();
                }

                top.layer.close(loginLoading);

            }
        });
        
    };

    $(".layui-top-nav .layui-nav-item a").on("click",function(){
        var pid = $(this).parent("li").attr("data-pid");
        leftNavBar(pid);
    });
	//参数设置
	Tab.prototype.set = function(option) {
		var _this = this;
		$.extend(true, _this.tabConfig, option);
		return _this;
	};

	//通过title获取lay-id
	Tab.prototype.getLayId = function(title){
		$(".layui-tab-title.top_tab li").each(function(){
			if($(this).find("cite").text() == title){
				layId = $(this).attr("lay-id");
			}
		})
		return layId;
	}
	//通过title判断tab是否存在
	Tab.prototype.hasTab = function(title){
		var tabIndex = -1;
		$(".layui-tab-title.top_tab li").each(function(){
			if($(this).find("cite").text() == title){
				tabIndex = 1;
			}
		})
		return tabIndex;
	}

	//右侧内容tab操作
	var tabIdIndex = 0;
	Tab.prototype.tabAdd = function(_this){
		if(window.sessionStorage.getItem("menu")){
			menu = JSON.parse(window.sessionStorage.getItem("menu"));
		}
		var that = this;
		var closed = that.tabConfig.closed,
			openTabNum = that.tabConfig.openTabNum;
			tabFilter = that.tabConfig.tabFilter;
		// $(".layui-nav .layui-nav-item a").on("click",function(){
			if(_this.find("i.iconfont,i.layui-icon").attr("data-icon") != undefined){
				var title = '';
				if(that.hasTab(_this.find("cite").text()) == -1 && _this.siblings("dl.layui-nav-child").length == 0){
					if($(".layui-tab-title.top_tab li").length == openTabNum){
						layer.msg('只能同时打开'+openTabNum+'个选项卡哦。不然系统会卡的！');
						return;
					}
					tabIdIndex++;
					if(_this.find("i.iconfont").attr("data-icon") != undefined){
						title += '<i class="iconfont '+_this.find("i.iconfont").attr("data-icon")+'"></i>';
					}else{
						title += '<i class="layui-icon larry-icon '+_this.find("i.layui-icon").attr("data-icon")+'"></i>';
					}
					title += '<cite>'+_this.find("cite").text()+'</cite>';
					title += '<i class="layui-icon layui-unselect layui-tab-close" data-id="'+tabIdIndex+'">&#x1006;</i>';
					element.tabAdd(tabFilter, {
				        title : title,
				        content :"<iframe src='"+_this.attr("data-url")+"' data-id='"+tabIdIndex+"' name='ifr_"+tabIdIndex+"' id='ifr_"+tabIdIndex+"' ></frame>",
				        id : new Date().getTime()
				    })

					//当前窗口内容
					var curmenu = {
						"icon" : _this.find("i.iconfont").attr("data-icon")!=undefined ? _this.find("i.iconfont").attr("data-icon") : _this.find("i.layui-icon").attr("data-icon"),
						"title" : _this.find("cite").text(),
						"href" : _this.attr("data-url"),
						"layId" : new Date().getTime()
					}
					menu.push(curmenu);
					window.sessionStorage.setItem("menu",JSON.stringify(menu)); //打开的窗口
					window.sessionStorage.setItem("curmenu",JSON.stringify(curmenu));  //当前的窗口
					element.tabChange(tabFilter, that.getLayId(_this.find("cite").text()));
				}else{
					//当前窗口内容
					var curmenu = {
						"icon" : _this.find("i.iconfont").attr("data-icon")!=undefined ? _this.find("i.iconfont").attr("data-icon") : _this.find("i.layui-icon").attr("data-icon"),
						"title" : _this.find("cite").text(),
						"href" : _this.attr("data-url"),
						"layId" : new Date().getTime()
					}

					window.sessionStorage.setItem("curmenu",JSON.stringify(curmenu));  //当前的窗口
					element.tabChange(tabFilter, that.getLayId(_this.find("cite").text()));
				}
			}
		// })
	}
	$("body").on("click",".top_tab li",function(){
		//切换后获取当前窗口的内容
		var curmenu = '';
		var menu = JSON.parse(window.sessionStorage.getItem("menu"));
		curmenu = menu[$(this).index()-1];
		if($(this).index() == 0){
			window.sessionStorage.setItem("curmenu",'');
		}else{
			window.sessionStorage.setItem("curmenu",JSON.stringify(curmenu));
			if(window.sessionStorage.getItem("curmenu") == "undefined"){
				//如果删除的不是当前选中的tab,则将curmenu设置成当前选中的tab
				if(curNav != JSON.stringify(delMenu)){
					window.sessionStorage.setItem("curmenu",curNav);
				}else{
					window.sessionStorage.setItem("curmenu",JSON.stringify(menu[liIndex-1]));
				}
			}
		}
		element.tabChange(tabFilter,$(this).attr("lay-id")).init();
	})

	//删除tab
	$("body").on("click",".top_tab li i.layui-tab-close",function(){
		//删除tab后重置session中的menu和curmenu
		liIndex = $(this).parent("li").index();
		var menu = JSON.parse(window.sessionStorage.getItem("menu"));
		//获取被删除元素
		delMenu = menu[liIndex-1];
		var curmenu = window.sessionStorage.getItem("curmenu")=="undefined" ? "undefined" : window.sessionStorage.getItem("curmenu")=="" ? '' : JSON.parse(window.sessionStorage.getItem("curmenu"));
		if(JSON.stringify(curmenu) != JSON.stringify(menu[liIndex-1])){  //如果删除的不是当前选中的tab
			// window.sessionStorage.setItem("curmenu",JSON.stringify(curmenu));
			curNav = JSON.stringify(curmenu);
		}else{
			if($(this).parent("li").length > liIndex){
				window.sessionStorage.setItem("curmenu",curmenu);
				curNav = curmenu;
			}else{
				window.sessionStorage.setItem("curmenu",JSON.stringify(menu[liIndex-1]));
				curNav = JSON.stringify(menu[liIndex-1]);
			}
		}
		menu.splice((liIndex-1), 1);
		window.sessionStorage.setItem("menu",JSON.stringify(menu));
		element.tabDelete("bodyTab",$(this).parent("li").attr("lay-id")).init();
	})

	var bodyTab = new Tab();
	exports("bodyTab",function(option){
		return bodyTab.set(option);
	});
})