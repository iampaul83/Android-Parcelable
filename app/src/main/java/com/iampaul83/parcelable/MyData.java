package com.iampaul83.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by iampaul83 on 4/14/15.
 * @see <a href="https://github.com/iampaul83/Android-Parcelable">GitHub</a>
 */
public class MyData implements Parcelable {

    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<SubData> subDatas = new ArrayList<>();

    /**
     * Constructs a new instance of MyData.
     */
    public MyData(String firstName, String lastName, int age, SubData... subDatas) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        Collections.addAll(this.subDatas, subDatas);
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<SubData> getSubDatas() {
        return subDatas;
    }

    @Override
    public String toString() {
        return getName() + "(" + age + ")\n" + subDatas.toString();
    }

    /**
     * To CREATE {@link MyData} from {@link Parcel}
     */
    public static final Creator<MyData> CREATOR = new Creator<MyData>() {
        @Override public MyData createFromParcel(Parcel source) { return new MyData(source); }
        @Override public MyData[] newArray(int size) { return new MyData[size]; }
    };

    /**
     * Constructs a new instance of MyData using {@link Parcel} object.
     */
    public MyData(Parcel source) {
        firstName = source.readString();
        lastName = source.readString();
        age = source.readInt();
        source.readList(subDatas, SubData.class.getClassLoader());
    }

    /**
     * Write values to output {@link Parcel}<br>
     * - Note that the order of writing and reading matters.<br>
     * - Object in the list must implement either `Serializable` or `Parcelable`
     */
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(firstName);
        destination.writeString(lastName);
        destination.writeInt(age);
        // Object in the list must implement either `Serializable` or `Parcelable`
        destination.writeList(subDatas);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
