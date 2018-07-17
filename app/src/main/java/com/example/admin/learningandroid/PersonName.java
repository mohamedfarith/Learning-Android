package com.example.admin.learningandroid;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonName implements Parcelable {
    public static final Creator<PersonName> CREATOR = new Creator<PersonName>() {
        @Override
        public PersonName createFromParcel(Parcel in) {
            return new PersonName(in);
        }

        @Override
        public PersonName[] newArray(int size) {
            return new PersonName[size];
        }
    };
    private String mFirstName;
    private String mLastName;

    protected PersonName(Parcel in) {
        this.mFirstName = in.readString();
        this.mLastName = in.readString();
    }

    public PersonName(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getF_name() {
        return mFirstName;
    }

    public String getL_name() {
        return mLastName;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
