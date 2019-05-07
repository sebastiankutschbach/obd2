package com.sebastiank.obd2.services;

public class ShowFreezeFrameData extends ShowCurrentData {

  @Override
  public int getServiceId() {
    return 0x02;
  }

  @Override
  public String getServiceDescription() {
    return "Show freeze frame data";
  }
}
