package com.sebastiank.obd2.services.pids;

public interface IPid {
  int getPid();

  String getDescription();

  int getDataBytesReturned();
}
