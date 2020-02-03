package src.com.weixin;

import src.com.globalinterface.WeiXinInterface;
import src.com.network.JsoupNet;

public class Message {

    private String token = "";

    private void setToken(String token) {
        this.token = token;

    }

    private String getToken() {
        return this.token;

    }

    public void setMessage(String message) {
        try {
            AccessToken accessToken = new AccessToken();
            this.setToken(accessToken.getAccessToken());
            Thread.sleep(60000);// 获取微信令牌需要6秒时间(完成延迟6秒后，才可以进入下面的消息发送环节。)
            String messageInfo = JsoupNet.setConnectPost(WeiXinInterface.POSTMESSAGE + this.getToken(), message);
            System.out.println(messageInfo);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
