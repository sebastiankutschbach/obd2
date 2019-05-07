package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.IPid;
import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.services.pids.showcurrentdata.ShowCurrentDataPids;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.utils.Unit;
import java.util.HashMap;
import java.util.Map;

public class PidsSupported implements ISingleValuePid {

  private boolean lowPids;

  public PidsSupported(boolean lowPids) {
    this.lowPids = lowPids;
  }

  @Override
  public int getPid() {
    return lowPids ? 0x00 : 0x20;
  }

  @Override
  public String getDescription() {
    return lowPids ?
        "PIDs supported [01 - 20]" :
        "PIDs supported [21 - 40]";
  }

  @Override
  public int getDataBytesReturned() {
    return 4;
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
  public Map<Integer, String> getPhysicalValue(byte[] rawBytes) {
    final Map<Integer, String> supportedPids = new HashMap<>();
    // FIXME: check number of bytes passed in == getDataBytesReturned (in abstract class)

    int pidNumber = lowPids ? 0 : 0x20;
    for (int byteIndex = 0; byteIndex < 4; byteIndex++) {
      for (int bitIndex = 7; bitIndex >= 0; bitIndex--) {
        pidNumber++;
        if (BitHelper.isBitSet(rawBytes[byteIndex], bitIndex)) {
          final IPid pidDescription = ShowCurrentDataPids.getDescriptionFor(pidNumber);
            supportedPids.put(pidNumber, pidDescription.getDescription());
        }
      }
    }

    // FIXME: check min and max value before return (in abstract class) if applicable
    return supportedPids;
  }
}
