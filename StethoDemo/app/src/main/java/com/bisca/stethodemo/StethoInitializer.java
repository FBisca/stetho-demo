package com.bisca.stethodemo;

import android.content.Context;

import okhttp3.OkHttpClient;

public interface StethoInitializer {
  void initialize(Context context);
  void addNetworkInterceptor(OkHttpClient.Builder clientBuilder);
}
