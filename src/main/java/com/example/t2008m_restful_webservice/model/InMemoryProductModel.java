package com.example.t2008m_restful_webservice.model;

import com.example.t2008m_restful_webservice.entity.Product;
import com.example.t2008m_restful_webservice.util.ConnectionHelper;
import com.example.t2008m_restful_webservice.util.SQLConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryProductModel implements  ProductModel{
    @Override
    public  boolean save(Product obj){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setDouble(2, obj.getPrice());
            preparedStatement.execute();
            return true;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public  boolean update(Product updateObj, int id){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_UPDATE);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setDouble(2, updateObj.getPrice());
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_DELETE);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Product> findAll() {
        List<Product> listObj = new ArrayList<>();

        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = SQLConfig.DATABASE_PRODUCT_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product obj = new Product(id, name, price);
                listObj.add(obj);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    @Override
    public Product findById(int id) {
        Product obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQLConfig.DATABASE_PRODUCT_SELECT2);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                obj = new Product(id, name, price);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }
}
