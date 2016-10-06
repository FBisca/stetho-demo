package com.bisca.stethodemo.data.network.api;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.network.raw.RedditHotGifResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FeedApi {

  @GET("api/57f5c3d2e4b0bcac9f7aec00")
  Call<List<Feed>> feed();

}
