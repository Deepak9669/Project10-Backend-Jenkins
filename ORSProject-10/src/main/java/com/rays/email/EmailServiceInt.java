package com.rays.email;

/**
 * EmailServiceInt is an interface that defines the contract
 * for sending emails in the application.
 * 
 * Any class implementing this interface must provide
 * the implementation for sending email messages.
 * 
 * It uses EmailMessage as a data carrier for email details.
 * 
 * @author Deepak Verma
 */
public interface EmailServiceInt {

    /**
     * Sends an email using the provided EmailMessage object
     * 
     * @param msg contains recipient, subject, message content,
     *            and message type (HTML or TEXT)
     */
    public void sendMail(EmailMessage msg);
}