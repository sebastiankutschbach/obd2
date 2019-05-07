package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class IntakeAirTemperature implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0F;
  }

  @Override
  public String getDescription() {
    return "Intake air temperature";
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return -40.0;
  }

  @Override
  public double getMaxValue() {
    return 215.0;
  }

  @Override
  public Unit getUnit() {
    return Unit.DEGREE_CELSIUS;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (rawBytes[0] & 0xFF) - 40.0;
  }
}
