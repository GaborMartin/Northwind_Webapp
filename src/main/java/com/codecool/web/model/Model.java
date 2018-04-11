package com.codecool.web.model;

public class Model {
    private String company;
    private String product;
    private int numberofproducts;
    private String orderids;
    private int price;

    public Model(String company, String product) {
        this.company = company;
        this.product = product;
    }

    public Model(String company, int numberofproducts) {
        this.company = company;
        this.numberofproducts = numberofproducts;
    }

    public Model(String company) {
        this.company = company;
    }

    public Model(String company, String product, int price) {
        this.company = company;
        this.product = product;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getProduct() {
        return product;
    }

    public int getNumberOfProducts() {
        return numberofproducts;
    }

    public String getOrderIds() {
        return orderids;
    }

    public int getPrice() {
        return price;
    }
}
