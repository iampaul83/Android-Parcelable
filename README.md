# Android-Parcelable
***
#怎麼把這專案匯入Android Studio

***
# 透過Intent傳遞物件
* **Primitive data type**: byte, byte[], int, int[], double, String...
* **Serializable**
* **Parcelable**

***
# <a href="http://www.developerphil.com/parcelable-vs-serializable/" target="_blank">Serializable vs Parcelable 比較</a>
* ***Serializable***只要把class加上**`implements Serializable`**就結束了
* ***Parcelable***的執行效率比較快，實作稍微複雜

***
#實作Parcelable interface
* 在`writeToParcel(Parcel, int)`內將資料寫入**`Parcel`**
```java
public class MyData implements Parcelable {
    private String firstName;
    private String lastName;
    
    @Override
    public int describeContents() {
        return 0;
    }
    
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(firstName);
        destination.writeString(lastName);
    }
}
```
* 必須有個**CREATOR***（而且變數名稱跟大小寫都要一樣）*，在傳遞Parcel後會利用**CREATOR**建構物件
* 注意下面利用兩次`readString()`依序取出String，順序要和`writeString(String)`的一樣喔～
```java
public static final Creator<MyData> CREATOR = new Creator<MyData>() {
    @Override public MyData createFromParcel(Parcel source) { return new MyData(source); }
    @Override public MyData[] newArray(int size) { return new MyData[size]; }
};

private MyData(Parcel source) {
    firstName = source.readString();
    lastName = source.readString();
}
```
***
# 以上是實作一個簡單的Parcelable，在範例程式裡面還有一些其他方法運用：
* `writeTypedList(List<T>)`、`readTypedList(List<T>, Creator<T>)`
* **Activity**裡有把Parcelable放進intent的方式

***
#參考連結
http://developer.android.com/reference/android/os/Parcelable.html
http://www.developerphil.com/parcelable-vs-serializable/
