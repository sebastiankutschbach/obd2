package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class ThrottlePosition implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x11;
  }

  @Override
  public String getDescription() {
    return "Throttle position";
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return 0.0;
  }

  @Override
  public double getMaxValue() {
    return 100.0;
  }

  @Override
  public Unit getUnit() {
    return Unit.PERCENT;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return ((100.0/255.0) * (rawBytes[0] & 0xFF));
  }
}
