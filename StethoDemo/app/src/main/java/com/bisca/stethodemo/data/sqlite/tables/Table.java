package com.bisca.stethodemo.data.sqlite.tables;

public interface Table {
  String createStatement(int version);
  boolean requiresUpdate(int version);
  String updateStatement(int version);
}
