package com.bisca.stethodemo.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  Application providesApplication() {
    return application;
  }

  @Provides
  @Singleton
  Context providesContext() {
    return application;
  }
}
