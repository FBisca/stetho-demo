package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.StethoInitializer;

import okhttp3.OkHttpClient;

public class StethoInitializerNoOp implements StethoInitializer {

  @Override
  public void initialize(Context context) {
    // Do Nothing
  }

  @Override
  public void addNetworkInterceptor(OkHttpClient.Builder clientBuilder) {
    // Do Nothing
  }
}
