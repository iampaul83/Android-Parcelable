# Android-Parcelable
#怎麼把這專案匯入Android Studio
* 要選**Import Project...**

<img src="https://raw.githubusercontent.com/iampaul83/Android-Parcelable/gh-pages/img-as.png" alt="Android Studio 匯入專案" height="200" width="200">
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
* 剛才有提到`readString()`跟`writeString(String)`的順序不能錯，因為他們兩個都是String，錯了應該也很好發現問題所在，下面的程式一樣是順序問題，但是會有更嚴重的錯誤：
```java
public class MyData implements Parcelable {
    private String name;
    private int age;
    
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(name);
        destination.writeInt(age);
    }
    
    private MyData(Parcel source) {
        age = source.readInt();
        name = source.readString();
    }
    ...
}
```
```json
Throwing OutOfMemoryError: "Failed to allocate a 220204076 byte allocation with 4194304 free bytes and 33MB until OOM"
```
# 我就順序錯了給我OOM是哪招XDD **請小心！！！**
***
# 以上是實作一個簡單的Parcelable，在範例程式裡面還有一些其他方法運用：
* `writeTypedList(List<T>)`、`readTypedList(List<T>, Creator<T>)`
* **Activity**裡有把Parcelable放進intent的方式

***
#參考連結
http://developer.android.com/reference/android/os/Parcelable.html

http://www.developerphil.com/parcelable-vs-serializable/

http://blog.prolificinteractive.com/2014/07/18/why-we-love-parcelable/
