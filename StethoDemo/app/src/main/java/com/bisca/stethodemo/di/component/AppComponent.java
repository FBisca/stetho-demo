package com.bisca.stethodemo.di.component;

import android.content.Context;

import com.bisca.stethodemo.App;
import com.bisca.stethodemo.di.module.AppModule;
import com.bisca.stethodemo.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
  void inject(App application);
  Context context();
}
