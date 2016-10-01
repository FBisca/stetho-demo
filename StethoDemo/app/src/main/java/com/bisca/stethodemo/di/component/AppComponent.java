package com.bisca.stethodemo.di.component;

import android.content.Context;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
  void inject(App application);
  Context context();
}
