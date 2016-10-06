package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.StethoInitializer;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

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
