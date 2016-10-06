package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.network.api.FeedApi;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

import java.util.List;

import retrofit2.Call;

public class FeedRepositoryImpl implements FeedRepository {

  private final FeedApi feedApi;
  private final FeedDao feedDao;

  public FeedRepositoryImpl(FeedApi feedApi, FeedDao feedDao) {
    this.feedApi = feedApi;
    this.feedDao = feedDao;
  }

  @Override
  public Call<List<Feed>> requestListFeed() {
    return feedApi.feed();
  }

  @Override
  public List<Feed> queryAllLocalFeeds() {
    return feedDao.queryAll();
  }
}
