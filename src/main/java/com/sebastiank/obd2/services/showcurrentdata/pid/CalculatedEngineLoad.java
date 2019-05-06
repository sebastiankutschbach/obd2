package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class CalculatedEngineLoad implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x04;
  }

  @Override
  public String getDescription() {
    return "Calculated engine load";
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return 0;
  }

  @Override
  public double getMaxValue() {
    return 100;
  }

  @Override
  public Unit getUnit() {
    return Unit.PERCENT;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    double loadRawValue = rawBytes[0] & 0xFF;
    return loadRawValue/2.55;
  }
}
