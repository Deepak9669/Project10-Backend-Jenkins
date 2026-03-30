package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableDAOInt is a DAO interface for TimeTableDTO.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations
 * such as add, update, delete, find, and search.
 * 
 * This interface can be extended to define additional
 * database operations specific to TimeTable entity.
 * 
 * @author Deepak Verma
 */
public interface TimeTableDAOInt extends BaseDAOInt<TimeTableDTO> {

}