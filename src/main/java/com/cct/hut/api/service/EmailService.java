package com.cct.hut.api.service;

import com.cct.hut.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(User user) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("biafriedrich06@gmail.com");
        mail.setFrom(user.getEmail());
        mail.setSubject("Contact: "+user.getName());
        mail.setText(user.getMailMessage());

        javaMailSender.send(mail);
    }

}
