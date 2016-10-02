package com.bisca.stethodemo.view.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.di.component.DaggerActivityComponent;
import com.bisca.stethodemo.di.module.ui.HomeModule;
import com.bisca.stethodemo.view.contract.HomeContract.View;
import com.bisca.stethodemo.view.contract.HomeContract.Presenter;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements View {

  @Inject
  public Presenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    setContentView(R.layout.activity_home);
    initInjector();
    initActivity();
  }

  private void initInjector() {
    DaggerActivityComponent.builder()
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
