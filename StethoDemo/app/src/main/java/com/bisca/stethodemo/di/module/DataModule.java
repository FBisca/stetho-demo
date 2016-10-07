package com.bisca.stethodemo.di.module;

import javax.inject.Singleton;

import android.content.Context;

import com.bisca.stethodemo.data.cache.SharedPreferencesManager;
import com.bisca.stethodemo.data.network.api.FeedApi;
import com.bisca.stethodemo.data.repository.FeedRepository;
import com.bisca.stethodemo.data.repository.FeedRepositoryImpl;
import com.bisca.stethodemo.data.sqlite.DatabaseHelper;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;

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
  public FeedRepository providesFeedRepository(FeedApi feedApi, FeedDao feedDao, SharedPreferencesManager manager) {
    return new FeedRepositoryImpl(feedApi, feedDao, manager);
  }

  @Provides
  @Singleton
  public SharedPreferencesManager providesSharedPreferencesManager(Context context) {
    return new SharedPreferencesManager(context);
  }
}
