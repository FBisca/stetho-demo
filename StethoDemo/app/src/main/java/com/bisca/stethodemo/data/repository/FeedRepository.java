package com.bisca.stethodemo.data.repository;

import java.util.List;

import com.bisca.stethodemo.data.model.Feed;

import retrofit2.Call;

public interface FeedRepository {
  Call<List<Feed>> requestListFeed();
  List<Feed> queryAllLocalFeeds(boolean asc);
  String getOrder();
  void insertAll(List<Feed> response);
}
