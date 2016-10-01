package com.bisca.stethodemo;

import android.app.Application;
import android.content.Context;

import com.bisca.stethodemo.di.component.AppComponent;
import com.bisca.stethodemo.di.component.DaggerAppComponent;
import com.bisca.stethodemo.di.module.AppModule;
import com.facebook.stetho.Stetho;

public class App extends Application {

  private AppComponent graphComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    initInjection();
    initStetho();
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
    Stetho.initializeWithDefaults(this);
  }
}
