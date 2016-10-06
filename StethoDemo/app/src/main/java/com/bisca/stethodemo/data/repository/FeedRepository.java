package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.model.Feed;

import java.util.List;

import retrofit2.Call;

public interface FeedRepository {
  Call<List<Feed>> requestListFeed();
  List<Feed> queryAllLocalFeeds();
}
