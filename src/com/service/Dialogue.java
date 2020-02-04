package src.com.service;

/**
 * 与机器人的对话服务
 */

import src.com.db.SelectDatate;
import src.com.gaode.Distance;
import src.com.gaode.WeatherInfo;
import src.com.weixin.TimingDevice;

import java.util.Scanner;

public class Dialogue {

    public static void main(String[] args) throws Exception {
        Thread thread = null;
        String serviceId_1 = "1"; // 天气查询
        String serviceId_2 = "2"; // 设置提醒
        String serviceId_3 = "3"; // 关闭提醒
        String serviceId_4 = "4"; // 路程查询

        while (true) {
            System.out.println("请选择服务编号：" + "\r\n" + "查询天气请按 1;" + "设置提醒请按 2；" + "关闭提醒请按 3；" + "路程查询请按 4；");
            String inputDatate = new Scanner(System.in).next();

            if (serviceId_1.equals(inputDatate)) {
                System.out.println("您选择的是天气查询服务。请输入要查询的城市？");
                String cityName = new Scanner(System.in).next();
                System.out.println(SelectDatate.setcityName(cityName));
                System.out.println("请根据查询结果填写城市名称和城市编号。");
                System.out.println("请输入城市名称：");
                String name = new Scanner(System.in).next();
                System.out.println("请输入城市编号：");
                String adcode = new Scanner(System.in).next();
                String info = WeatherInfo.getWeatherInfo(name, adcode);
                System.out.println(info);

            } else if (serviceId_2.equals(inputDatate)) {
                System.out.println("请设置提醒日期和时间；如，格式：08:15。");
                final String dateTime = new Scanner(System.in).next();
                System.out.println("请设置提醒内容信息：");
                final String messageContent = new Scanner(System.in).next();
                thread = new Thread() {
                    @Override
                    public void run() {
                        System.out.println("---" + dateTime);
                        System.out.println("---" + messageContent);
                        new TimingDevice().getTimingDevice(dateTime, messageContent);

                    }
                };
                thread.start();
                thread.sleep(5000);
                System.out.println("提醒设置成功！");

            } else if (serviceId_3.equals(inputDatate)) {
                try {
                    if (thread.isAlive()) {
                        thread.stop();
                        System.out.println("提醒已关闭！");

                    } else {
                        System.out.println("未曾设置提醒！");

                    }
                } catch (Exception e) {
                    System.out.println("未曾设置提醒！");

                }
            } else if (serviceId_4.equals(inputDatate)) {
                System.out.println("请输入出发地详细地址：");
                String originAddress = new Scanner(System.in).next();
                System.out.println("请输入出发地所在城市：");
                String originCity = new Scanner(System.in).next();

                System.out.println("请输入目的地详细地址：");
                String destinationAddress = new Scanner(System.in).next();
                System.out.println("请输入目的地所在城市：");
                String destinationCity = new Scanner(System.in).next();

                System.out.println(Distance.setDirectionDriving(originAddress, originCity, destinationAddress, destinationCity));

            }


        }
    }
}
