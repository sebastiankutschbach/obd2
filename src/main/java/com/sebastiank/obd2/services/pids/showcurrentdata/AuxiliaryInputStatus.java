package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.services.responses.EAuxiliaryInputStatus;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.utils.Unit;

public class AuxiliaryInputStatus implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x1E;
  }

  @Override
  public String getDescription() {
    return "Auxiliary input status";
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
  public Object getPhysicalValue(byte[] rawBytes) {
    return BitHelper.isBitSet(rawBytes[0], 0)
        ? EAuxiliaryInputStatus.POWER_TAKE_OFF_ACTIVE
        : EAuxiliaryInputStatus.POWER_TAKE_OFF_INACTIVE;
  }
}
