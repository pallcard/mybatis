package cn.wishhust.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author lk
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;

        try {
            // 加载驱动 (每次加载驱动，驱动名硬编码)
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接(每次获取连接，连接信息硬编码)
            String url = "jdbc:mysql://127.0.0.1:3306/mybatis_demo";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement （sql和java代码耦合）
            String sql = "select * from tb_user where id=?";
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数（参数类型手动判断、设置）
            prepareStatement.setLong(1, 1l);
            // 执行查询
            rs = prepareStatement.executeQuery();
            // 处理结果集（结果集中数据类型、下标、列名要手动判断）
            while (rs.next()) {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));
            }
        } finally {
            //（每次都要打开或关闭连接，浪费资源）
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

