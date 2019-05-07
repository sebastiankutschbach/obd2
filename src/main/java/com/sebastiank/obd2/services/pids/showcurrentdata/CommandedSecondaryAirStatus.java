package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.services.responses.ECommandedSecondaryAirStatus;
import com.sebastiank.obd2.utils.Unit;

public class CommandedSecondaryAirStatus implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x12;
  }

  @Override
  public String getDescription() {
    return "Commanded secondary air status";
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
  public ECommandedSecondaryAirStatus getPhysicalValue(byte[] rawBytes) {
    ECommandedSecondaryAirStatus commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.INVALID_RESPONSE;

    if(BitHelper.isBitSet(rawBytes[0], 0)) {
      commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.UPSTREAM;
    } else if(BitHelper.isBitSet(rawBytes[0], 1)) {
      commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.DOWNSTREAM;
    } else if(BitHelper.isBitSet(rawBytes[0], 2)) {
      commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.OUTSIDE_OR_OFF;
    } else if(BitHelper.isBitSet(rawBytes[0], 3)) {
      commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.PUMP_COMMANDED_ON_DIAGNOSTICS;
    }

    if(BitHelper.countSetBits(rawBytes[0]) != 1) {
      commandedSecondaryAirStatus = ECommandedSecondaryAirStatus.INVALID_RESPONSE;
    }

    return commandedSecondaryAirStatus;
  }
}
