package src.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    public static List<String> setHospital(String area, String hospital) {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();

            String sql = "select * from tb_Hospital where hospitalName like '%" + hospital + "%' and area like '%" + area + "%'"; // 通知信息内容表
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

    // 垃圾分类查询
    public static List<String> setGarbageClassification(String garbageName) {
        List<String> list = new ArrayList<String>();
        /**
         * {"_id":"1","name":"可回收物"}
         * {"_id":"2","name":"有害垃圾"}
         * {"_id":"3","name":"湿垃圾"}
         * {"_id":"4","name":"干垃圾"}
         */
        Map<String, String> map = new HashMap<String, String>();
        map.put("1 ", "可回收物");
        map.put("2 ", "有害垃圾");
        map.put("3 ", "湿垃圾");
        map.put("4 ", "干垃圾");
        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();

            String sql = "select * from tb_Garbage where name like '%" + garbageName + "%' "; // 通知信息内容表
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
//                System.out.println("1---"+name);
//                System.out.println("2---"+garbageName);
//                System.out.println(name.equals(garbageName+" "));
                if(name.equals(garbageName+" ")){
                    list.add(name);
                    String sortId = resultSet.getString("sortId");
                    list.add(map.get(sortId));

                }
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
        System.out.println(SelectDatate.setGarbageClassification("八宝粥"));

    }
}
