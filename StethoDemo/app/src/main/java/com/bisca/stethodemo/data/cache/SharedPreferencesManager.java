package com.bisca.stethodemo.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {

  private static final String SHARED_PREFERENCES_FILE = "feed_preferences";
  private final Context context;

  public SharedPreferencesManager(Context context) {
    this.context = context;
  }

  private SharedPreferences getPreferences() {
    return context.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE);
  }

  public void putValue(String name, String value) {
    getPreferences().edit().putString(name, value).apply();
  }

  public String getValue(String name, String defaultValue) {
    return getPreferences().getString(name, defaultValue);
  }
}
