package com.bisca.stethodemo.data.sqlite.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bisca.stethodemo.data.model.Feed;
import com.bisca.stethodemo.data.sqlite.DatabaseHelper;
import com.bisca.stethodemo.data.sqlite.tables.FeedTable;

public class FeedDao {

  private final DatabaseHelper helper;

  public FeedDao(DatabaseHelper helper) {
    this.helper = helper;
  }

  public List<Feed> queryAll(boolean asc) {
    List<Feed> queryAll = new ArrayList<>();

    SQLiteDatabase db = helper.getReadableDatabase();

    String orderBy = asc ? "ASC" : "DESC";
    Cursor cursor = db.query(
        FeedTable.NAME,
        FeedTable.COLUMNS,
        null,
        null,
        null,
        null,
        FeedTable.Entry.TITLE + " " + orderBy
    );

    while (cursor.moveToNext()) {
      queryAll.add(parseEntry(cursor));
    }

    cursor.close();
    db.close();

    return queryAll;
  }

  private Feed parseEntry(Cursor cursor) {
    String id = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.ID));
    String title = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.TITLE));
    String url = cursor.getString(cursor.getColumnIndex(FeedTable.Entry.URL));

    return new Feed(id, title, url);
  }

  public void insertAll(List<Feed> response) {
    SQLiteDatabase db = helper.getWritableDatabase();
    db.beginTransaction();
    for (Feed feed : response) {
      ContentValues values = new ContentValues();
      values.put(FeedTable.Entry.ID, feed.getId());
      values.put(FeedTable.Entry.TITLE, feed.getTitle());
      values.put(FeedTable.Entry.URL, feed.getUrl());

      db.insert(FeedTable.NAME, null, values);
    }

    db.setTransactionSuccessful();
    db.endTransaction();
    db.close();
  }

  public void clear() {
    SQLiteDatabase db = helper.getWritableDatabase();
    db.delete(FeedTable.NAME, null, null);
    db.close();
  }
}
