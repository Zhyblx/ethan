package src.com.network;

import src.com.globalinterface.WeiXinInterface;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

public class JsoupNet {

    private static Connection connection = null;
    private static Document document = null;

    public static String setConnectGet(String URL) {
        String documentInfo = "";
        try {
            connection = Jsoup.connect(URL);
            connection.ignoreContentType(true);
            connection.timeout(20000);
            connection.userAgent(WeiXinInterface.USERAGENT);
            document = connection.get();
            documentInfo = document.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return documentInfo;
    }

    public static String setConnectPost(String URL,String requestJson) {
        String documentInfo = "";
        try {
            connection = Jsoup.connect(URL);
            connection.ignoreContentType(true);
            connection.timeout(20000);
            connection.userAgent(WeiXinInterface.USERAGENT);
            connection.requestBody(requestJson);
            document = connection.post();
            documentInfo = document.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return documentInfo;
    }


}
