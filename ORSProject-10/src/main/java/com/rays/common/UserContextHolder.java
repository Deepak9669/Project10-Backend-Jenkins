package com.rays.common;

/**
 * UserContextHolder is a utility class used to store and manage
 * UserContext using ThreadLocal.
 * 
 * It ensures that each request/thread has its own isolated
 * UserContext instance.
 * 
 * This is commonly used in web applications to maintain
 * user session data across different layers (Controller,
 * Service, DAO) without passing it explicitly.
 * 
 * @author Deepak Verma
 */
public class UserContextHolder {

    /**
     * ThreadLocal variable to store UserContext per thread
     */
    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    /**
     * Sets UserContext for current thread
     * 
     * @param context UserContext object
     */
    public static void setContext(UserContext context) {
        threadLocal.set(context);
    }

    /**
     * Gets UserContext of current thread
     * 
     * @return UserContext object
     */
    public static UserContext getContext() {
        return threadLocal.get();
    }

    /**
     * Clears UserContext from current thread
     * 
     * This is important to avoid memory leaks in thread pools
     */
    public static void clear() {
        threadLocal.remove();
    }
}