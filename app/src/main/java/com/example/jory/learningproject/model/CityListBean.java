package com.example.jory.learningproject.model;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * Created by shenjj on 2016/11/11.
 */

public class CityListBean extends BaseObservable{

    /**
     * metadata : {"version":"v2","transaction_id":"947e7990-b9c8-4f0d-be79-90b9c88f0de9","generated_time":1478851162,"total_cache_time_secs":86400,"status_code":200,"language":"en-US","address":"wuxi","format":"json"}
     * addresses : [{"locality":"Wuxing District","address":"Wuxing District, Huzhou, Zhejiang, China","admin_district_name":"Zhejiang","longitude":120.107,"admin_district":"Zhejiang","country_code":"CN","place_id":"ab9a8237317bdcceb9d23b2e9966c1a0e480c8f7483e3d0ba878197f09093819","latitude":30.867,"display_name":"Wuxing District","country":"China"},{"locality":"Wuxi County","address":"Wuxi County, Chongqing, China","longitude":109.345,"country_code":"CN","place_id":"406e4087a87fadd92935748f128c6cda49b5fa434e489eb2aa284c200873ecf9","latitude":31.506,"display_name":"Wuxi County","country":"China"},{"locality":"Wuxiang County","address":"Wuxiang County, Changzhi, Shanxi, China","admin_district_name":"Shanxi","longitude":112.86,"admin_district":"Shanxi","country_code":"CN","place_id":"de7aa0e807afb14db22475453a73ac35d29d3e395d9df18d4a94d1fa4c083d05","latitude":36.833,"display_name":"Wuxiang County","country":"China"},{"address":"Wuxi, Jiangsu, China","admin_district_name":"Jiangsu","longitude":120.283,"admin_district":"Jiangsu","country_code":"CN","place_id":"50cadea57a6170d7c7d86ad4e0f94d6d2e2373155811f1c1e142513c5209ca85","latitude":31.567,"display_name":"Wuxi","country":"China"}]
     */

    private MetadataBean metadata;
    private List<AddressesBean> addresses;

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public List<AddressesBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesBean> addresses) {
        this.addresses = addresses;
    }

    public static class MetadataBean {
        /**
         * version : v2
         * transaction_id : 947e7990-b9c8-4f0d-be79-90b9c88f0de9
         * generated_time : 1478851162
         * total_cache_time_secs : 86400
         * status_code : 200
         * language : en-US
         * address : wuxi
         * format : json
         */

        private String version;
        private String transaction_id;
        private int generated_time;
        private int total_cache_time_secs;
        private int status_code;
        private String language;
        private String address;
        private String format;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public int getGenerated_time() {
            return generated_time;
        }

        public void setGenerated_time(int generated_time) {
            this.generated_time = generated_time;
        }

        public int getTotal_cache_time_secs() {
            return total_cache_time_secs;
        }

        public void setTotal_cache_time_secs(int total_cache_time_secs) {
            this.total_cache_time_secs = total_cache_time_secs;
        }

        public int getStatus_code() {
            return status_code;
        }

        public void setStatus_code(int status_code) {
            this.status_code = status_code;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }

    public static class AddressesBean extends BaseObservable{
        /**
         * locality : Wuxing District
         * address : Wuxing District, Huzhou, Zhejiang, China
         * admin_district_name : Zhejiang
         * longitude : 120.107
         * admin_district : Zhejiang
         * country_code : CN
         * place_id : ab9a8237317bdcceb9d23b2e9966c1a0e480c8f7483e3d0ba878197f09093819
         * latitude : 30.867
         * display_name : Wuxing District
         * country : China
         */

        private String locality;
        private String address;
        private String admin_district_name;
        private double longitude;
        private String admin_district;
        private String country_code;
        private String place_id;
        private double latitude;
        private String display_name;
        private String country;

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAdmin_district_name() {
            return admin_district_name;
        }

        public void setAdmin_district_name(String admin_district_name) {
            this.admin_district_name = admin_district_name;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getAdmin_district() {
            return admin_district;
        }

        public void setAdmin_district(String admin_district) {
            this.admin_district = admin_district;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
