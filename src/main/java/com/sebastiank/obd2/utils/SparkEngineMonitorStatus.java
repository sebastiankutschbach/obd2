package com.sebastiank.obd2.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SparkEngineMonitorStatus extends AbstractMonitorStatus{

  private boolean egrTestAvailable;
  private boolean egrTestIncomplete;

  private boolean oxygenSensorHeaterTestAvailable;
  private boolean oxygenSensorHeaterTestIncomplete;

  private boolean oxygenSensorTestAvailable;
  private boolean oxygenSensorTestIncomplete;

  private boolean acRefrigerantTestAvailable;
  private boolean acRefrigerantTestIncomplete;

  private boolean secondaryAirSystemTestAvailable;
  private boolean secondaryAirSystemTestIncomplete;

  private boolean evaporativeSystemTestAvailable;
  private boolean evaporativeSystemTestIncomplete;

  private boolean heatedCatalystTestAvailable;
  private boolean heatedCatalystTestIncomplete;

  private boolean catalystTestAvailable;
  private boolean catalystTestIncomplete;

  @Override
  public IgnitionType getIgnitionType() {
    return IgnitionType.SPARK;
  }

}
