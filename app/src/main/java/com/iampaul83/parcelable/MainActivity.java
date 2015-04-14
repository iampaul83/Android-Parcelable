package com.iampaul83.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * On click listener
     */
    public void onGoAction(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        // TODO: put custom class to intent
        startActivity(intent);
    }

}
