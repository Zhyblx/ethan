package src.com.gaode;

import org.json.JSONObject;
import org.json.JSONArray;
import src.com.globalinterface.GaoDeInterface;
import src.com.network.JsoupNet;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 * 类:GeoregeoCode
 * 用途:地图坐标的经纬度查询
 */

public class GeoregeoCode {

    private static JSONObject jsonObject = null;

    public static List<String> setGeoregeoCode(String address, String city) {
        List<String> list = new ArrayList<String>();
        String georegeoCode = "";
        georegeoCode = JsoupNet.setConnectGet(
                GaoDeInterface.GETGEOREGEOCODE
                        + "key=" + GaoDeInterface.KEY
                        + "&"
                        + "address=" + address
                        + "&"
                        + "city=" + city
        );
        jsonObject = new JSONObject(georegeoCode);
        JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
        String geocodes = jsonArray.get(0).toString();

        jsonObject = new JSONObject(geocodes);
        String formatted_address = jsonObject.getString("formatted_address");
        String location = jsonObject.getString("location");
        list.add(formatted_address);
        list.add(location);
//        System.out.println(formatted_address);
//        georegeoCodeInfo = formatted_address + ":" + location;
        return list;

    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入地址：");
        String address = scanner.next();
        System.out.println("请输入所在城市：");
        String city = scanner.next();
        System.out.println(GeoregeoCode.setGeoregeoCode(address, city));

    }
}