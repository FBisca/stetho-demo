package com.bisca.stethodemo.data.sqlite.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.sqlite.DatabaseHelper;
import com.bisca.stethodemo.data.sqlite.tables.FeedTable;

import java.util.ArrayList;
import java.util.List;

public class FeedDao {

  private final DatabaseHelper helper;

  public FeedDao(DatabaseHelper helper) {
    this.helper = helper;
  }

  public List<Feed> queryAll() {
    List<Feed> queryAll = new ArrayList<>();

    SQLiteDatabase db = helper.getReadableDatabase();
    Cursor cursor = db.query(FeedTable.NAME, FeedTable.COLUMNS, null, null, null, null, null);

    while (cursor.moveToNext()) {
      queryAll.add(parseEntry(cursor));
    }

    cursor.close();
    db.close();

    return queryAll;
  }

  public int count() {
    int count = 0;
    SQLiteDatabase db = helper.getReadableDatabase();
    Cursor cursor = db.query(FeedTable.NAME, new String[]{"count(0)"}, null, null, null, null, null);

    while (cursor.moveToNext()) {
      count = cursor.getInt(0);
    }

    cursor.close();
    db.close();

    return count;
  }

  private Feed parseEntry(Cursor cursor) {
    String id = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.ID));
    String title = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.TITLE));
    String url = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.URL));

    return new Feed(id, title, url);
  }

}
