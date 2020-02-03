package src.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDatate {

    public static String setcityName(String cityName) {
        String selectInfo = "";
        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();

            String sql = "select * from tb_CityCoding where name like '%" + cityName + "%'"; // 通知信息内容表
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String adcode = resultSet.getString("adcode");
                selectInfo = selectInfo + name + ":" + adcode;

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return selectInfo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(SelectDatate.setcityName("嘉兴"));

    }

}
