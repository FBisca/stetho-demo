package com.bisca.stethodemo.data.sqlite.tables;

public class FeedTable implements Table {

  public static final String NAME = "feed";
  public static final String[] COLUMNS = {Entry.ID, Entry.TITLE, Entry.URL};

  public static class Entry {
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String URL = "url";
  }

  @Override
  public String createStatement(int version) {
    return "create table if not exists " + NAME + " ( " +
        Entry.ID + " TEXT PRIMARY KEY, " +
        Entry.TITLE + " TEXT, " +
        Entry.URL + " TEXT " +
        ")";
  }

  @Override
  public boolean requiresUpdate(int version) {
    return false;
  }

  @Override
  public String updateStatement(int version) {
    return null;
  }
}
