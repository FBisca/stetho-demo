package com.bisca.stethodemo.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

  private static final String REDDIT_BASE_URL = "https://www.reddit.com/";

  @Provides
  @Singleton
  public OkHttpClient providesHttpClient() {
    return new OkHttpClient.Builder()
        .build();
  }

  @Provides
  @Singleton
  public Retrofit providesRetrofit(OkHttpClient httpClient) {
    return new Retrofit.Builder()
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(REDDIT_BASE_URL)
        .build();
  }
}
