package com.sup.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 发送邮件工具类
 * @author
 */
@Component
public class SendEmailUtils {


    @Autowired
    private JavaMailSender mailSender ;

    private String from ;

    public void sendInlinResourceMail(String to ,String subject , String content,
                                      String srcPath, String srcId) throws Exception{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        FileSystemResource resource = new FileSystemResource(new File(srcPath));
        helper.addInline(srcId, resource);
        mailSender.send(message);
    }

}
