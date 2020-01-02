package com.appkey.moviecatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String judul;
    private String deskripsi;
    private String poster;

    public TvShow() {
    }

    public TvShow(String judul, String deskripsi, String poster) {
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

    protected TvShow(Parcel in) {
        judul = in.readString();
        deskripsi = in.readString();
        poster = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(deskripsi);
        dest.writeString(poster);
    }
}
