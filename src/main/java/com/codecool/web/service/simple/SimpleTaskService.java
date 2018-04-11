package com.codecool.web.service.simple;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Model;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class SimpleTaskService implements TaskService {

    private final TaskDao taskDao;

    public SimpleTaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Model> getResulOfTaskOne() throws ServiceException {
        try {
            List<Model> result = taskDao.getTaskOneResult();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResulOfTaskTwo() throws ServiceException {
        try {
            List<Model> result = taskDao.getTaskTwoResult();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResulOfTaskThree() throws ServiceException {
        try {
            List<Model> result = taskDao.getTaskThreeResult();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResulOfTaskFour() throws ServiceException {
        try {
            List<Model> result = taskDao.getTaskFourResult();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResulOfTaskFive() throws ServiceException {
        try {
            List<Model> result = taskDao.getTaskFiveResult();
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }
}
