package com.bisca.stethodemo.di.module;

import com.bisca.stethodemo.data.network.api.FeedApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

  @Provides
  @Singleton
  public FeedApi providesRedditApi(Retrofit retrofit) {
    return retrofit.create(FeedApi.class);
  }

}
