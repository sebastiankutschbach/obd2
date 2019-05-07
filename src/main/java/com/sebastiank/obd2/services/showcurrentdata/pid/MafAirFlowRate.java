package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class MafAirFlowRate implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x10;
  }

  @Override
  public String getDescription() {
    return "MAF air flow rate";
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
    return 655.35;
  }

  @Override
  public Unit getUnit() {
    return Unit.GRAMS_PER_SECOND;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (((rawBytes[0] & 0xFF) << 8) +(rawBytes[1] & 0xFF)) / 100.0;
  }
}
