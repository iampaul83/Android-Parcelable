package com.iampaul83.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by iampaul83 on 4/14/15.
 * Hi
 */
public class MyData implements Parcelable {

    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<SubData> subDatas;

    public MyData(String firstName, String lastName, int age, ArrayList<SubData> subDatas) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subDatas = subDatas;
    }

    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override
        public MyData createFromParcel(Parcel source) {
            return new MyData(source);
        }
        @Override
        public MyData[] newArray(int size) {
            return new MyData[size];
        }
    };

    public MyData(Parcel source) {
        firstName = source.readString();
        lastName = source.readString();
        age = source.readInt();
        source.readList(subDatas, null);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeInt(age);
        dest.writeList(subDatas);
    }

}