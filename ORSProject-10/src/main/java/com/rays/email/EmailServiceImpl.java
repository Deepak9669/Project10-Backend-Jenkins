package com.rays.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl is a service class responsible for sending emails.
 * 
 * It uses Spring's JavaMailSender to create and send email messages.
 * Supports both plain text and HTML email formats.
 * 
 * This class implements EmailServiceInt interface.
 * 
 * @author Deepak Verma
 */
@Service
public class EmailServiceImpl implements EmailServiceInt {

    /**
     * JavaMailSender dependency for sending emails
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * Sends an email using the provided EmailMessage object
     * 
     * @param msg contains email details like recipient, subject, content, and type
     */
    @Override
    public void sendMail(EmailMessage msg) {
        try {

            // Create MIME message
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            // Helper for setting email properties
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            // Set recipient and subject
            helper.setTo(msg.getTo());
            helper.setSubject(msg.getSubject());

            // Set message content (HTML or Text)
            if (msg.getMessageType() == EmailMessage.HTML_MSG) {
                helper.setText(msg.getMessage(), true); // HTML content
            } else {
                helper.setText(msg.getMessage(), false); // Plain text
            }

            // Send email
            mailSender.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}