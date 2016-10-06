package com.bisca.stethodemo;

import android.app.Application;
import android.content.Context;

import com.bisca.stethodemo.di.component.AppComponent;
import com.bisca.stethodemo.di.component.DaggerAppComponent;
import com.bisca.stethodemo.di.module.AppModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class App extends Application {

  private AppComponent graphComponent;

  @Inject
  public StethoInitializer stetho;

  @Inject
  public Picasso picasso;

  @Override
  public void onCreate() {
    super.onCreate();

    initInjection();
    initStetho();
    initPicasso();
  }

  public static AppComponent getAppComponent(Context context) {
    App app = (App) context.getApplicationContext();
    return app.graphComponent;
  }

  private void initInjection() {
    graphComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .build();

    graphComponent.inject(this);
  }

  private void initStetho() {
    stetho.initialize(this);
  }

  private void initPicasso() {
    Picasso.setSingletonInstance(picasso);
  }
}
