package com.bisca.stethodemo.di.module;

import android.content.Context;

import com.bisca.stethodemo.StethoInitializer;
import com.bisca.stethodemo.data.sqlite.dao.FeedDao;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class StethoInitializerDebug implements StethoInitializer {

  public final FeedDao feedDao;

  public StethoInitializerDebug(FeedDao feedDao) {this.feedDao = feedDao;}

  @Override
  public void initialize(Context context) {
    Stetho.initialize(Stetho.newInitializerBuilder(context)
        .enableDumpapp(() -> new Stetho.DefaultDumperPluginsBuilder(context)
            .provide(new MyDumperPlugin())
            .finish())
        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(context))
        .build());
  }

  @Override
  public void addNetworkInterceptor(OkHttpClient.Builder clientBuilder) {
    clientBuilder.addNetworkInterceptor(new StethoInterceptor());
  }

  public class MyDumperPlugin implements DumperPlugin {

    @Override
    public String getName() {
      return "clear-stetho";
    }

    @Override
    public void dump(DumperContext dumpContext) throws DumpException {
      feedDao.clear();
    }
  }
}
