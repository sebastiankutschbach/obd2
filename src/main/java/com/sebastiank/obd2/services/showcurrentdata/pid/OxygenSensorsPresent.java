package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.services.responses.OxygenSensorPresence;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.utils.Unit;

public class OxygenSensorsPresent implements ISingleValuePid {

  private boolean twoBanks;

  public OxygenSensorsPresent(boolean twoBanks) {
    this.twoBanks = twoBanks;
  }

  @Override
  public int getPid() {
    return twoBanks ? 0x13 : 0x1D;
  }

  @Override
  public String getDescription() {
    return twoBanks ? "Oxygen sensors present (in 2 banks)" : "Oxygen sensors present (in 4 banks)";
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
  public OxygenSensorPresence[] getPhysicalValue(byte[] rawBytes) {
    OxygenSensorPresence[] presences;
    if (twoBanks) {
      presences = new OxygenSensorPresence[2];
      presences[0] =
          new OxygenSensorPresence(
              1,
              BitHelper.isBitSet(rawBytes[0], 0),
              BitHelper.isBitSet(rawBytes[0], 1),
              BitHelper.isBitSet(rawBytes[0], 2),
              BitHelper.isBitSet(rawBytes[0], 3));
      presences[1] =
          new OxygenSensorPresence(
              2,
              BitHelper.isBitSet(rawBytes[0], 4),
              BitHelper.isBitSet(rawBytes[0], 5),
              BitHelper.isBitSet(rawBytes[0], 6),
              BitHelper.isBitSet(rawBytes[0], 7));
    } else {
      presences = new OxygenSensorPresence[4];
      presences[0] =
          new OxygenSensorPresence(
              1,
              BitHelper.isBitSet(rawBytes[0], 0),
              BitHelper.isBitSet(rawBytes[0], 1),
              false,
              false);
      presences[1] =
          new OxygenSensorPresence(
              2,
              BitHelper.isBitSet(rawBytes[0], 2),
              BitHelper.isBitSet(rawBytes[0], 3),
              false,
              false);
      presences[2] =
          new OxygenSensorPresence(
              3,
              BitHelper.isBitSet(rawBytes[0], 4),
              BitHelper.isBitSet(rawBytes[0], 5),
              false,
              false);
      presences[3] =
          new OxygenSensorPresence(
              4,
              BitHelper.isBitSet(rawBytes[0], 6),
              BitHelper.isBitSet(rawBytes[0], 7),
              false,
              false);
    }
    return presences;
  }
}
