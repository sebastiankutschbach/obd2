package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class EngineRpm implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0C;
  }

  @Override
  public String getDescription() {
    return "Engine RPM";
  }

  @Override
  public int getDataBytesReturned() {
    return 2;
  }

  @Override
  public double getMinValue() {
    return 0.0;
  }

  @Override
  public double getMaxValue() {
    return 16383.75;
  }

  @Override
  public Unit getUnit() {
    return Unit.REVOLUTIONS_PER_MINUTE;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    int rawValue = ((rawBytes[0] & 0xFF) << 8) + (rawBytes[1] & 0xFF);
    return rawValue / 4.0;
  }
}
