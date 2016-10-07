package com.bisca.stethodemo.di.module;

import javax.inject.Singleton;

import com.bisca.stethodemo.StethoInitializer;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugModule {

  @Provides
  @Singleton
  public StethoInitializer providesStethoInitializer() {
    return new StethoInitializerNoOp();
  }
}
