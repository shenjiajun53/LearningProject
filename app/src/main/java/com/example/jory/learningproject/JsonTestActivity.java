package com.example.jory.learningproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.jory.learningproject.model.BankListBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.orhanobut.logger.Logger;

import java.io.IOException;

public class JsonTestActivity extends AppCompatActivity {

    private TextView titleTv, contentTv;
    private String okString = " {\n" +
            "   \"result\": [\n" +
            "     {\n" +
            "       \"bankId\": 9,\n" +
            "       \"bankName\": \"中国建设银行\",\n" +
            "       \"defaultStatus\": false\n" +
            "     },\n" +
            "     {\n" +
            "       \"bankId\": 4,\n" +
            "       \"bankName\": \"中国农业银行\",\n" +
            "       \"defaultStatus\": false\n" +
            "     }\n" +
            "   ],\n" +
            "   \"error\": null\n" +
            " }";
    private String stringNullString = " {\n" +
            "   \"result\": [\n" +
            "     {\n" +
            "       \"bankId\": 9,\n" +
            "       \"bankName\": null,\n" +
            "       \"defaultStatus\": false\n" +
            "     },\n" +
            "     {\n" +
            "       \"bankId\": 4,\n" +
            "       \"bankName\": \"中国农业银行\",\n" +
            "       \"defaultStatus\": false\n" +
            "     }\n" +
            "   ],\n" +
            "   \"error\": null\n" +
            " }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseFormGson();
            }
        });

        titleTv = (TextView) findViewById(R.id.title_tv);
        contentTv = (TextView) findViewById(R.id.content_tv);
    }

    private void parseFormGson() {
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory());
        gson = gsonBuilder.create();
        BankListBean bankListBean = gson.fromJson(stringNullString, BankListBean.class);
        Logger.e(bankListBean.toString());
        Logger.e("id=" + bankListBean.getResult().get(0).getBankId());
        Logger.e("name=" + bankListBean.getResult().get(0).getBankName());

        titleTv.setText(bankListBean.getResult().get(0).getBankId() + "");
        titleTv.setText(bankListBean.getResult().get(0).getBankName());
    }

    private void parseFormFastJson() {
//        Gson gson = new Gson();
        BankListBean bankListBean = JSON.parseObject(stringNullString, BankListBean.class);
        Logger.e(bankListBean.toString());
        Logger.e("id=" + bankListBean.getResult().get(0).getBankId());
        Logger.e("name=" + bankListBean.getResult().get(0).getBankName());

        titleTv.setText(bankListBean.getResult().get(0).getBankId() + "");
        titleTv.setText(bankListBean.getResult().get(0).getBankName());
    }


    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    public static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "can not see";
            }
            return reader.nextString();
        }

        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
