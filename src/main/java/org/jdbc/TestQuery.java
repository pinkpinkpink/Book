package org.jdbc;

import java.sql.*;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-09-25 3:22 下午
 */
public class TestQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test2?serverTimezone=Asia/Shanghai" +
                "&characterEncoding=utf8&useUnicode=true&useSSL=false";
        Connection connection= DriverManager.getConnection(url,"root","root");
        Statement statement=connection.createStatement();
        String sql="select * from dept";
        ResultSet resultSet=statement.executeQuery(sql);//执行查询
        while (resultSet.next()){//将指针向下移动1位，并且返true or false
            System.out.print(resultSet.getInt(1)+"\t");
            System.out.println(resultSet.getString("dname"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

}
