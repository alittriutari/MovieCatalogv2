package com.appkey.moviecatalog.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String title;
    private String description;
    private int poster;

    public TvShow() {
    }

    public TvShow(String title, String description, int poster) {
        this.title = title;
        this.description = description;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    protected TvShow(Parcel in) {
        title = in.readString();
        description = in.readString();
        poster = in.readInt();
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
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(poster);
    }
}
