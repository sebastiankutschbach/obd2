package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class IntakeManifoldAbsolutePressure implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x0B;
  }

  @Override
  public String getDescription() {
    return "Intake manifold absolute pressure";
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
    return Unit.KILO_PASCAL;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (double)(rawBytes[0] & 0xFF);
  }
}
