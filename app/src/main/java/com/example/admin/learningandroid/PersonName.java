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

    public PersonName(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }


    protected PersonName(Parcel in) {
        mFirstName = in.readString();
        mLastName = in.readString();
    }

    public String getFname() {
        return mFirstName;
    }

    public String getLname() {
        return mLastName;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
