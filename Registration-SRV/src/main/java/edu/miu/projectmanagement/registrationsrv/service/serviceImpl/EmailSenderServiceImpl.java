package edu.miu.projectmanagement.registrationsrv.service.serviceImpl;

import edu.miu.projectmanagement.registrationsrv.service.IEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class EmailSenderServiceImpl implements IEmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public ResponseEntity<String> sendEmail(String toEmail){
        String body="confirmation";
        String subject="confirm";
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("abcuniversityregistrar@gmail.com");
        mail.setTo(toEmail);
        mail.setText(body);
        mail.setSubject(subject);
        javaMailSender.send(mail);
        return ResponseEntity.ok("Mail sent...");
    }
}
