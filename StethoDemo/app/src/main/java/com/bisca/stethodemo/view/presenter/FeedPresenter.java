package com.bisca.stethodemo.view.presenter;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.repository.FeedRepository;
import com.bisca.stethodemo.view.contract.FeedContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedPresenter implements FeedContract.Presenter {

  private final FeedContract.View view;
  private final FeedRepository feedRepository;

  public FeedPresenter(FeedContract.View view, FeedRepository feedRepository) {
    this.view = view;
    this.feedRepository = feedRepository;
  }

  @Override
  public void viewCreated() {
    List<Feed> feedList = feedRepository.queryAllLocalFeeds();
    if (feedList.isEmpty()) {
      view.showNoFeedStored();
    } else {
      view.showFeeds(feedList);
    }
  }

  @Override
  public void viewStarted() {

  }

  @Override
  public void viewStopped() {

  }

  @Override
  public void viewDestroyed() {

  }

  @Override
  public void clickedLoadFeeds() {
    feedRepository.requestListFeed()
        .enqueue(new Callback<List<Feed>>() {
          @Override
          public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
            view.showFeeds(response.body());
          }

          @Override
          public void onFailure(Call<List<Feed>> call, Throwable t) {

          }
        });
  }
}
