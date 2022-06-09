package com.example.t2008m_restful_webservice.util;

public class SQLConfig {
    public static final String DATABASE_PRODUCT_INSERT = "insert into products ( name, price ) values (?,?)";
    public static final String DATABASE_PRODUCT_SELECT = "select * from products";
    public static final String DATABASE_PRODUCT_SELECT2 = "select * from products where id = ?";
    public static final String DATABASE_PRODUCT_UPDATE = "update products set name = ?, price = ? where id = ?";
    public static final String DATABASE_PRODUCT_DELETE = "delete from products where id = ?";
}
