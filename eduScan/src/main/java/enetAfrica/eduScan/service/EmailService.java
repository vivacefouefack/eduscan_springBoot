package enetAfrica.eduScan.service;

import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String eduscanMail;

    /**
     * Constructs an instance of EmailService.
     *
     * @param javaMailSender the JavaMailSender used for sending emails.
    */
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Sends an email to the specified recipient with the given body content.
     *
     * @param to   the recipient's email address.
     * @param body the body content of the email.
     * @throws MessagingException if there is an error while creating or sending the email.
    */
    public void sendEmail(String to, String body) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(eduscanMail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("EduScan platform");

        javaMailSender.send(mimeMessage);
    }
   
}
