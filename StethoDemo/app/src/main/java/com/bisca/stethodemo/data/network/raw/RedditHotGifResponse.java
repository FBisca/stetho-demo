package com.bisca.stethodemo.data.network.raw;

import java.util.List;

public class RedditHotGifResponse {

  public final ResponseData data;

  public RedditHotGifResponse(ResponseData data) {
    this.data = data;
  }

  public class ResponseData {
    public final List<Children> children;

    public ResponseData(List<Children> children) {
      this.children = children;
    }
  }

  public class Children {
    public final Data data;

    public Children(Data data) {
      this.data = data;
    }
  }

  public class Data {
    public final String id;
    public final String title;
    public final String url;

    public Data(String id, String title, String url) {
      this.id = id;
      this.title = title;
      this.url = url;
    }
  }
}
