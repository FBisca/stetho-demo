package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.data.network.api.FeedApi;
import com.bisca.stethodemo.data.repository.FeedRepository;
import com.bisca.stethodemo.data.repository.FeedRepositoryImpl;
import com.bisca.stethodemo.data.sqlite.DatabaseHelper;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

  @Provides
  @Singleton
  public DatabaseHelper providesDataBaseHelper(Context context) {
    return new DatabaseHelper(context);
  }

  @Provides
  @Singleton
  public FeedDao providesFeedDao(DatabaseHelper databaseHelper) {
    return new FeedDao(databaseHelper);
  }

  @Provides
  @Singleton
  public FeedRepository providesFeedRepository(FeedApi feedApi, FeedDao feedDao) {
    return new FeedRepositoryImpl(feedApi, feedDao);
  }
}
