package src.com.weixin;

import src.com.globalinterface.WeiXinInterface;

public class MessageContent {
    private String content = "";

    public MessageContent(String content) {
        this.content = content;

    }

    public String getMessageContent() {
        String contentInfo = WeiXinInterface.MESSAGEJSON[0] + this.content + WeiXinInterface.MESSAGEJSON[1];
        return contentInfo;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MessageContent("你好").getMessageContent());

    }
}
