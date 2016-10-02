package com.bisca.stethodemo.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Feed implements Parcelable {

  private final String id;
  private final String title;
  private final String url;

  public Feed(String id, String title, String url) {
    this.id = id;
    this.title = title;
    this.url = url;
  }

  private Feed(Parcel in) {
    id = in.readString();
    title = in.readString();
    url = in.readString();
  }


  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(title);
    dest.writeString(url);
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public static final Creator<Feed> CREATOR = new Creator<Feed>() {
    @Override
    public Feed createFromParcel(Parcel in) {
      return new Feed(in);
    }

    @Override
    public Feed[] newArray(int size) {
      return new Feed[size];
    }
  };
}
