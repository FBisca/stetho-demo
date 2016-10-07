package com.bisca.stethodemo.data.repository;

import java.util.List;

import com.bisca.stethodemo.data.cache.SharedPreferencesManager;
import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.network.api.FeedApi;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

import retrofit2.Call;

public class FeedRepositoryImpl implements FeedRepository {

  private static final String ORDER_KEY = "order";

  private final FeedApi feedApi;
  private final FeedDao feedDao;
  private final SharedPreferencesManager preferencesManager;

  public FeedRepositoryImpl(FeedApi feedApi, FeedDao feedDao, SharedPreferencesManager manager) {
    this.feedApi = feedApi;
    this.feedDao = feedDao;
    this.preferencesManager = manager;
    initSharedPreferences();
  }

  private void initSharedPreferences() {
    String order = preferencesManager.getValue(ORDER_KEY, null);
    if (order == null) {
      preferencesManager.putValue(ORDER_KEY, "asc");
    }
  }

  @Override
  public Call<List<Feed>> requestListFeed() {
    return feedApi.feed();
  }

  @Override
  public List<Feed> queryAllLocalFeeds(boolean asc) {
    return feedDao.queryAll(asc);
  }

  @Override
  public void insertAll(List<Feed> response) {
    feedDao.insertAll(response);
  }

  @Override
  public String getOrder() {
    return preferencesManager.getValue(ORDER_KEY, "asc");
  }
}
