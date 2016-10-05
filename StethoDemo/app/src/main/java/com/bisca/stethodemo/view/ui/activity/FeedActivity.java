package com.bisca.stethodemo.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.di.component.DaggerActivityComponent;
import com.bisca.stethodemo.di.module.ui.FeedModule;
import com.bisca.stethodemo.view.contract.FeedContract;
import com.bisca.stethodemo.view.contract.FeedContract.Presenter;

import java.util.List;

import javax.inject.Inject;

public class FeedActivity extends BaseActivity implements FeedContract.View {

  @Inject
  public Presenter presenter;

  public static Intent getIntent(Context context) {
    return new Intent(context, FeedActivity.class);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feed);
    initInjector();

    presenter.viewCreated();
  }

  @Override
  protected void onStart() {
    super.onStart();
    presenter.viewStarted();
  }

  @Override
  protected void onStop() {
    super.onStop();
    presenter.viewStopped();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.viewDestroyed();
  }

  @Override
  public void showNoFeedStored() {

  }

  @Override
  public void showLoadingFeeds() {

  }

  @Override
  public void showFeeds(List<Feed> feedList) {

  }

  private void initInjector() {
    DaggerActivityComponent.builder()
        .appComponent(App.getAppComponent(this))
        .feedModule(new FeedModule(this))
        .build()
        .inject(this);
  }
}
