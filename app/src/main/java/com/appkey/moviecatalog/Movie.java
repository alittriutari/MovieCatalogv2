package com.appkey.moviecatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String judul;
    private String deskripsi;
    private String poster;

    public Movie() {

    }

    public Movie(String judul, String deskripsi, String poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    protected Movie(Parcel in) {
        judul = in.readString();
        deskripsi = in.readString();
        poster = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeString(deskripsi);
        parcel.writeString(poster);
    }
}
