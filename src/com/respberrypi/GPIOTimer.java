package src.com.respberrypi;

/**
 * GPIOTimer(计时器)
 * dateTime：开始时间(格式："20:19")
 * minute：执行时间（单位：分）
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class GPIOTimer {



    /*
     * dateTime：开始时间(格式："20:19")
     * minute：执行时间（单位：分）
     * 说明：从设置的(dateTime)时间开始，执行(minute)分钟后结束
     */
    public void setControllerTime(String dateTime, int minute) {
//        GPIOController gpioController=new GPIOController();
//        GpioFactory.getInstance().unprovisionPin(GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_28, "GPIOController"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");//设置日期时间；格式："20:19"
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            String systemTime = simpleDateFormat.format(new Date());//new Date()为获取当前系统时间
            String strTimer = String.valueOf(systemTime);
            if (strTimer.equals(dateTime)) {
//                GPIOController gpioController = new GPIOController();
                GPIOController.getOpenGPIO();// 打开电源
                int seconds = minute * 60000;
                for (int i = 0; i <= seconds; i = i + 1000) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    if (i == seconds) {
                        GPIOController.getShutDownGPIO();//关闭电源
                        return; //结束方法

                    }
                }
            }
        }
    }

//    public static void main(String[] args) throws Exception {
//        GPIOTimer gpioTimer = new GPIOTimer();
//        System.out.println("开始测试>");
//        gpioTimer.setControllerTime("23:28", 1);
//
//    }
}

