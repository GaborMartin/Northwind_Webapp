package com.codecool.web.service;

import com.codecool.web.model.Model;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface TaskService {

    List<Model> getResultOfTaskOne() throws ServiceException, SQLException;
    List<Model> getTaskOneFilteredResult(String companyName) throws ServiceException, SQLException;
    List<Model> getResultOfTaskTwo() throws ServiceException;
    List<Model> getTaskTwoFilteredResult(int numOfProducts) throws ServiceException;
    List<Model> getResultOfTaskThree() throws ServiceException;
    List<Model> getTaskThreeFilteredResult(String companyName) throws ServiceException;
    List<Model> getResultOfTaskFour() throws ServiceException;
    List<Model> getTaskFourFilteredResult(String companyName) throws ServiceException;
    List<Model> getResultOfTaskFive() throws ServiceException;
}
