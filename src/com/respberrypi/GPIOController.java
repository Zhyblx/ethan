package src.com.respberrypi;

import com.pi4j.io.gpio.*;

import java.util.Scanner;


/**
 * GPIOController(控制器)
 * 功能：控制电源开关
 */

public class GPIOController {
    //GPIO控制器接口。此接口描述了通过GPIO进行的所有操作
    final GpioController gpioController = GpioFactory.getInstance();

    //GPIO控制树莓派的数字针脚
    final GpioPinDigitalOutput gpioPinDigitalOutput =
            //provisionDigitalOutputPin(RaspiPin.GPIO_28, "led", PinState.LOW); 是指初始化为低电平
            //gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "led", PinState.LOW);
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_28, "GPIOController");

    /*
     * 控制器：开启
     * 设置低电平
     */
    public void getOpenGPIO() {
        gpioPinDigitalOutput.low();//低电平
//        gpioController.unprovisionPin(gpioPinDigitalOutput);

    }

    /*
     * 控制器：关闭
     * 设置高电平
     *
     */
    public void getShutDownGPIO() {
        gpioPinDigitalOutput.high();
//        gpioController.unprovisionPin(gpioPinDigitalOutput);

    }

//    public static void main(String[] args) {
//        GPIOController gpioController = new GPIOController();
//        String test1 = "1";
//        String test2 = "2";
//        while (true) {
//            System.out.println("测试选择：");
//            String inputDatate = new Scanner(System.in).nextLine();
//            if (test1.equals(inputDatate)) {
//                System.out.println("开灯测试…");
//                gpioController.getOpenGPIO();
//
//            }
//
//            if (test2.equals(inputDatate)) {
//                System.out.println("关灯测试…");
//                gpioController.getShutDownGPIO();
//
//            }
//        }
//    }
}
