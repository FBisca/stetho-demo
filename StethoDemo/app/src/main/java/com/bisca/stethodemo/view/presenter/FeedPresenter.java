package com.bisca.stethodemo.view.presenter;

import com.bisca.stethodemo.view.contract.FeedContract;

public class FeedPresenter implements FeedContract.Presenter {

  private final FeedContract.View view;

  public FeedPresenter(FeedContract.View view) {
    this.view = view;
  }

  @Override
  public void viewCreated() {

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

  }
}
