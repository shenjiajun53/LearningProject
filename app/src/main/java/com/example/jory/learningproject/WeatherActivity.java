package com.example.jory.learningproject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jory.learningproject.databinding.ContentWeatherBinding;
import com.example.jory.learningproject.model.CityListBean;
import com.example.jory.learningproject.model.CurrentWeatherBean;
import com.example.jory.learningproject.model.WeatherViewModel;
import com.example.jory.learningproject.utils.TWCUrlBuilder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.orhanobut.logger.Logger;

import okhttp3.Call;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    private String TAG = "WeatherActivity";

    private String lang = "zh-cn";
    private Gson gson = new Gson();
    private CityListBean cityListBean;
    private CityListBean.AddressesBean cityBean;
    private CurrentWeatherBean currentWeatherBean;

    private TextView currentTempTv;
    private ScrollView contentLayout;
    ContentWeatherBinding contentWeatherBinding;
    WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
//        activityWeatherBinding.setCurrentBean(currentWeatherBean);
        setContentView(R.layout.activity_weather);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewGroup rootView = (ViewGroup) findViewById(R.id.root_view);
        contentLayout = (ScrollView) findViewById(R.id.content_weather);
        contentWeatherBinding = DataBindingUtil.bind(contentLayout);

        weatherViewModel = new WeatherViewModel(WeatherActivity.this);
        contentWeatherBinding.setViewModel(weatherViewModel);

        weatherViewModel.setWeatherBinding(contentWeatherBinding);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherViewModel.getCity();
            }
        });

        currentTempTv = (TextView) findViewById(R.id.tv_temp);

    }
}
