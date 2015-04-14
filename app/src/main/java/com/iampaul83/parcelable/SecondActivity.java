package com.iampaul83.parcelable;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<MyData> datas = getIntent().getParcelableArrayListExtra("data");
        Log.i("datas", "datas => " + datas.toString());
    }

}
