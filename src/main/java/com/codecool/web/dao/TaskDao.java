package com.codecool.web.dao;

import com.codecool.web.model.Model;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {

    List<Model> getTaskOneResult()throws SQLException;
    List<Model> getTaskTwoResult()throws SQLException;
    List<Model> getTaskThreeResult()throws SQLException;
    List<Model> getTaskFourResult()throws SQLException;
    List<Model> getTaskFiveResult()throws SQLException;
}
