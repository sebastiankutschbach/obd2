package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class VehicleSpeed implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0D;
  }

  @Override
  public String getDescription() {
    return "Vehicle speed";
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
    return 255.0;
  }

  @Override
  public Unit getUnit() {
    return Unit.KILOMETERS_PER_HOUR;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (double) (rawBytes[0] & 0xFF);
  }
}
