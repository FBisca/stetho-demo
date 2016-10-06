package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.StethoInitializer;
import com.bisca.stethodemo.data.network.api.FeedApi;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetworkModule {

  private static final String BASE_URL = "https://jsonblob.com/";

  @Provides
  @Singleton
  public OkHttpClient providesHttpClient(StethoInitializer initializer) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    initializer.addNetworkInterceptor(builder);
    return builder.build();
  }

  @Provides
  @Singleton
  public Retrofit providesRetrofit(OkHttpClient httpClient) {
    return new Retrofit.Builder()
        .client(httpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build();
  }

  @Provides
  @Singleton
  public Picasso providesPicasso(Context context, OkHttpClient okHttpClient) {
    return new Picasso.Builder(context)
        .downloader(new OkHttp3Downloader(okHttpClient))
        .build();
  }

  @Provides
  @Singleton
  public FeedApi providesFeedApi(Retrofit retrofit) {
    return retrofit.create(FeedApi.class);
  }
}
