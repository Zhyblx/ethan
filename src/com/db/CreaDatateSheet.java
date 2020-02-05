package src.com.db;

import java.lang.Class;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class CreaDatateSheet {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            statement = connection.createStatement();
//            String sql = "CREATE TABLE tb_WeatherInfo(date varchar(255),dayweather varchar(255),daytemp varchar(255),nighttemp varchar(255));";//天气信息表
//            String sql = "CREATE TABLE tb_InformationContent(datatime varchar(255),content varchar(255));"; // 插入交通状态信息
//            String sql = "CREATE TABLE tb_CityCoding(name varchar(255),adcode varchar(255),citycode);"; // 插入交通状态信息
            String sql = "CREATE TABLE tb_Hospital(area varchar(255),hospitalName varchar(255),hospitalType varchar(255));";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("数据库创建成功!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
