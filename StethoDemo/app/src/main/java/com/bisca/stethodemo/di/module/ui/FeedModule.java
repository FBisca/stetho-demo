package com.bisca.stethodemo.di.module.ui;

import com.bisca.stethodemo.data.repository.FeedRepository;
import com.bisca.stethodemo.di.ActivityScope;
import com.bisca.stethodemo.view.contract.FeedContract;
import com.bisca.stethodemo.view.presenter.FeedPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedModule {

  private final FeedContract.View view;

  public FeedModule(FeedContract.View view) {
    this.view = view;
  }

  @Provides
  @ActivityScope
  public FeedContract.Presenter providesPresenter(FeedRepository repository) {
    return new FeedPresenter(view, repository);
  }
}
