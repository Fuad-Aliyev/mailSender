package com.email.email_sender;

import com.email.email_sender.bean.Mail;
import com.email.email_sender.services.MailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EmailSenderApplication {

	public static void main(String[] args) {
		Mail mail = new Mail();
		mail.setMailFrom("yashwantchavan@gmail.com");
		mail.setMailTo("fuadali.989@gmail.com");
		mail.setMailSubject("Spring Boot - Email Example");
		mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");

		ApplicationContext ctx = SpringApplication.run(EmailSenderApplication.class, args);
		MailService mailService = (MailService) ctx.getBean("mailService");
		mailService.sendEmail(mail);
	}

}
