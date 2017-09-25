/**
 * Created by Mr SJL on 2017/9/3.
 */
$(function () {
    var top_menu_data = {

    }
    var left_menu_data = [
        {
            menu_name : "模块一",
            href : "javascript:;",
            child_num : 3,
            childes : [
                {
                    menu_name : "子模块1",
                    href : "javascript:;"
                },
                {
                    menu_name : "子模块2",
                    href : "javascript:;"
                },
                {
                    menu_name : "子模块3",
                    href : "javascript:;"
                }
            ]
        },
        {
            menu_name : "模块二",
            href : "javascript:;",
            child_num : 2,
            childes : [
                {
                    menu_name : "子模块1",
                    href : "javascript:;"
                },
                {
                    menu_name : "子模块2",
                    href : "javascript:;"
                }
            ]
        },
        {
            menu_name : "模块三",
            href : "javascript:;",
            child_num : 0,
            childes : []
        }
    ];

    var top_menu_data = left_menu_data;
    main.menu.left_menu(left_menu_data, "#left_menu");
    main.menu.top_menu(top_menu_data, "#top_menu");
})