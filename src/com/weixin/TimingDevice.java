package src.com.weixin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimingDevice {

    public void getTimingDevice(String dateTime, String messageContent) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");//设置日期时间；格式："20:19"

            while (true) {
                Thread.sleep(1000);
                String systemTime = simpleDateFormat.format(new Date());//new Date()为获取当前系统时间
                String strTimer = String.valueOf(systemTime);
                if (strTimer.equals(dateTime)) {
                    String info = new MessageContent(messageContent).getMessageContent();
                    Message message = new Message();
                    message.setMessage(info);
                    break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new TimingDevice().getTimingDevice("21:49", "洗脚去了。");

    }
}
