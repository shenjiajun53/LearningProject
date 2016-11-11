package com.example.jory.learningproject.utils;

import android.util.Log;

/**
 * Created by jiajun.shen on 8/28/15.
 */
public class TWCUrlBuilder {
    private static String TAG = "TWC weather UrlBuilder";
    private static final String APIKEY = "0efd9b4f14275d37789a2f57e5101852";

    static public String currentWeatherUrl(String lantitude, String longitude, String lang) {
        lang=reformatLang(lang);
        StringBuffer sb = new StringBuffer();
        sb.append("http://api.weather.com/v1/");
        sb.append("geocode/").append(lantitude + "/").append(longitude + "/");
        sb.append("observations/current.json?apiKey=").append(APIKEY);
        sb.append("&language=").append(lang).append("&units=m");

        Log.d(TAG, "getCurrentWeather url: " + sb.toString());
        return sb.toString();
    }

    static public String forcastHourlyWeatherUrl(String lantitude, String longitude, String lang) {
        lang=reformatLang(lang);
        StringBuffer sb = new StringBuffer();
        sb.append("http://api.weather.com/v1/");
        sb.append("geocode/").append(lantitude + "/").append(longitude + "/");
        sb.append("forecast/hourly/24hour.json?apiKey=").append(APIKEY);
        sb.append("&language=").append(lang).append("&units=m");

        Log.d(TAG, "getCurrentWeather url: " + sb.toString());
        return sb.toString();
    }

    static public String forecastDailyWeatherUrl(String lantitude, String longitude, String lang) {
        lang=reformatLang(lang);
        StringBuffer sb = new StringBuffer();
        sb.append("http://api.weather.com/v1/");
        sb.append("geocode/").append(lantitude + "/").append(longitude + "/");
        sb.append("forecast/daily/5day.json?apiKey=").append(APIKEY);
        sb.append("&language=").append(lang).append("&units=m");
        Log.d(TAG, "getDailyForecastWeather url: " + sb.toString());
        return sb.toString();
    }

//    public static String findCityByLocationKey(String locationKey, String lang, boolean withLang) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("http://api.accuweather.com/locations/v1/");
//        sb.append(locationKey);
//        sb.append(".json?apikey=");
//        sb.append(APIKEY);
//        if (withLang) {
//            sb.append("&language=").append(lang);
//        }
//        Log.d("jielong", "findCityByLocationKey url: " + sb.toString());
//        return sb.toString();
//    }

    public static String findCityByGeoLocation(String geolocation, String lang, boolean withLang) {
        lang=reformatLang(lang);
        StringBuffer sb = new StringBuffer();
        sb.append("http://api.weather.com/v2/location?");
        sb.append("geocode=").append(geolocation);
        sb.append("&language=").append(lang).append("&format=").append("json")
                .append("&apiKey=").append(APIKEY);

        Log.d(TAG, "findCityNameByKeywords url: " + sb.toString());
        return sb.toString();
    }

    public static String findCityByName(String name, String lang, boolean withLang) {
        lang=reformatLang(lang);
        /*StringBuffer sb = new StringBuffer();
        sb.append("http://api.accuweather.com/locations/v1/search?");
		sb.append("q=").append(name);
		if (withLang) {
			sb.append("&language=").append(lang);
		}
		sb.append("&apikey=").append(APIKEY);
		Log.d("jielong", "findCityByName url: " + sb.toString());
		return sendFindCityRequest(sb.toString(), ARRAY);*/
        StringBuffer sb = new StringBuffer();
        sb.append("http://api.weather.com/v2/location?");
        sb.append("address=").append(name);
        sb.append("&language=").append(lang).append("&format=").append("json")
                .append("&apiKey=").append(APIKEY);

        Log.d(TAG, "findCityNameByKeywords url: " + sb.toString());
        return sb.toString();
    }

//    public static String findCityByPostal(String postal, String lang, boolean withLang) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("http://api.accuweather.com/locations/v1/postalcodes/search.json?");
//        sb.append("q=").append(postal);
//        sb.append("&apikey=").append(APIKEY);
//        if (withLang) {
//            sb.append("&language=").append(lang);
//        }
//
//        Log.d("jielong", "findCityByPostal url: " + sb.toString());
//        return sb.toString();
//    }
    static public String reformatLang(String lang)
    {
        Log.e(TAG,"lang length="+lang.length());
        if(lang.length()>2)
        {
            String head=lang.substring(0,2);
            String tail=lang.substring(3);
            Log.e(TAG,"head="+head+" tail="+tail);
            return head+"-"+tail.toUpperCase();
        }else
        {
            return lang;
        }
    }
}
