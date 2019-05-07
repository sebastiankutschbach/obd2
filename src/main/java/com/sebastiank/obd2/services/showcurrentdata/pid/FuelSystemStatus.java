package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.utils.EFuelSystemStatus;
import com.sebastiank.obd2.utils.Unit;

public class FuelSystemStatus implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x03;
  }

  @Override
  public String getDescription() {
    return "Fuel system status";
  }

  @Override
  public int getDataBytesReturned() {
    return 2;
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
  public EFuelSystemStatus[] getPhysicalValue(byte[] rawBytes) {
    final EFuelSystemStatus[] systemStatuses = new EFuelSystemStatus[2];
    byte rawStatusFuelSystem1 = rawBytes[0];
    byte rawStatusFuelSystem2 = rawBytes[1];

    systemStatuses[0] = getSystemStatus(rawStatusFuelSystem1);
    systemStatuses[1] = getSystemStatus(rawStatusFuelSystem2);

    return systemStatuses;
  }

  private EFuelSystemStatus getSystemStatus(byte rawStatus) {
    EFuelSystemStatus systemStatus = EFuelSystemStatus.INVALID_RESPONSE;
    if (BitHelper.isBitSet(rawStatus, 0)) {
      systemStatus = EFuelSystemStatus.OPEN_LOOP_INSUFFICIENT_AIR_TEMP;
    } else if (BitHelper.isBitSet(rawStatus, 1)) {
      systemStatus = EFuelSystemStatus.CLOSED_LOOP_USING_OXYGEN_SENSOR_FEEDBACK;
    } else if (BitHelper.isBitSet(rawStatus, 2)) {
      systemStatus = EFuelSystemStatus.OPEN_LOOP_DUE_TO_ENGINE_LOAD_OR_FUEL_CUT_OFF;
    } else if (BitHelper.isBitSet(rawStatus, 3)) {
      systemStatus = EFuelSystemStatus.OPEN_LOOP_DUE_TP_SYSTEM_FAILURE;
    } else if (BitHelper.isBitSet(rawStatus, 4)) {
      systemStatus = EFuelSystemStatus.CLOSED_LOOP_ERROR_IN_FEEDBACK_SYSTEM;
    }

    if(BitHelper.countSetBits(rawStatus) != 1) {
      systemStatus = EFuelSystemStatus.INVALID_RESPONSE;
    }

    return systemStatus;
  }
}
