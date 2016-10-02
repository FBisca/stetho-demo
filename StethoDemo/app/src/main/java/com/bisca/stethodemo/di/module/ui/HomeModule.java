package com.bisca.stethodemo.di.module.ui;

import com.bisca.stethodemo.di.ActivityScope;
import com.bisca.stethodemo.view.contract.HomeContract.Presenter;
import com.bisca.stethodemo.view.contract.HomeContract.View;
import com.bisca.stethodemo.view.presenter.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

  private final View view;

  public HomeModule(View view) {
    this.view = view;
  }

  @Provides
  @ActivityScope
  Presenter providesPresenter() {
    return new HomePresenter(view);
  }
}
