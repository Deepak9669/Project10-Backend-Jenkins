package com.rays.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmailCtl is a REST Controller that handles email-related APIs.
 * 
 * It provides endpoints to send emails using EmailService.
 * 
 * This controller uses EmailServiceInt to send mail messages.
 * 
 * Base URL mapping: /Mail
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(name = "Mail")
public class EmailCtl {

    /**
     * Email service dependency for sending emails
     */
    @Autowired
    private EmailServiceInt emailService;

    /**
     * API to send a test email
     * 
     * URL: /send
     * Method: GET
     * 
     * @return success message
     */
    @GetMapping("/send")
    public String sendMail() {

        // Create email message
        EmailMessage msg = new EmailMessage();
        msg.setTo("cb@gmail.com");
        msg.setSubject("Spring Boot Mail");
        msg.setMessage("Hello, Mail sent successfully!");

        // Send email using service
        emailService.sendMail(msg);

        return "Mail Sent Successfully";
    }
}