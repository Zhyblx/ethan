package src.com.service;

/**
 * 与机器人的对话服务
 */

import src.com.db.SelectDatate;
import src.com.gaode.Distance;
import src.com.gaode.WeatherInfo;
import src.com.respberrypi.GPIOController;
import src.com.weixin.TimingDevice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    public static void main(String[] args) {
        System.out.println("Version: 5.0");
        Thread thread = null;
        GPIOController gpioController = new GPIOController();

        try {
            String serviceId_1 = "1"; // 天气查询
            String serviceId_2 = "2"; // 设置提醒
            String serviceId_3 = "3"; // 关闭提醒
            String serviceId_4 = "4"; // 路程查询
            String serviceId_5 = "5"; // 是否莆田系医院
            String serviceId_6 = "6"; // 垃圾分类
            String serviceId_7 = "7"; // 直接查询杭州天气
            String serviceId_8 = "8"; // 打开电源
            String serviceId_9 = "9"; // 关闭电源
            String serviceId_10 = "10"; //设置定时开关
            String serviceId_11 = "11"; //关闭程序


            while (true) {
                System.out.println("请选择服务编号：" + "\r\n"
                        + "查询天气请按 1;"
                        + "设置提醒请按 2；"
                        + "关闭提醒请按 3；"
                        + "路程查询请按 4；"
                        + "莆田系医院查询请按 5；"
                        + "垃圾分类查询 6；"
                        + "杭州天气查询 7；"
                        + "打开电源请按 8;"
                        + "关闭电源请按 9;"
                        + "设置定时开关请按 10;"
                        + "关闭程序 11;"

                );
                String inputDatate = new Scanner(System.in).nextLine();

                if (serviceId_1.equals(inputDatate)) {
                    System.out.println("您选择的是天气查询服务。请输入要查询的城市？");
                    String cityName = new Scanner(System.in).nextLine();
                    System.out.println(SelectDatate.setcityName(cityName));
                    System.out.println("请根据查询结果填写城市名称和城市编号。");
                    System.out.println("请输入城市名称：");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("请输入城市编号：");
                    String adcode = new Scanner(System.in).nextLine();
                    String info = WeatherInfo.getWeatherInfo(name, adcode);
                    System.out.println(info);

                } else if (serviceId_2.equals(inputDatate)) {
                    System.out.println("请设置提醒日期和时间；如，格式：08:15。");
                    final String dateTime = new Scanner(System.in).nextLine();
                    System.out.println("请设置提醒内容信息：");
                    final String messageContent = new Scanner(System.in).nextLine();
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
                    String originAddress = new Scanner(System.in).nextLine();
                    System.out.println("请输入出发地所在城市：");
                    String originCity = new Scanner(System.in).nextLine();

                    System.out.println("请输入目的地详细地址：");
                    String destinationAddress = new Scanner(System.in).nextLine();
                    System.out.println("请输入目的地所在城市：");
                    String destinationCity = new Scanner(System.in).nextLine();

                    System.out.println(Distance.setDirectionDriving(originAddress, originCity, destinationAddress, destinationCity));

                } else if (serviceId_5.equals(inputDatate)) {
                    System.out.println("请输入所在省份：");
                    String area = new Scanner(System.in).nextLine();

                    System.out.println("请输入医院名称：");
                    String hospital = new Scanner(System.in).nextLine();
                    List<String> list = new ArrayList<String>();
                    int j = 0;
                    list.addAll(SelectDatate.setHospital(area, hospital));
                    for (int i = 0; i < list.size(); i++) {
                        if (j > 2) {
                            System.out.println("");
                            j = 0;
                        }
                        System.out.print(list.get(i));
                        j++;

                    }
                    System.out.println("");

                } else if (serviceId_6.equals(inputDatate)) {
                    System.out.println("请输入垃圾名称：");
                    String name = new Scanner(System.in).nextLine();
                    List<String> list = new ArrayList<String>();
                    int j = 0;
                    list.addAll(SelectDatate.setGarbageClassification(name));
                    for (int i = 0; i < list.size(); i++) {
                        if (j > 1) {
                            System.out.println("");
                            j = 0;
                        }
                        System.out.print(list.get(i));
                        j++;

                    }
                    System.out.println("");

                } else if (serviceId_7.equals(inputDatate)) {
                    String info = WeatherInfo.getWeatherInfo("杭州市", "330100");
                    System.out.println(info);

                } else if (serviceId_8.equals(inputDatate)) {
                    System.out.println("电源已打开…");
                    gpioController.getOpenGPIO();

                } else if (serviceId_9.equals(inputDatate)) {
                    System.out.println("电源已关闭…");
                    gpioController.getShutDownGPIO();

                } else if (serviceId_10.equals(inputDatate)) {
                    System.out.println("请设置开始时间(格式：20:19)");
                    String setTime = new Scanner(System.in).nextLine();
                    System.out.println("请设置执行时间(单位：分)");
                    int setMinute = Integer.valueOf(new Scanner(System.in).nextLine());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");//设置日期时间；格式："20:19"
                    while (true) {
                        try {
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }
                        String systemTime = simpleDateFormat.format(new Date());//new Date()为获取当前系统时间
                        String strTimer = String.valueOf(systemTime);
                        if (strTimer.equals(setTime)) {
                            System.out.println("定时开关设置成功！");
                            gpioController.getOpenGPIO();// 打开电源
                            int seconds = setMinute * 60000;
                            for (int i = 0; i <= seconds; i = i + 1000) {
                                try {
                                    Thread.sleep(1000);

                                } catch (InterruptedException e) {
                                    e.printStackTrace();

                                }
                                if (i == seconds) {
                                    System.out.println("定时开关执行结束！");
                                    gpioController.getShutDownGPIO();//关闭电源
                                    break; //跳出内层循环

                                }
                            }
                            break; //跳出外层循环
                        }
                    }

                } else if (serviceId_11.equals(inputDatate)) {
                    gpioController.getShutDownGPIO();
                    System.out.println("程序已关闭…");
                    return;

                }
            }
        } catch (Exception e) {
            System.out.println("系统关闭！");

        }
    }
}
