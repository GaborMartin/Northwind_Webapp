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
    public List<Model> getResultOfTaskOne() throws ServiceException {
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
    public List<Model> getTaskOneFilteredResult(String companyName) throws ServiceException, SQLException {
        try {
            List<Model> result = taskDao.getProductByCompany(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResultOfTaskTwo() throws ServiceException {
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

    public List<Model> getTaskTwoFilteredResult(int numOfProducts) throws ServiceException {
        try {
            List<Model> result = taskDao.getCompanyByNumberOfProducts(numOfProducts);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResultOfTaskThree() throws ServiceException {
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
    public List<Model> getTaskThreeFilteredResult(String companyName) throws ServiceException {
        try {
            List<Model> result = taskDao.getCompanyByName(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResultOfTaskFour() throws ServiceException {
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
    public List<Model> getTaskFourFilteredResult(String companyName) throws ServiceException {
        try {
            List<Model> result = taskDao.getOrderIdsByCustomerName(companyName);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }

    @Override
    public List<Model> getResultOfTaskFive() throws ServiceException {
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

    @Override
    public List<Model> getTaskFiveFilteredResult(float price) throws ServiceException {
        try {
            List<Model> result = taskDao.getCheaperProducts(price);
            if (result == null) {
                throw new ServiceException("Invalid result!");
            }
            return result;
        } catch (SQLException e) {
            throw new ServiceException("Invalid SQL operation!");
        }
    }
}
