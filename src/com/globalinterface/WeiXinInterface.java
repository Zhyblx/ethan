package src.com.globalinterface;

public interface WeiXinInterface {

    /*
     * (一) 微信接口信息
     */
    public static final String GETACCESSTOKEN = "https://api.weixin.qq.com/cgi-bin/token?";
    public static final String POSTMESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";

    /*
     * (二) 微信JSON提交信息
     */
    public static final String[] MESSAGEJSON = {
            "{\"touser\":\"obj6vs4l6T5jb6PQ9W6yb6ivlpdU\",\"msgtype\":\"text\",\"text\":{\"content\":\""
            ,
            "\"}}"
    };


    /*
     * (三) 浏览器信息
     */

    public static final String USERAGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36";

}
