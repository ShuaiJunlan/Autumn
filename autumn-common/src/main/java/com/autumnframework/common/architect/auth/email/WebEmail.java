package com.autumnframework.common.architect.auth.email;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:22 2017/11/21.
 */
@Component
public class WebEmail {
    private static Logger logger = LogManager.getLogger(WebEmail.class);

    private static final String EMAIL_SIMPLE_TEMPLATE_NAME = "mail/email-simple";

    @Resource(name = "webEmailSender")
    private JavaMailSenderImpl mailSender;
    @Resource(name = "smg")
    private SimpleMailMessage mailMessage;

    @Resource(name = "templateEngine-class")
    private TemplateEngine templateEngine;

    public int sendHtmlEmail(String subject, String content, String to) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            mimeMessage.setContent(content, "text/html;charset=utf-8");
            messageHelper.setFrom(mailMessage.getFrom());
            messageHelper.setSubject(subject); //主题
            messageHelper.setTo(to); //发送给
            messageHelper.setCc(mailMessage.getFrom()); //抄送

            mailSender.send(mimeMessage);    //发送邮件

        } catch (Exception e) {
            logger.error("the email send error ! content: {}, exception: {}", content, e);
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
            logger.error("the email send error! content: {}, exception: {}", content, e);
        }
    }

    public void sendHtmlMailOnThymeleaf(String to){
        // Prepare the evaluation context
        final Context ctx = new Context();
        ctx.setVariable("username", "test");
        ctx.setVariable("link", "https://shuaijunlan.cn/autumn-cms/index.do");


        // Prepare message using a Spring helper
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
            messageHelper.setFrom(mailMessage.getFrom());
            messageHelper.setSubject("激活邮件"); //主题
            messageHelper.setTo(to); //发送给
            messageHelper.setCc(mailMessage.getFrom()); //抄送


            // Create the HTML body using Thymeleaf
            final String htmlContent = this.templateEngine.process("register-auth", ctx);
            mimeMessage.setContent(htmlContent, "text/html;charset=utf-8");
            // send mail
            this.mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
