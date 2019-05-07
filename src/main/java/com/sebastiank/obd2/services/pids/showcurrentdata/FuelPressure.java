package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class FuelPressure implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0A;
  }

  @Override
  public String getDescription() {
    return "Fuel pressure (gauge pressure)";
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
    return 765.0;
  }

  @Override
  public Unit getUnit() {
    return Unit.KILO_PASCAL;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (rawBytes[0] & 0xFF) * 3.0;
  }
}
