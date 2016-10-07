package com.bisca.stethodemo.view.contract;

import java.util.List;

import com.bisca.stethodemo.data.model.Feed;

public interface FeedContract {
  interface Presenter extends BaseContract.Presenter {
    void viewCreated();
    void clickedLoadFeeds();
    void requestClicked();
    void refreshClicked();
  }

  interface View {
    void showNoFeedStored();
    void showLoadingFeeds();
    void showFeeds(List<Feed> feedList);
    void showXablau();
  }
}
