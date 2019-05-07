package com.sebastiank.obd2.services.responses;

import com.sebastiank.obd2.services.responses.AbstractMonitorStatus;
import com.sebastiank.obd2.utils.IgnitionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompressionEngineMonitorStatus extends AbstractMonitorStatus {

  private boolean egrVvtTestAvailable;
  private boolean egrVvtTestIncomplete;

  private boolean pmFilterTestAvailable;
  private boolean pmFilterTestIncomplete;

  private boolean exhaustGasSensorTestAvailable;
  private boolean exhaustGasSensorTestIncomplete;

  private boolean boostPressureTestAvailable;
  private boolean boostPressureTestIncomplete;

  private boolean noxScrTestAvailable;
  private boolean noxScrTestIncomplete;

  private boolean nmhcCatalystTestAvailable;
  private boolean nmhcCatalystTestIncomplete;

  @Override
  public IgnitionType getIgnitionType() {
    return IgnitionType.COMPRESSION;
  }
}
