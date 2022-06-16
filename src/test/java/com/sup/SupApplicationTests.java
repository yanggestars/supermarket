package com.sup;


import com.sup.entity.User;
import com.sup.service.IRoleService;
import com.sup.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@SpringBootTest
class SupApplicationTests {

	@Test
	void contextLoads() {
		String a = "鼠标右键按下";
		System.out.println(a.substring(2, 4));
	}


	@Autowired
	IRoleService roleService;
	@Test
	void test2(){
		List<Integer> list = roleService.queryRolePermissionIdsByRid(1);
		list.forEach(p-> System.out.println(p));
		//List<Integer> currentUserRoleIds = roleService.queryUserRoleIdsByUid(1);
		//currentUserRoleIds.forEach(p-> System.out.println(p));
	}


	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	private String from;
	@Autowired
	IUserService userService;
	@Test
	public void commonEmail() {
		List<User> lists = userService.list();
		for (int i = 0; i < lists.size(); i++) {
			User user = lists.get(i);
			if (user.getMail() != null) {
				System.out.println(user.getMail());
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



