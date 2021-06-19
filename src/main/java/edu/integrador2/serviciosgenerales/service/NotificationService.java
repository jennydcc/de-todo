package edu.integrador2.serviciosgenerales.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class NotificationService {


  private JavaMailSender javaMailSender;
  

  @Autowired
  public NotificationService(JavaMailSender javaMailSender){
    this.javaMailSender= javaMailSender;
  }

  public void sendNotification(User user) throws MailException {
    //send email
    SimpleMailMessage mail= new SimpleMailMessage();
    mail.setTo(user.getEmailAddress());
    mail.setFrom("u17209943@utp.edu.pe");
    mail.setSubject("Solicitud Aceptada");
    mail.setText("El especialista a aceptado tu solicitud");

    javaMailSender.send(mail);

  }

}
