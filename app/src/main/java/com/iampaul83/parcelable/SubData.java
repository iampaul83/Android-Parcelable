package com.iampaul83.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iampaul83 on 4/14/15.
 * @see <a href="https://github.com/iampaul83/Android-Parcelable">GitHub</a>
 */
public class SubData implements Parcelable {
    private String type;
    private String value;

    public SubData(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return type + ": " + value;
    }

    public static final Creator<SubData> CREATOR = new Creator<SubData>() {
        @Override public SubData createFromParcel(Parcel source) { return new SubData(source); }
        @Override public SubData[] newArray(int size) { return new SubData[size]; }
    };

    private SubData(Parcel source) {
        type = source.readString();
        value = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(type);
        destination.writeString(value);
    }

}
