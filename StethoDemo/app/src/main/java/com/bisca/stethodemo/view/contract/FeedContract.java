package com.bisca.stethodemo.view.contract;

import com.bisca.stethodemo.data.model.Feed;

import java.util.List;

public interface FeedContract {
  interface Presenter extends BaseContract.Presenter {
    void viewCreated();
    void viewStarted();
    void viewStopped();
    void viewDestroyed();
    void clickedLoadFeeds();
  }

  interface View {
    void showNoFeedStored();
    void showLoadingFeeds();
    void showFeeds(List<Feed> feedList);
  }
}
