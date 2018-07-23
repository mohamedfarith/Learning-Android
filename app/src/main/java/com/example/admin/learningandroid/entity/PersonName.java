package com.example.admin.learningandroid.entity;

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
    public String firstName;
    public String lastName;

    public PersonName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    protected PersonName(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
    }

    public String getFname() {
        return firstName;
    }

    public String getLname() {
        return lastName;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
