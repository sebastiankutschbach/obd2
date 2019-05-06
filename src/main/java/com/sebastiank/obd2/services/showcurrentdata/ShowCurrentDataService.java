package com.sebastiank.obd2.services.showcurrentdata;

import com.sebastiank.obd2.services.IObd2Service;

public class ShowCurrentDataService implements IObd2Service {

  @Override
  public int getServiceId() {
    return 1;
  }

  @Override
  public String getServiceDescription() {
    return "Show current data";
  }
}
