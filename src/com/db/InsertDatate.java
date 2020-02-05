package src.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;

public class InsertDatate {

    /*
     *
     *
     */

    public static void setInsertWeatherInfo(String datatime, String content) {

        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO tb_InformationContent VALUES ('" + datatime + "','" + content + "');"; // 通知信息内容表
//            System.out.println(sql);
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // 文件导入SQL
    public static void setCityCoding(File file) {
        try {
            Class.forName("org.sqlite.JDBC");
            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:sqlite:ethan.db");
            Statement statement = connection.createStatement();
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String sql = "";
            while ((sql = bufferedReader.readLine()) != null) {
                statement.executeUpdate(sql);

            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
//        InsertDatate.setInsertWeatherInfo("2019-12-28", "多云", "13", "7");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String SystemTime = simpleDateFormat.format(new Date());//new Date()为获取当前系统时间
        File file=new File("/Users/zhangyibin/Downloads/Untitled-1.sql");
        InsertDatate.setCityCoding(file);


    }
}
