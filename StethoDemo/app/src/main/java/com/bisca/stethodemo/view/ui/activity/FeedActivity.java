package com.bisca.stethodemo.view.ui.activity;

import java.util.List;

import javax.inject.Inject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.di.component.DaggerFeedComponent;
import com.bisca.stethodemo.di.module.ui.FeedModule;
import com.bisca.stethodemo.view.contract.FeedContract;
import com.bisca.stethodemo.view.contract.FeedContract.Presenter;
import com.bisca.stethodemo.view.ui.adapter.FeedAdapter;

public class FeedActivity extends BaseActivity implements FeedContract.View {

  @Inject
  public Presenter presenter;

  private RecyclerView listFeed;
  private FeedAdapter adapter;
  private Toolbar toolbar;

  private View xablauView;
  private View xablau;
  private View noListView;
  private View loadingView;
  private AnimatorSet animatorSet;

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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.menu_feed, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_item_refresh:
        presenter.refreshClicked();
        return true;
      case R.id.menu_item_request:
        presenter.requestClicked();
        return true;

    }
    return super.onOptionsItemSelected(item);
  }

  private void initActivity() {
    xablau = findViewById(R.id.xablau);
    xablauView = findViewById(R.id.xablau_view);
    noListView = findViewById(R.id.no_feed_view);
    loadingView = findViewById(R.id.loading_view);
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    listFeed = (RecyclerView) findViewById(R.id.list_feed);

    setSupportActionBar(toolbar);
    toolbar.setTitle("Stetho");

    adapter = new FeedAdapter();
    listFeed.setLayoutManager(new LinearLayoutManager(this));
    listFeed.setAdapter(adapter);

    findViewById(R.id.button_download_items).setOnClickListener(v ->
        presenter.clickedLoadFeeds()
    );
  }

  @Override
  public void showNoFeedStored() {
    loadingView.setVisibility(View.GONE);
    listFeed.setVisibility(View.GONE);
    noListView.setVisibility(View.VISIBLE);
    xablauView.setVisibility(View.GONE);

    stopAnimation();
  }

  @Override
  public void showLoadingFeeds() {
    loadingView.setVisibility(View.VISIBLE);
    listFeed.setVisibility(View.GONE);
    noListView.setVisibility(View.GONE);
    xablauView.setVisibility(View.GONE);

    stopAnimation();
  }

  @Override
  public void showFeeds(List<Feed> feedList) {
    adapter.setItems(feedList);
    adapter.notifyDataSetChanged();

    loadingView.setVisibility(View.GONE);
    listFeed.setVisibility(View.VISIBLE);
    noListView.setVisibility(View.GONE);
    xablauView.setVisibility(View.GONE);

    stopAnimation();
  }

  @Override
  public void showXablau() {
    loadingView.setVisibility(View.GONE);
    listFeed.setVisibility(View.GONE);
    noListView.setVisibility(View.GONE);
    xablauView.setVisibility(View.VISIBLE);

    animateXablau();
  }

  private void stopAnimation() {
    if (animatorSet != null) {
      animatorSet.cancel();
      animatorSet = null;
    }
  }

  private void animateXablau() {
    stopAnimation();

    AnimatorSet setao = new AnimatorSet();
    AnimatorSet set0 = new AnimatorSet();
    set0.playTogether(
        ObjectAnimator.ofFloat(xablau, "scaleX", 1f, 1.2f),
        ObjectAnimator.ofFloat(xablau, "scaleY", 1f, 1.2f)
    );

    AnimatorSet set1 = new AnimatorSet();
    set1.playTogether(
        ObjectAnimator.ofFloat(xablau, "scaleX", 1.2f, 1f),
        ObjectAnimator.ofFloat(xablau, "scaleY", 1.2f, 1f)
    );

    setao.addListener(new AnimatorListenerAdapter() {
        private boolean cancelled;

        @Override
        public void onAnimationStart(Animator animation) {
          cancelled = false;
        }

        @Override
        public void onAnimationCancel(Animator animation) {
          cancelled = true;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
          if (!cancelled) {
            animation.start();
          }
        }
    });
    setao.setInterpolator(new FastOutSlowInInterpolator());
    setao.playSequentially(set0, set1);
    setao.start();

    animatorSet = setao;
  }

  private void initInjector() {
    DaggerFeedComponent.builder()
        .appComponent(App.getAppComponent(this))
        .feedModule(new FeedModule(this))
        .build()
        .inject(this);
  }
}
