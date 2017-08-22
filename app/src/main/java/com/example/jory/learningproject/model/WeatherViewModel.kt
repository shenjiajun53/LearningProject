package com.example.jory.learningproject.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.view.View
import com.example.jory.learningproject.BR
import com.example.jory.learningproject.R
import com.example.jory.learningproject.WeatherActivity
import com.example.jory.learningproject.databinding.ContentWeatherBinding
import com.example.jory.learningproject.utils.LogUtil
import com.example.jory.learningproject.utils.TWCUrlBuilder
import com.google.gson.Gson
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.content_weather.view.*
import kotlinx.android.synthetic.main.weather_info_more_detail_layout.view.*
import okhttp3.Call
import okhttp3.Response

/**
 * Created by shenjiajun on 2017/8/21.
 */

class WeatherViewModel(weatherActivity: WeatherActivity) : BaseObservable() {
    private val lang = "zh-cn"
    private val gson = Gson()
    lateinit var weatherActivity: WeatherActivity
    lateinit var weatherBinding: ContentWeatherBinding
    var cityListBean: CityListBean? = null
    var currentWeatherBean: CurrentWeatherBean? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.currentWeatherBean)
        }
    var cityBean: CityListBean.AddressesBean? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.cityBean)
        }

    fun onClick(view: View) {
//        when (view.id) {
//            R.id.expand_button -> {
//                Logger.d("123", "onclick")
//                weatherBinding.contentWeather.visibility = View.GONE
//            }
//            else -> return
//        }
    }

    fun getCity() {
        val url = TWCUrlBuilder.findCityByName("无锡", lang, false)
        OkGo.get(url)
                .tag(this)
                .cacheKey("get_city")
                .execute(object : StringCallback() {
                    override fun onSuccess(s: String, call: Call, response: Response) {
                        val cityListBean = gson.fromJson(s, CityListBean::class.java)
                        cityBean = cityListBean.addresses[0]
                        getCurrentWeatherData()
                    }
                })
    }

    private fun getCurrentWeatherData() {
        val url = TWCUrlBuilder.currentWeatherUrl(cityBean?.latitude.toString() + "", cityBean?.latitude.toString() + "", lang)
        OkGo.get(url)
                .tag(this)
                .cacheKey("get_current")
                .execute(object : StringCallback() {
                    override fun onSuccess(s: String, call: Call, response: Response) {
                        currentWeatherBean = gson.fromJson(s, CurrentWeatherBean::class.java)
                    }
                })
    }
}