package com.autumnframework.common.architect.auth.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:22 2017/11/21.
 */
@Component
public class WebEmail {
    private static Logger logger = LogManager.getLogger(WebEmail.class);

    @Resource(name = "webEmailSender")
    private JavaMailSenderImpl mailSender;
    @Resource(name = "smg")
    private SimpleMailMessage mailMessage;

    public int sendHtmlEmail(String subject, String content, String to) {

        mailMessage.setTo(to);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            messageHelper.setFrom(mailMessage.getFrom());
            messageHelper.setSubject(subject); //主题
            messageHelper.setTo(mailMessage.getTo()); //发送给
            messageHelper.setCc(mailMessage.getFrom()); //抄送

            mailSender.send(mimeMessage);    //发送邮件

        } catch (Exception e) {
            logger.error("the email send error ! {}", e);
            return -1;
        }finally {
        }
        return 1;
    }

    public void send(String subject, String content) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            messageHelper.setFrom(mailMessage.getFrom());
            messageHelper.setSubject(subject); //主题
            messageHelper.setTo(mailMessage.getTo()); //发送给
            messageHelper.setCc(mailMessage.getFrom()); //抄送

            mailSender.send(mimeMessage);    //发送邮件

        } catch (Exception e) {
            logger.error("the email send error ! {}", e);
        }
    }
}
