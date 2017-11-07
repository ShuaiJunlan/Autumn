package com.autumnframework.cms.task;

import com.autumnframework.cms.dao.bomapper.LoginInfoMapper;
import com.autumnframework.cms.extern.email.WebEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 9:28 2017/11/7.
 */
@Component
public class EmailTask {

    private Logger logger = LogManager.getLogger(EmailTask.class);

    @Autowired
    private WebEmail webEmail;

    @Autowired
    private LoginInfoMapper loginInfoMapper;



    @Scheduled(cron = "0 0 18 * * ?")
    public void sendVisitCountMiddle(){
        String content = "<html> <body> <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" height=\"500\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"padding:18px 23px; line-height:160%;color:;font-size:18px;font-family:Microsoft Yahei;background-position:0 0; background-color:#fff; background-repeat:repeat \" background=\"https://mimg.127.net/xm/all/custom_letter/img/demo/sys_demo9.gif\">\n" +
                "\t\t\t\t<stationery><div align=\"center\">Autumn Framework：</div><div align=\"center\">今日访问量："+loginInfoMapper.getNowCount()+"</div><div align=\"center\">增&nbsp;&nbsp; 长 &nbsp; 量："+(loginInfoMapper.getNowCount()-loginInfoMapper.getYesterdayCount())+"</div><div><div align=\"center\"><a href=\"http://autumn.shuaijunlan.cn\">Autumn_Framework</a><br /></div><br /><br /><br /><br /><br /><br /></div><stationery>\n" +
                "\t\t\t</stationery></stationery></td>\n" +
                "\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\n" +
                "\t</tbody>\n" +
                "</table>\n </body> </html>";

        webEmail.send("Autumn Framework Notice", content);
    }

    @Scheduled(cron = "0 0 23 * * ?")
    public void sendVisitCountNight(){
        String content = "<html> <body> <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" height=\"500\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"padding:18px 23px; line-height:160%;color:;font-size:18px;font-family:Microsoft Yahei;background-position:0 0; background-color:#fff; background-repeat:repeat \" background=\"https://mimg.127.net/xm/all/custom_letter/img/demo/sys_demo9.gif\">\n" +
                "\t\t\t\t<stationery><div align=\"center\">Autumn Framework：</div><div align=\"center\">今日访问量："+loginInfoMapper.getNowCount()+"</div><div align=\"center\">增&nbsp;&nbsp; 长 &nbsp; 量："+(loginInfoMapper.getNowCount()-loginInfoMapper.getYesterdayCount())+"</div><div><div align=\"center\"><a href=\"http://autumn.shuaijunlan.cn\">Autumn_Framework</a><br /></div><br /><br /><br /><br /><br /><br /></div><stationery>\n" +
                "\t\t\t</stationery></stationery></td>\n" +
                "\n" +
                "\t\t</tr>\n" +
                "\n" +
                "\n" +
                "\t</tbody>\n" +
                "</table>\n </body> </html>";
        webEmail.send("Autumn Framework Notice", content);
    }
}
