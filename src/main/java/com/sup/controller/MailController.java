package com.sup.controller;

import com.sup.entity.User;
import com.sup.service.IUserService;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mail")
public class MailController {

    @Autowired
    private IUserService userService;

    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;

    @Scheduled(cron = "0 0 12 * * * ?")
    public void commonEmail() {
        List<User> lists = userService.list();
        for (int i = 0; i < lists.size(); i++) {
            User user = lists.get(i);
            if (user.getMail() != null){
                //创建简单邮件消息
                SimpleMailMessage message = new SimpleMailMessage();
                //谁发的
                message.setFrom(from);
                //谁要接收
                message.setTo(user.getMail());
                //邮件标题
                message.setSubject("这是邮件标题");
                //邮件内容
                message.setText("这是邮件内容");
                try {
                    mailSender.send(message);

                } catch (MailException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}