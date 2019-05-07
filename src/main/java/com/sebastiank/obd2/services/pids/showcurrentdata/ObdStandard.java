package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.ObdStandardMapping;
import com.sebastiank.obd2.utils.Unit;

public class ObdStandard implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x1C;
  }

  @Override
  public String getDescription() {
    return "OBD standards this vehicle conforms to";
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return Double.NaN;
  }

  @Override
  public double getMaxValue() {
    return Double.NaN;
  }

  @Override
  public Unit getUnit() {
    return Unit.NO_UNIT;
  }

  @Override
  public String getPhysicalValue(byte[] rawBytes) {
    return ObdStandardMapping.MAPPING.get(rawBytes[0] & 0xFF);
  }
}
