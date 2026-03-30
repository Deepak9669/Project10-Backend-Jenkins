package com.rays.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ORSResponse is a generic response wrapper class used to send
 * structured responses from server to client.
 * 
 * It contains:
 * - success flag
 * - result map (message, data, errors, etc.)
 * 
 * This class is mainly used in REST APIs for consistent response format.
 * 
 * @author Deepak Verma
 */
public class ORSResponse {

    /**
     * Key for input validation errors
     */
    public static final String INPUT_ERROR = "inputerror";

    /**
     * Key for messages
     */
    public static final String MESSAGE = "message";

    /**
     * Key for response data
     */
    public static final String DATA = "data";

    /**
     * Map to store response data
     */
    private Map<String, Object> result = new HashMap<>();

    /**
     * Indicates success or failure of request
     */
    public boolean success = false;

    /**
     * Default constructor
     */
    public ORSResponse() {
    }

    /**
     * Constructor with success flag
     * 
     * @param success true if operation successful
     */
    public ORSResponse(boolean success) {
        this.success = success;
    }

    /**
     * Constructor with success and message
     * 
     * @param success true if operation successful
     * @param message response message
     */
    public ORSResponse(boolean success, String message) {
        this.success = success;
        addMessage(message);
    }

    /**
     * Constructor with success, message, and data
     * 
     * @param success true if operation successful
     * @param message response message
     * @param value response data
     */
    public ORSResponse(boolean success, String message, Object value) {
        this.success = success;
        addMessage(message);
        addData(value);
    }

    /**
     * Returns success flag
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success flag
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Returns result map
     */
    public Map<String, Object> getResult() {
        return result;
    }

    /**
     * Sets result map
     */
    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    /**
     * Adds input validation errors
     * 
     * @param value error object
     */
    public void addInputError(Object value) {
        result.put(INPUT_ERROR, value);
    }

    /**
     * Adds message to response
     * 
     * @param value message object
     */
    public void addMessage(Object value) {
        result.put(MESSAGE, value);
    }

    /**
     * Adds data to response
     * 
     * @param value data object
     */
    public void addData(Object value) {
        result.put(DATA, value);
    }

    /**
     * Adds custom key-value pair to response
     * 
     * @param key key name
     * @param value value object
     */
    public void addResult(String key, Object value) {
        result.put(key, value);
    }
}