package com.philspelman.springrelationshipsproductsm2m.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterTable {
    public static void main(String[] args) {}

    public void setPks(){

        System.out.println("Table Altering for PKs!");
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "relationships_m2m";
        String driverName = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            // Creating db connection
            Class.forName(driverName);
            con = DriverManager.getConnection(url + dbName, userName, password);
            try {
                Statement st = con.createStatement();
//                String sql = "ALTER TABLE student add location varchar(30)";
                String sql = "ALTER TABLE categories_products DROP PRIMARY KEY, ADD PRIMARY KEY(category_id, product_id)";
                st.executeUpdate(sql);
                System.out.println("Table is altered successfully");
            } catch (SQLException s) {
                System.out.println(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}