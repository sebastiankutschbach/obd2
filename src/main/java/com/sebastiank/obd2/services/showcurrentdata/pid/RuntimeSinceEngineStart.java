package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class RuntimeSinceEngineStart implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x1F;
  }

  @Override
  public String getDescription() {
    return "Run time since engine start";
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
    return 65535.0;
  }

  @Override
  public Unit getUnit() {
    return Unit.SECONDS;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (double)(((rawBytes[0] & 0xFF) << 8) + (rawBytes[1] & 0xFF));
  }
}
