package com.email.email_sender.services;

import com.email.email_sender.bean.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service("mailService")
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmail(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessage.setSubject(mail.getMailSubject());
            mimeMessage.setFrom(new InternetAddress(mail.getMailFrom(), "fuadservice.com"));
            mimeMessage.setReplyTo(new Address[]{new InternetAddress(mail.getMailTo())});
            mimeMessage.setText(mail.getMailContent());

            mailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
