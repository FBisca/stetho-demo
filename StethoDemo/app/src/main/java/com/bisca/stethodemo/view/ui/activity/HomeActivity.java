package com.bisca.stethodemo.view.ui.activity;

import javax.inject.Inject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.R;
import com.bisca.stethodemo.di.component.DaggerHomeComponent;
import com.bisca.stethodemo.di.module.ui.HomeModule;
import com.bisca.stethodemo.view.contract.HomeContract.Presenter;
import com.bisca.stethodemo.view.contract.HomeContract.View;

public class HomeActivity extends BaseActivity implements View, TextWatcher {

  @Inject
  public Presenter presenter;

  private TextView title;
  private ImageView logo;

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
    title = (TextView) findViewById(R.id.title);
    logo = (ImageView) findViewById(R.id.logo);

    findViewById(R.id.button_start_adventure).setOnClickListener(v ->
        presenter.clickedStartAdventure()
    );
    title.addTextChangedListener(this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    title.removeTextChangedListener(this);
  }

  @Override
  public void navigateToDashScreen() {
    startActivity(FeedActivity.getIntent(this));
    finish();
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void afterTextChanged(Editable editable) {
    presenter.textChanged(editable.toString());
  }

  @Override
  public void animateLogo() {
    AnimatorSet setao = new AnimatorSet();
    AnimatorSet set0 = new AnimatorSet();
    set0.playTogether(
        ObjectAnimator.ofFloat(logo, "scaleX", 1f, 0.5f),
        ObjectAnimator.ofFloat(logo, "scaleY", 1f, 0.5f)
    );
    set0.setInterpolator(new FastOutSlowInInterpolator());

    AnimatorSet set1 = new AnimatorSet();
    set1.playTogether(
        ObjectAnimator.ofFloat(logo, "scaleX", 0.5f, 1f),
        ObjectAnimator.ofFloat(logo, "scaleY", 0.5f, 1f)
    );
    set1.setInterpolator(new BounceInterpolator());

    setao.playSequentially(set0, set1);
    setao.setDuration(getResources().getInteger(android.R.integer.config_longAnimTime));
    setao.start();
  }
}
