package com.rays.email;

/**
 * EmailMessage is a simple POJO class that represents
 * an email structure used for sending emails.
 * 
 * It contains recipient email, subject, message content,
 * and message type (HTML or Text).
 * 
 * This class is used by EmailService to send emails.
 * 
 * @author Deepak Verma
 */
public class EmailMessage {

    /** Recipient email address */
    private String to;

    /** Subject of the email */
    private String subject;

    /** Content of the email */
    private String message;

    /** Type of message (HTML or TEXT) */
    private int messageType = TEXT_MSG;

    /** Constant for HTML message type */
    public static final int HTML_MSG = 1;

    /** Constant for Text message type */
    public static final int TEXT_MSG = 2;

    /**
     * Default constructor
     */
    public EmailMessage() {
    }

    /**
     * Parameterized constructor
     * 
     * @param to recipient email
     * @param subject email subject
     * @param message email content
     */
    public EmailMessage(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Gets recipient email
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets recipient email
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets message content
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message content
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets message type
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * Sets message type (HTML_MSG or TEXT_MSG)
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}