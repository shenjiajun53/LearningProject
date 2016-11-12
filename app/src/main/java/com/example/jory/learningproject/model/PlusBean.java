package com.example.jory.learningproject.model;

import android.databinding.BaseObservable;

/**
 * Created by shenjj on 2016/11/12.
 */

public class PlusBean extends BaseObservable {
    private String tempString = "abc";

    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
    }
}
