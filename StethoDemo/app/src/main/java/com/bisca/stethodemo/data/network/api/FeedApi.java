package com.bisca.stethodemo.data.network.api;

import com.bisca.stethodemo.data.network.raw.RedditHotGifResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FeedApi {

  @GET("/r/gifs/hot.json")
  Call<RedditHotGifResponse> getHotGifs();

}
