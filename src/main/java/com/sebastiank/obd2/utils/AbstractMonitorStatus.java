package com.sebastiank.obd2.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractMonitorStatus {

  private boolean milOn;

  private int dtcCount;

  private boolean componentsTestAvailable;
  private boolean componentsTestIncomplete;

  private boolean fuelSystemTestAvailable;
  private boolean fuelSystemTestIncomplete;

  private boolean misfireTestAvailable;
  private boolean misfireTestIncomplete;

  public abstract IgnitionType getIgnitionType();
}
