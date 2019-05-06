package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class EngineCoolantTemperature implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x05;
  }

  @Override
  public String getDescription() {
    return "Engine coolant temperature";
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
    double rawTemperatureValue = rawBytes[0] & 0xFF;
    return rawTemperatureValue - 40.0;
  }
}
