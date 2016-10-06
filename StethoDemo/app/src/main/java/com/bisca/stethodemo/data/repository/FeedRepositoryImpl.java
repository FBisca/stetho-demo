package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.Functions;
import com.bisca.stethodemo.data.Functions.Func2;
import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.network.api.FeedApi;
import com.bisca.stethodemo.data.network.raw.RedditHotGifResponse;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedRepositoryImpl implements FeedRepository {

  private final FeedApi feedApi;
  private final FeedDao feedDao;

  public FeedRepositoryImpl(FeedApi feedApi, FeedDao feedDao) {
    this.feedApi = feedApi;
    this.feedDao = feedDao;
  }

  public void getHotGifs(
      Func2<Void, Void, Void> responseCallback,
      Functions.Func1<Throwable, Void> errorCallback
  ) {
    feedApi.getHotGifs().enqueue(new Callback<RedditHotGifResponse>() {
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

  @Override
  public List<Feed> requestListFeed(String anchor) {
    return null;
  }

  @Override
  public List<Feed> queryAllLocalFeeds() {
    return feedDao.queryAll();
  }
}
