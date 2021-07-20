package edu.integrador2.serviciosgenerales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.integrador2.serviciosgenerales.dto.EnvioCorreoDto;

@Service
public class NotificationService {
  @Autowired
  private JavaMailSender javaMailSender;
  
  public void sendNotificationA(EnvioCorreoDto dto) throws MailException { // send email
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(dto.getCorreo());
    mail.setFrom("jennydcc12@gmail.com");
    mail.setSubject("Solicitud Aceptada");
    mail.setText("El especialista a aceptado tu solicitud");

    javaMailSender.send(mail);
  } 

  public void sendNotificationR(EnvioCorreoDto dto) throws MailException { // send email
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(dto.getCorreo());
    mail.setFrom("jennydcc12@gmail.com");
    mail.setSubject("Solicitud Rechazada");
    mail.setText("El especialista a rechazado tu solicitud");

    javaMailSender.send(mail);
  } 

}
