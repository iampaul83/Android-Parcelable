package com.iampaul83.parcelable;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iampaul83 on 4/14/15.
 * @see <a href="https://github.com/iampaul83/Android-Parcelable">GitHub</a>
 */
public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // retrieve datas from intent
        ArrayList<MyData> datas = getIntent().getParcelableArrayListExtra("data");
        // datas
        Log.v("datas", datas.toString());
        ((TextView) findViewById(R.id.textView)).setText(datas.toString());
    }

}
