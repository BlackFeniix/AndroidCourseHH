package com.hito.nikolay.lesson_5_utkin;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    String value;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.value);
    }

    public Data() {
    }

    protected Data(Parcel in) {
        this.value = in.readString();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
