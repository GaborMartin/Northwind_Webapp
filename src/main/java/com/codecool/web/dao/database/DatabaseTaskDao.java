package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTaskDao extends AbstractDao implements TaskDao {

    public DatabaseTaskDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Model> getTaskOneResult() throws SQLException {
        List<Model> result = new ArrayList<>();
        String sql = "SELECT products.productname AS Product, suppliers.companyname AS Company " +
            "FROM products, suppliers " +
            "WHERE products.SupplierID = suppliers.SupplierID " +
            "ORDER BY products.productname ASC, suppliers.companyname ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskOne(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<Model> getTaskTwoResult() throws SQLException {
        List<Model> result = new ArrayList<>();
        String sql = "SELECT companyname AS Company, Count(products.supplierid) AS NumberOfProducts " +
            "FROM suppliers " +
            "JOIN products ON suppliers.supplierid=products.supplierid " +
            "GROUP BY companyname " +
            "ORDER BY numberofproducts DESC, companyname ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskTwo(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<Model> getTaskThreeResult() throws SQLException {
        List<Model> result = new ArrayList<>();
        String sql = "SELECT companyname AS Company " +
            "FROM suppliers " +
            "JOIN products ON products.supplierid = suppliers.supplierid " +
            "GROUP BY companyname " +
            "HAVING COUNT(products.supplierid) = 5 " +
            "ORDER BY companyname ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskThree(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<Model> getTaskFourResult() throws SQLException {
        List<Model> result = new ArrayList<>();
        String sql = "SELECT customers.companyname AS company, array_to_string " +
            "(array_agg(orders.orderid), ',') AS orderids FROM customers " +
            "JOIN orders ON customers.customerid = orders.customerid " +
            "GROUP BY customers.companyname " +
            "ORDER BY companyname";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskFour(resultSet));
            }
        }
        return result;
    }

    @Override
    public List<Model> getTaskFiveResult() throws SQLException {
        List<Model> result = new ArrayList<>();
        String sql = "SELECT suppliers.companyname AS company, products.productname AS product, products.unitprice AS price " +
            "FROM suppliers " +
            "JOIN products ON products.supplierid = suppliers.supplierid " +
            "INNER JOIN (" +
            "SELECT products.supplierid, " +
            "MAX(products.unitprice) AS maxPrice " +
            "FROM products " +
            "GROUP BY supplierid) AS b" +
            "ON b.supplierid = suppliers.supplierid AND products.unitprice = b.maxPrice " +
            "ORDER BY unitprice DESC, company ASC, product ASC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                result.add(fetchTaskFive(resultSet));
            }
        }
        return result;
    }

    private Model fetchTaskOne(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String product = resultSet.getString("product");
        return new Model(company, product);
    }

    private Model fetchTaskTwo(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        int numberOfProducts = resultSet.getInt("numberofproducts");
        return new Model(company, numberOfProducts);
    }

    private Model fetchTaskThree(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new Model(company);
    }

    private Model fetchTaskFour(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String orderIds = resultSet.getString("orderids");
        return new Model(company, orderIds);
    }

    private Model fetchTaskFive(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        String product = resultSet.getString("orderids");
        int price = resultSet.getInt("price");
        return new Model(company, product, price);
    }
}
