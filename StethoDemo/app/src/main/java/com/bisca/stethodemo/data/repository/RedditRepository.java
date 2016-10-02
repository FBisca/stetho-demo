package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.Functions;
import com.bisca.stethodemo.data.Functions.Func2;
import com.bisca.stethodemo.data.network.api.RedditApi;
import com.bisca.stethodemo.data.network.raw.RedditHotGifResponse;
import com.bisca.stethodemo.view.contract.HomeContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RedditRepository {

  private final RedditApi redditApi;

  public RedditRepository(RedditApi redditApi) {
    this.redditApi = redditApi;
  }

  public void getHotGifs(
      Func2<Void, Void, Void> responseCallback,
      Functions.Func1<Throwable, Void> errorCallback
  ) {
    redditApi.getHotGifs().enqueue(new Callback<RedditHotGifResponse>() {
      @Override
      public void onResponse(Call<RedditHotGifResponse> call, Response<RedditHotGifResponse> response) {
        responseCallback.invoke(null, null);
      }

      @Override
      public void onFailure(Call<RedditHotGifResponse> call, Throwable t) {
        errorCallback.invoke(t);
      }
    });
  }
}
