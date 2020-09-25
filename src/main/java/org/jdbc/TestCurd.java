package org.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-09-25 3:24 下午
 */
public class TestCurd {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //提供url地址，获得连接
        String url="jdbc:mysql://localhost:3306/test2?serverTimezone=Asia/Shanghai" +
                "&characterEncoding=utf8&useUnicode=true&useSSL=false";
        Connection connection= DriverManager.getConnection(url,"root","root");
        //获得语句对象
        Statement statement=connection.createStatement();
        String dname="市场资源部";
        String sql="DELETE FROM emp WHERE id=4";
        //sql="INSERT INTO dept VALUES(null,'"+dname+"')";//拼接sql方式
        sql="UPDATE dept SET dname='"+dname+"' WHERE dname='市场部'";
        //执行sql语句   增加 删除 修改  int
        int i=statement.executeUpdate(sql);
        System.out.println(i>0?"修改成功":"修改失败");
        statement.close();
        connection.close();//try catch finally
    }

}
