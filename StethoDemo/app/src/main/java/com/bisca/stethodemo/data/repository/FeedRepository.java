package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.model.Feed;

import java.util.List;

public interface FeedRepository {
  List<Feed> requestListFeed(String anchor);
  List<Feed> queryAllLocalFeeds();
}
