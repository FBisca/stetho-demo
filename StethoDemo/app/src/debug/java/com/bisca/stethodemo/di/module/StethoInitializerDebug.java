package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.StethoInitializer;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class StethoInitializerDebug implements StethoInitializer {

  @Override
  public void initialize(Context context) {
    Stetho.initialize(Stetho.newInitializerBuilder(context)
        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
        .build());
  }

  @Override
  public void addNetworkInterceptor(OkHttpClient.Builder clientBuilder) {
    clientBuilder.addNetworkInterceptor(new StethoInterceptor());
  }
}
