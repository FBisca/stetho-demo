package com.bisca.stethodemo.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bisca.stethodemo.data.sqlite.tables.FeedTable;
import com.bisca.stethodemo.data.sqlite.tables.Table;

public class DatabaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "stetho-demo";
  private static final int DATABASE_VERSION = 1;

  private static final Table[] TABLES = {
      new FeedTable()
  };

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    for (Table table: TABLES) {
      db.execSQL(table.createStatement(DATABASE_VERSION));
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    for (Table table: TABLES) {
      if (table.requiresUpdate(newVersion)) {
        db.execSQL(table.updateStatement(DATABASE_VERSION));
      }
    }
  }
}
