package com.bisca.stethodemo.view.presenter;

import java.util.List;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.repository.FeedRepository;
import com.bisca.stethodemo.view.contract.FeedContract;

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
    queryDatabaseItems();
  }

  @Override
  public void clickedLoadFeeds() {
    requestItems();
  }

  @Override
  public void requestClicked() {
    requestItems();
  }

  @Override
  public void refreshClicked() {
    queryDatabaseItems();
  }

  private void feedRequested(List<Feed> response) {
    feedRepository.insertAll(response);
    view.showFeeds(response);
  }

  private void requestItems() {
    view.showLoadingFeeds();
    feedRepository.requestListFeed()
        .enqueue(new Callback<List<Feed>>() {
          @Override
          public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
            feedRequested(response.body());
          }

          @Override
          public void onFailure(Call<List<Feed>> call, Throwable t) {
          }
        });
  }

  private void queryDatabaseItems() {
    String order = feedRepository.getOrder();
    if (order.contains("xablau")) {
     view.showXablau();
    } else {
      List<Feed> feedList = feedRepository.queryAllLocalFeeds(order.equalsIgnoreCase("asc"));
      if (feedList.isEmpty()) {
        view.showNoFeedStored();
      } else {
        view.showFeeds(feedList);
      }
    }
  }
}
