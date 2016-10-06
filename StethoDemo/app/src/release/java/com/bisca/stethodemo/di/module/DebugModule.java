package com.bisca.stethodemo.di.module;

import dagger.Module;

@Module
public class DebugModule {

  @Provides
  @Singleton
  public StethoInitializer providesStethoInitializer() {
    return new StethoInitializerNoOp();
  }
}
