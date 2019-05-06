package com.sebastiank.obd2.services;

public class ShowFreezeFrameDataService implements  IObd2Service {

  @Override
  public int getServiceId() {
    return 2;
  }

  @Override
  public String getServiceDescription() {
    return "Show freeze frame data";
  }
}
