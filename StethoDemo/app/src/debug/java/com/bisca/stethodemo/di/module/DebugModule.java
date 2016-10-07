package com.bisca.stethodemo.di.module;

import javax.inject.Singleton;

import com.bisca.stethodemo.StethoInitializer;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

import dagger.Module;
import dagger.Provides;

@Module
public class DebugModule {
  @Provides
  @Singleton
  public StethoInitializer providesStethoInitializer(FeedDao feedDao) {
    return new StethoInitializerDebug(feedDao);
  }

}
