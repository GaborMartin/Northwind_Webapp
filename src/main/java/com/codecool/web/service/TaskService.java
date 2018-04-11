package com.codecool.web.service;

import com.codecool.web.model.Model;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    List<Model> getResulOfTaskOne() throws ServiceException, SQLException;
    List<Model> getResulOfTaskTwo() throws ServiceException;
    List<Model> getResulOfTaskThree() throws ServiceException;
    List<Model> getResulOfTaskFour() throws ServiceException;
    List<Model> getResulOfTaskFive() throws ServiceException;
}
