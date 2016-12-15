package com.example.jory.learningproject.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shenjj on 2016/11/11.
 */

public class CurrentWeatherBean extends BaseObservable {

    /**
     * metadata : {"language":"zh-CN","transaction_id":"1478852306614:-994620159","version":"1","latitude":31.56,"longitude":31.56,"units":"m","expire_time_gmt":1478852906,"status_code":200}
     * observation : {"class":"observation","expire_time_gmt":1478852906,"obs_time":1478852306,"obs_time_local":"2016-11-11T10:18:26+0200","wdir":10,"icon_code":30,"icon_extd":3000,"sunrise":"2016-11-11T06:18:09+0200","sunset":"2016-11-11T16:56:56+0200","day_ind":"D","uv_index":4,"uv_warning":0,"wxman":"wx1100","obs_qualifier_code":null,"ptend_code":1,"dow":"星期五","wdir_cardinal":"北風","uv_desc":"中等","phrase_12char":null,"phrase_22char":null,"phrase_32char":"局部多雲","ptend_desc":"升温","sky_cover":"局部多雲","clds":"SCT","obs_qualifier_severity":null,"vocal_key":"OT73:OX3000",
     * "metric":{"wspd":11,"gust":null,"vis":14.48,"mslp":1022.1,"altimeter":1022.01,"temp":23,"dewpt":14,"rh":59 //humidity,"wc":23,"hi":23,"temp_change_24hour":-19,"temp_max_24hour":25,"temp_min_24hour":21,"pchange":0.68,"feels_like":23,"snow_1hour":0,"snow_6hour":0,"snow_24hour":0,"snow_mtd":null,"snow_season":null,"snow_ytd":null,"snow_2day":null,"snow_3day":null,"snow_7day":null,"ceiling":null,"precip_1hour":0,"precip_6hour":0,"precip_24hour":0,"precip_mtd":null,"precip_ytd":null,"precip_2day":null,"precip_3day":null,"precip_7day":null,"obs_qualifier_100char":null,"obs_qualifier_50char":null,"obs_qualifier_32char":null}}
     */
    private String tempString = "addd";

    private MetadataBean metadata;
    private ObservationBean observation;

    @Bindable
    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
//        notifyPropertyChanged(BR.tempString);
    }

    @Bindable
    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
//        notifyPropertyChanged(BR.metadata);
    }

    @Bindable
    public ObservationBean getObservation() {
        return observation;
    }

    public void setObservation(ObservationBean observation) {
        this.observation = observation;
//        notifyPropertyChanged(BR.observation);
    }

    @BindingAdapter("blabla")
    public static void setBlabla(TextView view, String originStr) {
        view.setText(originStr + "blabla");
    }

//    @BindingAdapter({"bind:blabla", "bind:bibi"})
//    public static void setTail(TextView view, String blabla, String bibi) {
//        view.setText(blabla + bibi);
//    }

//    @BindingAdapter("android:text")
//    public static void setText(TextView view, String content) {
//        view.setText(content+"balabala");
//    }

    public static class MetadataBean extends BaseObservable {
        /**
         * language : zh-CN
         * transaction_id : 1478852306614:-994620159
         * version : 1
         * latitude : 31.56
         * longitude : 31.56
         * units : m
         * expire_time_gmt : 1478852906
         * status_code : 200
         */

        private String language;
        private String transaction_id;
        private String version;
        private double latitude;
        private double longitude;
        private String units;
        private int expire_time_gmt;
        private int status_code;

        @Bindable
        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        @Bindable
        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        @Bindable
        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Bindable
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        @Bindable
        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        @Bindable
        public String getUnits() {
            return units;
        }

        public void setUnits(String units) {
            this.units = units;
        }

        @Bindable
        public int getExpire_time_gmt() {
            return expire_time_gmt;
        }

        public void setExpire_time_gmt(int expire_time_gmt) {
            this.expire_time_gmt = expire_time_gmt;
        }

        @Bindable
        public int getStatus_code() {
            return status_code;
        }

        public void setStatus_code(int status_code) {
            this.status_code = status_code;
        }
    }

    public static class ObservationBean extends BaseObservable {
        /**
         * class : observation
         * expire_time_gmt : 1478852906
         * obs_time : 1478852306
         * obs_time_local : 2016-11-11T10:18:26+0200
         * wdir : 10
         * icon_code : 30
         * icon_extd : 3000
         * sunrise : 2016-11-11T06:18:09+0200
         * sunset : 2016-11-11T16:56:56+0200
         * day_ind : D
         * uv_index : 4
         * uv_warning : 0
         * wxman : wx1100
         * obs_qualifier_code : null
         * ptend_code : 1
         * dow : 星期五
         * wdir_cardinal : 北風
         * uv_desc : 中等
         * phrase_12char : null
         * phrase_22char : null
         * phrase_32char : 局部多雲
         * ptend_desc : 升温
         * sky_cover : 局部多雲
         * clds : SCT
         * obs_qualifier_severity : null
         * vocal_key : OT73:OX3000
         * metric : {"wspd":11,"gust":null,"vis":14.48,"mslp":1022.1,"altimeter":1022.01,"temp":23,"dewpt":14,"rh":59,"wc":23,"hi":23,"temp_change_24hour":-19,"temp_max_24hour":25,"temp_min_24hour":21,"pchange":0.68,"feels_like":23,"snow_1hour":0,"snow_6hour":0,"snow_24hour":0,"snow_mtd":null,"snow_season":null,"snow_ytd":null,"snow_2day":null,"snow_3day":null,"snow_7day":null,"ceiling":null,"precip_1hour":0,"precip_6hour":0,"precip_24hour":0,"precip_mtd":null,"precip_ytd":null,"precip_2day":null,"precip_3day":null,"precip_7day":null,"obs_qualifier_100char":null,"obs_qualifier_50char":null,"obs_qualifier_32char":null}
         */

        @SerializedName("class")
        private String classX;
        private int expire_time_gmt;
        private int obs_time;
        private String obs_time_local;
        private int wdir;
        private int icon_code;
        private int icon_extd;
        private String sunrise;
        private String sunset;
        private String day_ind;
        private int uv_index;
        private int uv_warning;
        private String wxman;
        private Object obs_qualifier_code;
        private int ptend_code;
        private String dow;
        private String wdir_cardinal;
        private String uv_desc;
        private Object phrase_12char;
        private Object phrase_22char;
        private String phrase_32char;
        private String ptend_desc;
        private String sky_cover;
        private String clds;
        private Object obs_qualifier_severity;
        private String vocal_key;
        private MetricBean metric;

        @Bindable
        public String getClassX() {
            return classX;
        }

        public void setClassX(String classX) {
            this.classX = classX;
        }

        @Bindable
        public int getExpire_time_gmt() {
            return expire_time_gmt;
        }

        public void setExpire_time_gmt(int expire_time_gmt) {
            this.expire_time_gmt = expire_time_gmt;
        }

        @Bindable
        public int getObs_time() {
            return obs_time;
        }

        public void setObs_time(int obs_time) {
            this.obs_time = obs_time;
        }

        @Bindable
        public String getObs_time_local() {
            return obs_time_local;
        }

        public void setObs_time_local(String obs_time_local) {
            this.obs_time_local = obs_time_local;
        }

        @Bindable
        public int getWdir() {
            return wdir;
        }

        public void setWdir(int wdir) {
            this.wdir = wdir;
        }

        @Bindable
        public int getIcon_code() {
            return icon_code;
        }

        public void setIcon_code(int icon_code) {
            this.icon_code = icon_code;
        }

        @Bindable
        public int getIcon_extd() {
            return icon_extd;
        }

        public void setIcon_extd(int icon_extd) {
            this.icon_extd = icon_extd;
        }

        @Bindable
        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        @Bindable
        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        @Bindable
        public String getDay_ind() {
            return day_ind;
        }

        public void setDay_ind(String day_ind) {
            this.day_ind = day_ind;
        }

        @Bindable
        public int getUv_index() {
            return uv_index;
        }

        public void setUv_index(int uv_index) {
            this.uv_index = uv_index;
        }

        @Bindable
        public int getUv_warning() {
            return uv_warning;
        }

        public void setUv_warning(int uv_warning) {
            this.uv_warning = uv_warning;
        }

        @Bindable
        public String getWxman() {
            return wxman;
        }

        public void setWxman(String wxman) {
            this.wxman = wxman;
        }

        @Bindable
        public Object getObs_qualifier_code() {
            return obs_qualifier_code;
        }

        public void setObs_qualifier_code(Object obs_qualifier_code) {
            this.obs_qualifier_code = obs_qualifier_code;
        }

        @Bindable
        public int getPtend_code() {
            return ptend_code;
        }

        public void setPtend_code(int ptend_code) {
            this.ptend_code = ptend_code;
        }

        @Bindable
        public String getDow() {
            return dow;
        }

        public void setDow(String dow) {
            this.dow = dow;
        }

        @Bindable
        public String getWdir_cardinal() {
            return wdir_cardinal;
        }

        public void setWdir_cardinal(String wdir_cardinal) {
            this.wdir_cardinal = wdir_cardinal;
        }

        @Bindable
        public String getUv_desc() {
            return uv_desc;
        }

        public void setUv_desc(String uv_desc) {
            this.uv_desc = uv_desc;
        }

        @Bindable
        public Object getPhrase_12char() {
            return phrase_12char;
        }

        public void setPhrase_12char(Object phrase_12char) {
            this.phrase_12char = phrase_12char;
        }

        @Bindable
        public Object getPhrase_22char() {
            return phrase_22char;
        }

        public void setPhrase_22char(Object phrase_22char) {
            this.phrase_22char = phrase_22char;
        }

        @Bindable
        public String getPhrase_32char() {
            return phrase_32char;
        }

        public void setPhrase_32char(String phrase_32char) {
            this.phrase_32char = phrase_32char;
        }

        @Bindable
        public String getPtend_desc() {
            return ptend_desc;
        }

        public void setPtend_desc(String ptend_desc) {
            this.ptend_desc = ptend_desc;
        }

        @Bindable
        public String getSky_cover() {
            return sky_cover;
        }

        public void setSky_cover(String sky_cover) {
            this.sky_cover = sky_cover;
        }

        @Bindable
        public String getClds() {
            return clds;
        }

        public void setClds(String clds) {
            this.clds = clds;
        }

        @Bindable
        public Object getObs_qualifier_severity() {
            return obs_qualifier_severity;
        }

        public void setObs_qualifier_severity(Object obs_qualifier_severity) {
            this.obs_qualifier_severity = obs_qualifier_severity;
        }

        @Bindable
        public String getVocal_key() {
            return vocal_key;
        }

        public void setVocal_key(String vocal_key) {
            this.vocal_key = vocal_key;
        }

        @Bindable
        public MetricBean getMetric() {
            return metric;
        }

        public void setMetric(MetricBean metric) {
            this.metric = metric;
//            notifyPropertyChanged(BR.metric);
        }

        public static class MetricBean extends BaseObservable {
            /**
             * wspd : 11
             * gust : null
             * vis : 14.48
             * mslp : 1022.1
             * altimeter : 1022.01
             * temp : 23
             * dewpt : 14
             * rh : 59
             * wc : 23
             * hi : 23
             * temp_change_24hour : -19
             * temp_max_24hour : 25
             * temp_min_24hour : 21
             * pchange : 0.68
             * feels_like : 23
             * snow_1hour : 0
             * snow_6hour : 0
             * snow_24hour : 0
             * snow_mtd : null
             * snow_season : null
             * snow_ytd : null
             * snow_2day : null
             * snow_3day : null
             * snow_7day : null
             * ceiling : null
             * precip_1hour : 0
             * precip_6hour : 0
             * precip_24hour : 0
             * precip_mtd : null
             * precip_ytd : null
             * precip_2day : null
             * precip_3day : null
             * precip_7day : null
             * obs_qualifier_100char : null
             * obs_qualifier_50char : null
             * obs_qualifier_32char : null
             */

            private int wspd;
            private Object gust;
            private double vis;
            private double mslp;
            private double altimeter;
            private int temp;
            private int dewpt;
            private int rh;
            private int wc;
            private int hi;
            private int temp_change_24hour;
            private int temp_max_24hour;
            private int temp_min_24hour;
            private double pchange;
            private int feels_like;
            private int snow_1hour;
            private int snow_6hour;
            private int snow_24hour;
            private Object snow_mtd;
            private Object snow_season;
            private Object snow_ytd;
            private Object snow_2day;
            private Object snow_3day;
            private Object snow_7day;
            private Object ceiling;
            private int precip_1hour;
            private int precip_6hour;
            private float precip_24hour;
            private Object precip_mtd;
            private Object precip_ytd;
            private Object precip_2day;
            private Object precip_3day;
            private Object precip_7day;
            private Object obs_qualifier_100char;
            private Object obs_qualifier_50char;
            private Object obs_qualifier_32char;

            @Bindable
            public int getWspd() {
                return wspd;
            }

            public void setWspd(int wspd) {
                this.wspd = wspd;
            }

            @Bindable
            public Object getGust() {
                return gust;
            }

            public void setGust(Object gust) {
                this.gust = gust;
            }

            @Bindable
            public double getVis() {
                return vis;
            }

            public void setVis(double vis) {
                this.vis = vis;
            }

            @Bindable
            public double getMslp() {
                return mslp;
            }

            public void setMslp(double mslp) {
                this.mslp = mslp;
            }

            @Bindable
            public double getAltimeter() {
                return altimeter;
            }

            public void setAltimeter(double altimeter) {
                this.altimeter = altimeter;
            }

            @Bindable
            public int getTemp() {
                return temp;
            }

            public void setTemp(int temp) {
                this.temp = temp;
//                notifyPropertyChanged(BR.temp);
            }

            @Bindable
            public int getDewpt() {
                return dewpt;
            }

            @Bindable
            public void setDewpt(int dewpt) {
                this.dewpt = dewpt;
            }

            public int getRh() {
                return rh;
            }

            public void setRh(int rh) {
                this.rh = rh;
            }

            public int getWc() {
                return wc;
            }

            public void setWc(int wc) {
                this.wc = wc;
            }

            public int getHi() {
                return hi;
            }

            public void setHi(int hi) {
                this.hi = hi;
            }

            public int getTemp_change_24hour() {
                return temp_change_24hour;
            }

            public void setTemp_change_24hour(int temp_change_24hour) {
                this.temp_change_24hour = temp_change_24hour;
            }

            public int getTemp_max_24hour() {
                return temp_max_24hour;
            }

            public void setTemp_max_24hour(int temp_max_24hour) {
                this.temp_max_24hour = temp_max_24hour;
            }

            public int getTemp_min_24hour() {
                return temp_min_24hour;
            }

            public void setTemp_min_24hour(int temp_min_24hour) {
                this.temp_min_24hour = temp_min_24hour;
            }

            public double getPchange() {
                return pchange;
            }

            public void setPchange(double pchange) {
                this.pchange = pchange;
            }

            public int getFeels_like() {
                return feels_like;
            }

            public void setFeels_like(int feels_like) {
                this.feels_like = feels_like;
            }

            public int getSnow_1hour() {
                return snow_1hour;
            }

            public void setSnow_1hour(int snow_1hour) {
                this.snow_1hour = snow_1hour;
            }

            public int getSnow_6hour() {
                return snow_6hour;
            }

            public void setSnow_6hour(int snow_6hour) {
                this.snow_6hour = snow_6hour;
            }

            public int getSnow_24hour() {
                return snow_24hour;
            }

            public void setSnow_24hour(int snow_24hour) {
                this.snow_24hour = snow_24hour;
            }

            public Object getSnow_mtd() {
                return snow_mtd;
            }

            public void setSnow_mtd(Object snow_mtd) {
                this.snow_mtd = snow_mtd;
            }

            public Object getSnow_season() {
                return snow_season;
            }

            public void setSnow_season(Object snow_season) {
                this.snow_season = snow_season;
            }

            public Object getSnow_ytd() {
                return snow_ytd;
            }

            public void setSnow_ytd(Object snow_ytd) {
                this.snow_ytd = snow_ytd;
            }

            public Object getSnow_2day() {
                return snow_2day;
            }

            public void setSnow_2day(Object snow_2day) {
                this.snow_2day = snow_2day;
            }

            public Object getSnow_3day() {
                return snow_3day;
            }

            public void setSnow_3day(Object snow_3day) {
                this.snow_3day = snow_3day;
            }

            public Object getSnow_7day() {
                return snow_7day;
            }

            public void setSnow_7day(Object snow_7day) {
                this.snow_7day = snow_7day;
            }

            public Object getCeiling() {
                return ceiling;
            }

            public void setCeiling(Object ceiling) {
                this.ceiling = ceiling;
            }

            public int getPrecip_1hour() {
                return precip_1hour;
            }

            public void setPrecip_1hour(int precip_1hour) {
                this.precip_1hour = precip_1hour;
            }

            public int getPrecip_6hour() {
                return precip_6hour;
            }

            public void setPrecip_6hour(int precip_6hour) {
                this.precip_6hour = precip_6hour;
            }

            public float getPrecip_24hour() {
                return precip_24hour;
            }

            public void setPrecip_24hour(float precip_24hour) {
                this.precip_24hour = precip_24hour;
            }

            public Object getPrecip_mtd() {
                return precip_mtd;
            }

            public void setPrecip_mtd(Object precip_mtd) {
                this.precip_mtd = precip_mtd;
            }

            public Object getPrecip_ytd() {
                return precip_ytd;
            }

            public void setPrecip_ytd(Object precip_ytd) {
                this.precip_ytd = precip_ytd;
            }

            public Object getPrecip_2day() {
                return precip_2day;
            }

            public void setPrecip_2day(Object precip_2day) {
                this.precip_2day = precip_2day;
            }

            public Object getPrecip_3day() {
                return precip_3day;
            }

            public void setPrecip_3day(Object precip_3day) {
                this.precip_3day = precip_3day;
            }

            public Object getPrecip_7day() {
                return precip_7day;
            }

            public void setPrecip_7day(Object precip_7day) {
                this.precip_7day = precip_7day;
            }

            public Object getObs_qualifier_100char() {
                return obs_qualifier_100char;
            }

            public void setObs_qualifier_100char(Object obs_qualifier_100char) {
                this.obs_qualifier_100char = obs_qualifier_100char;
            }

            public Object getObs_qualifier_50char() {
                return obs_qualifier_50char;
            }

            public void setObs_qualifier_50char(Object obs_qualifier_50char) {
                this.obs_qualifier_50char = obs_qualifier_50char;
            }

            public Object getObs_qualifier_32char() {
                return obs_qualifier_32char;
            }

            public void setObs_qualifier_32char(Object obs_qualifier_32char) {
                this.obs_qualifier_32char = obs_qualifier_32char;
            }
        }
    }
}
