package com.sebastiank.obd2.services;

import com.sebastiank.obd2.services.pids.IMultiValuePid;
import com.sebastiank.obd2.services.pids.IPid;
import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.services.pids.showcurrentdata.ShowCurrentDataPids;
import java.util.Arrays;

public class ShowCurrentData implements IObd2Service {

  @Override
  public int getServiceId() {
    return 0x01;
  }

  @Override
  public String getServiceDescription() {
    return "Show current data";
  }

  public byte[] createRequest(IPid pid) {
    return new byte[] {(byte) getServiceId(), (byte) pid.getPid()};
  }

  public Object interpretResponse(byte[] rawResponse) {
    final IPid pid = ShowCurrentDataPids.getDescriptionFor(rawResponse[1]);
    Object returnValue = null;
    if (pid instanceof ISingleValuePid) {
      returnValue = ((ISingleValuePid) pid)
          .getPhysicalValue(Arrays.copyOfRange(rawResponse, 2, rawResponse.length));
    } else if (pid instanceof IMultiValuePid) {
      returnValue  = ((IMultiValuePid) pid)
          .getPhysicalValues(Arrays.copyOfRange(rawResponse, 2, rawResponse.length));
    }

    return returnValue;
  }
}
