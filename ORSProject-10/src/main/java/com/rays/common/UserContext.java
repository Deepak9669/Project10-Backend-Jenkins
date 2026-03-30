package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * UserContext holds information about the currently logged-in user.
 * 
 * It is used to store user-related details like:
 * - userId
 * - loginId
 * - name
 * - role information
 * 
 * This object is typically stored in session or thread context
 * and used across the application for authentication and auditing.
 * 
 * @author Deepak Verma
 */
public class UserContext {

    /**
     * User ID
     */
    private Long userId = 0L;

    /**
     * Login ID (username/email)
     */
    private String loginId = "root";

    /**
     * User full name
     */
    private String name = null;

    /**
     * Role ID
     */
    private Long roleId = 0L;

    /**
     * Role name
     */
    private String roleName = "root";

    /**
     * Complete UserDTO object
     */
    private UserDTO userDTO = null;

    /**
     * Default constructor
     */
    public UserContext() {
    }

    /**
     * Constructor to initialize UserContext from UserDTO
     * 
     * @param dto UserDTO object
     */
    public UserContext(UserDTO dto) {
        this.userDTO = dto;
        this.userId = dto.getId();
        this.loginId = dto.getLoginId();
        this.name = dto.getName();
        this.roleId = dto.getRoleId();
        this.roleName = dto.getRoleName();
    }

    /**
     * Gets user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets login ID
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Gets user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets role ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets UserDTO object
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets UserDTO object
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}