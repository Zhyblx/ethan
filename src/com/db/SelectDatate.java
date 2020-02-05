package src.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectDatate {

    // 查询城市编号
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

    // 莆田系医院查询
    public static List<String> setHospital(String area,String hospital) {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();

            String sql = "select * from tb_Hospital where hospitalName like '%" + hospital + "%' and area like '%"+ area + "%'"; // 通知信息内容表
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String hospitalArea = resultSet.getString("area");
                list.add(hospitalArea);
                String hospitalName = resultSet.getString("hospitalName");
                list.add(hospitalName);
                String hospitalType = resultSet.getString("hospitalType");
                list.add(hospitalType);

            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        return list;

    }


    public static void main(String[] args) throws Exception {
//        System.out.println(SelectDatate.setcityName("嘉兴"));
        System.out.println(SelectDatate.setHospital("上海",""));

    }
}
