package src.com.weixin;

import src.com.network.JsoupNet;
import src.com.globalinterface.WeiXinInterface;
import org.json.JSONObject;

public class AccessToken {

    private String grant_type = "client_credential";
    private String appid = "wxa7b6d5ad28473393";
    private String secret = "01ef58127b27a3a41b47fcfdb39169b1";

    public String getAccessToken() {
        String accessToken = JsoupNet.setConnectGet(WeiXinInterface.GETACCESSTOKEN +
                "grant_type=" + this.grant_type +
                "&appid=" + this.appid +
                "&secret=" + this.secret);

        JSONObject jsonObject = new JSONObject(accessToken);
        String token = jsonObject.getString("access_token").toString();

        return token;

    }


    public static void main(String[] args) throws Exception {
        AccessToken accessToken = new AccessToken();
        System.out.println(accessToken.getAccessToken());


    }
}
