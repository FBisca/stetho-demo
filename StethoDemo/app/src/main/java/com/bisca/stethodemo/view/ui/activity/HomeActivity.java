package com.bisca.stethodemo.view.ui.activity;

import android.os.Bundle;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.di.component.DaggerHomeComponent;
import com.bisca.stethodemo.di.module.ui.HomeModule;
import com.bisca.stethodemo.view.contract.HomeContract.Presenter;
import com.bisca.stethodemo.view.contract.HomeContract.View;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements View {

  @Inject
  public Presenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    initInjector();
    initActivity();
  }

  private void initInjector() {
    DaggerHomeComponent.builder()
        .appComponent(App.getAppComponent(this))
        .homeModule(new HomeModule(this))
        .build()
        .inject(this);
  }

  private void initActivity() {
    findViewById(R.id.button_start_adventure).setOnClickListener(v ->
        presenter.clickedStartAdventure()
    );
  }

  @Override
  public void navigateToDashScreen() {
    startActivity(FeedActivity.getIntent(this));
    finish();
  }
}
