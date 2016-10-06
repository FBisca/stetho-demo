package com.bisca.stethodemo.di.component;

import android.content.Context;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.di.module.AppModule;
import com.bisca.stethodemo.di.module.DataModule;
import com.bisca.stethodemo.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, DataModule.class})
public interface AppComponent {
  void inject(App application);
  Context context();
}
