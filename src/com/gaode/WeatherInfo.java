package src.com.gaode;

import src.com.globalinterface.GaoDeInterface;
import src.com.network.JsoupNet;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * 获取天气信息
 */

public class WeatherInfo {

    private static JSONObject jsonObject = null;
    private static JSONArray jsonArray = null;

    public static String getWeatherInfo(String cityName, String adcode) {
        String weather = "";
        String weatherInfo = cityName + ":";
        String key = GaoDeInterface.KEY;
        String city = adcode;
        String extensions = "all";
        String output = "JSON";

        weather = JsoupNet.setConnectGet(GaoDeInterface.GETWEATHERINFO
                + "key=" + key
                + "&"
                + "city=" + city
                + "&"
                + "extensions=" + extensions
                + "&"
                + "output=" + output);

        jsonObject = new JSONObject(weather);
        jsonArray = jsonObject.getJSONArray("forecasts");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonInfo = jsonArray.getJSONObject(i);
            JSONArray jsonCasts = jsonInfo.getJSONArray("casts");
            for (int j = 0; j < jsonCasts.length(); j++) {
                if (j == 2) {
                    break;

                }
                JSONObject jsonObjectCasts = jsonCasts.getJSONObject(j);
                String date = jsonObjectCasts.getString("date");
                String dayweather = jsonObjectCasts.getString("dayweather");//白天天气现象
                String daytemp = jsonObjectCasts.getString("daytemp");//白天温度
                String nighttemp = jsonObjectCasts.getString("nighttemp");// 晚上温度
                if (!weather.equals("")) {
                    weatherInfo = weatherInfo + date + "," + dayweather + "," + "最低气温" + nighttemp
                            + "度，" + "最高气温" + daytemp + "度。";

                }
                /*
                 * 存储当天天气数据
                 */
//                if (j == 0) {
//                    InsertDatate.setInsertWeatherInfo(date, dayweather, daytemp, nighttemp);
//
//                }

            }
        }
        // 错误判断，实现代码
        if (weatherInfo.equals(cityName)) {
            weatherInfo = "查无结果！";

        }
        return weatherInfo;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(WeatherInfo.getWeatherInfo("嘉兴市", "330400"));
        System.out.println(WeatherInfo.getWeatherInfo("嘉兴市市辖区", "330401"));

    }
}
