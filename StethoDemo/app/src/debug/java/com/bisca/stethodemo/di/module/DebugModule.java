package com.bisca.stethodemo.di.module;

import com.bisca.stethodemo.StethoInitializer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugModule {
  @Provides
  @Singleton
  public StethoInitializer providesStethoInitializer() {
    return new StethoInitializerDebug(feedDao);
  }

}
