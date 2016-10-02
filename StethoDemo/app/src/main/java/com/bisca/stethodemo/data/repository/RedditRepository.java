package com.bisca.stethodemo.data.repository;

import com.bisca.stethodemo.data.model.Feed;

import java.util.List;

public interface RedditRepository {
  List<Feed> requestListFeed(String anchor);
  boolean hasFeedStored();
}
