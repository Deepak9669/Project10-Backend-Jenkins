package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AppointmentDAOInt;
import com.rays.dto.AppointmentDTO;

/**
 * Implementation of AppointmentServiceInt interface.
 * 
 * This class provides the business logic for Appointment
 * related operations. It extends BaseServiceImpl to inherit
 * common CRUD functionalities and uses AppointmentDAOInt
 * for data access operations.
 * 
 * <p>
 * Annotated with {@code @Service} to mark it as a Spring
 * service component.
 * </p>
 * 
 * <p>
 * Annotated with {@code @Transactional} to ensure that
 * all methods are executed within a transactional context.
 * </p>
 * 
 * @author 
 */
@Service
@Transactional
public class AppointmentServiceImpl extends BaseServiceImpl<AppointmentDTO, AppointmentDAOInt>
        implements AppointmentServiceInt {

}