package src.com.gaode;

import org.json.JSONObject;
import org.json.JSONArray;
import src.com.globalinterface.GaoDeInterface;
import src.com.network.JsoupNet;

import java.util.List;
import java.util.ArrayList;

public class Distance {

    private static JSONObject jsonObject = null;
    private static JSONArray jsonArray = null;

    public static String setDirectionDriving(String originAddress, String originCity, String destinationAddress, String destinationCity) {
        String direction = "";
        String key = GaoDeInterface.KEY;
        String directionInfo = "";
        //String origin = "120.277400,30.305461"; //出发点
        //String destination = "120.246641,30.203190"; //目的地
        List<String> originList = new ArrayList<String>();
        originList.addAll(GeoregeoCode.setGeoregeoCode(originAddress, originCity));
        String originName = originList.get(0);//出发点名称
        String originID = originList.get(1);//出发点Id

        List<String> destinationList = new ArrayList<String>();
        destinationList.addAll(GeoregeoCode.setGeoregeoCode(destinationAddress, destinationCity));
        String destinationName = destinationList.get(0); //目的地名称
        String destinationID = destinationList.get(1); //目的地ID

        String output = "JSON";
        String extensions = "all";
        StringBuffer status = new StringBuffer();

        direction = JsoupNet.setConnectGet(GaoDeInterface.GETDIRECTIONDRIVING
                + "key=" + key
                + "&"
                + "origin=" + originID
                + "&"
                + "destination=" + destinationID
                + "&"
                + "output=" + output
                + "&"
                + "extensions=" + extensions
        );

        jsonObject = new JSONObject(direction);
        JSONObject routeJson = jsonObject.getJSONObject("route");
        jsonArray = routeJson.getJSONArray("paths");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObjectPaths = jsonArray.getJSONObject(i);
            String duration = jsonObjectPaths.getString("duration");//预计行驶时间
            long minutes = (Long.valueOf(duration) % (1000 * 60)) / 60;
            String distance = jsonObjectPaths.getString("distance");
            double kilometre = Math.round(Double.valueOf(distance) / 100d) / 10d;
            directionInfo = directionInfo + originName + "与" + destinationName + "的距离为" + kilometre + "公里；预计行车时间" + minutes + "分钟";

        }
        return directionInfo;

    }

    public static void main(String[] args) throws Exception {
//        System.out.println(Distance.setDirectionDriving(
//
//                "120.246641,30.203190",
//                "120.192647,30.185634"));

        System.out.println(Distance.setDirectionDriving("杭州湾信息港", "杭州", "蓝桥名苑", "杭州"));

    }
}