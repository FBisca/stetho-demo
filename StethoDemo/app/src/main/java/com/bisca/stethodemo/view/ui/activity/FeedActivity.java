package com.bisca.stethodemo.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.di.component.DaggerFeedComponent;
import com.bisca.stethodemo.di.module.ui.FeedModule;
import com.bisca.stethodemo.view.contract.FeedContract;
import com.bisca.stethodemo.view.contract.FeedContract.Presenter;
import com.bisca.stethodemo.view.ui.adapter.FeedAdapter;

import java.util.List;

import javax.inject.Inject;

public class FeedActivity extends BaseActivity implements FeedContract.View {

  @Inject
  public Presenter presenter;

  private RecyclerView listFeed;
  private FeedAdapter adapter;
  private View noListView;
  private View loadingView;

  public static Intent getIntent(Context context) {
    return new Intent(context, FeedActivity.class);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feed);
    initInjector();
    initActivity();

    presenter.viewCreated();
  }

  private void initActivity() {
    noListView = findViewById(R.id.no_feed_view);
    loadingView = findViewById(R.id.loading_view);
    listFeed = (RecyclerView) findViewById(R.id.list_feed);

    adapter = new FeedAdapter();
    listFeed.setLayoutManager(new LinearLayoutManager(this));
    listFeed.setAdapter(adapter);

    findViewById(R.id.button_download_items).setOnClickListener(v ->
        presenter.clickedLoadFeeds()
    );
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
    loadingView.setVisibility(View.GONE);
    listFeed.setVisibility(View.GONE);
    noListView.setVisibility(View.VISIBLE);
  }

  @Override
  public void showLoadingFeeds() {
    loadingView.setVisibility(View.VISIBLE);
    listFeed.setVisibility(View.GONE);
    noListView.setVisibility(View.GONE);
  }

  @Override
  public void showFeeds(List<Feed> feedList) {
    adapter.setItems(feedList);
    adapter.notifyDataSetChanged();

    loadingView.setVisibility(View.GONE);
    listFeed.setVisibility(View.VISIBLE);
    noListView.setVisibility(View.GONE);
  }

  private void initInjector() {
    DaggerFeedComponent.builder()
        .appComponent(App.getAppComponent(this))
        .feedModule(new FeedModule(this))
        .build()
        .inject(this);
  }
}
