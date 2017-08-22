package com.example.jory.learningproject

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import com.example.jory.learningproject.databinding.ContentWeatherBinding
import com.example.jory.learningproject.model.CityListBean
import com.example.jory.learningproject.model.CurrentWeatherBean
import com.example.jory.learningproject.model.WeatherViewModel
import com.example.jory.learningproject.views.ExpandButton
import com.google.gson.Gson
import com.orhanobut.logger.Logger

/**
 * Created by shenjiajun on 2017/8/22.
 */
class WeatherActivity : AppCompatActivity() {
    private val TAG = "WeatherActivity"

    private var contentLayout: ScrollView? = null
    lateinit var contentWeatherBinding: ContentWeatherBinding
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val rootView = findViewById(R.id.root_view) as ViewGroup
        contentLayout = findViewById(R.id.content_weather) as ScrollView
        contentWeatherBinding = DataBindingUtil.bind<ContentWeatherBinding>(contentLayout)

        weatherViewModel = WeatherViewModel(this@WeatherActivity)
        contentWeatherBinding.viewModel = weatherViewModel

        weatherViewModel.weatherBinding = contentWeatherBinding

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { weatherViewModel.getCity() }

        contentWeatherBinding.currentLayout?.expandButton?.setExpandButtonListener { isExpand ->
            Logger.d("12345", "expand onclick")
            if (isExpand) {
                contentWeatherBinding.currentLayout?.moreDetailLayout?.moreDetailLayout?.visibility = View.VISIBLE
            } else {
                contentWeatherBinding.currentLayout?.moreDetailLayout?.moreDetailLayout?.visibility = View.GONE
            }
        }
    }
}