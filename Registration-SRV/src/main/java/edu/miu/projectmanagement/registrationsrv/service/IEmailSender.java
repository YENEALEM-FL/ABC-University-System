package edu.miu.projectmanagement.registrationsrv.service;

import edu.miu.projectmanagement.registrationsrv.model.Course;
import org.springframework.http.ResponseEntity;

public interface IEmailSender {
     ResponseEntity<String> sendEmail(String toEmail);
}
