package com.iampaul83.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.ArrayList;


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
        intent.putParcelableArrayListExtra("data", getFakeDatas());
        startActivity(intent);
    }

    private ArrayList<MyData> getFakeDatas() {
        MyData fakeData1 = new MyData("Paul", "Tsai", 25,
            new SubData("phone", "0912345678"),
            new SubData("email", "iampaul783@gmail.com")
        );
        MyData fakeData2 = new MyData("John", "Chen", 35,
            new SubData("phone", "0987654321"),
            new SubData("email", "johnchen123@yahoo.com.tw"),
            new SubData("address", "桃園市中壢區太麻里隔壁")
        );
        ArrayList<MyData> list = new ArrayList<>();
        list.add(fakeData1);
        list.add(fakeData2);
        return list;
    }

}
