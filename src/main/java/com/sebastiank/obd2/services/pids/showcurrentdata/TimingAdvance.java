package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class TimingAdvance implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0E;
  }

  @Override
  public String getDescription() {
    return "Timing advance";
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return -64.0;
  }

  @Override
  public double getMaxValue() {
    return 63.5;
  }

  @Override
  public Unit getUnit() {
    return Unit.DEGREE_BEFORE_TDC;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    double rawValue = rawBytes[0] & 0xFF;
    return (rawValue / 2.0) - 64.0;
  }
}
