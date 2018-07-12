package com.example.admin.learningandroid;

import android.os.Parcel;
import android.os.Parcelable;

public class Name_of_Person implements Parcelable {
    private String f_name;
    private String l_name;

    protected Name_of_Person(Parcel in) {
        this.f_name = in.readString();
        this.l_name = in.readString();
    }

    public Name_of_Person(String f_name, String l_name) {
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(f_name);
        dest.writeString(l_name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Name_of_Person> CREATOR = new Creator<Name_of_Person>() {
        @Override
        public Name_of_Person createFromParcel(Parcel in) {
            return new Name_of_Person(in);
        }

        @Override
        public Name_of_Person[] newArray(int size) {
            return new Name_of_Person[size];
        }
    };
}
