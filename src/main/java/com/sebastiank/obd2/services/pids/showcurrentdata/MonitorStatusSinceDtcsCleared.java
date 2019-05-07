package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.ISingleValuePid;
import com.sebastiank.obd2.services.responses.AbstractMonitorStatus;
import com.sebastiank.obd2.utils.BitHelper;
import com.sebastiank.obd2.services.responses.CompressionEngineMonitorStatus;
import com.sebastiank.obd2.utils.IgnitionType;
import com.sebastiank.obd2.services.responses.SparkEngineMonitorStatus;
import com.sebastiank.obd2.utils.Unit;

public class MonitorStatusSinceDtcsCleared implements ISingleValuePid {

  @Override
  public int getPid() {
    return 0x01;
  }

  @Override
  public String getDescription() {
    return "Monitor status since DTCs cleared. "
        + "(Includes malfunction indicator lamp (MIL) status and number of DTCs.)";
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
  public AbstractMonitorStatus getPhysicalValue(byte[] rawBytes) {
    IgnitionType ignitionType =
        BitHelper.isBitSet(rawBytes[1], 3) ? IgnitionType.COMPRESSION : IgnitionType.SPARK;

    AbstractMonitorStatus monitorStatus;

    if (ignitionType == IgnitionType.SPARK) {
      monitorStatus = new SparkEngineMonitorStatus();

      ((SparkEngineMonitorStatus) monitorStatus).setEgrTestAvailable(BitHelper.isBitSet(rawBytes[2], 7));
      ((SparkEngineMonitorStatus) monitorStatus).setEgrTestIncomplete(BitHelper.isBitSet(rawBytes[3], 7));

      ((SparkEngineMonitorStatus) monitorStatus).setOxygenSensorHeaterTestAvailable(BitHelper.isBitSet(rawBytes[2], 6));
      ((SparkEngineMonitorStatus) monitorStatus).setOxygenSensorHeaterTestIncomplete(BitHelper.isBitSet(rawBytes[3], 6));

      ((SparkEngineMonitorStatus) monitorStatus).setOxygenSensorTestAvailable(BitHelper.isBitSet(rawBytes[2], 5));
      ((SparkEngineMonitorStatus) monitorStatus).setOxygenSensorTestIncomplete(BitHelper.isBitSet(rawBytes[3], 5));

      ((SparkEngineMonitorStatus) monitorStatus).setAcRefrigerantTestAvailable(BitHelper.isBitSet(rawBytes[2], 4));
      ((SparkEngineMonitorStatus) monitorStatus).setAcRefrigerantTestIncomplete(BitHelper.isBitSet(rawBytes[3], 4));

      ((SparkEngineMonitorStatus) monitorStatus).setSecondaryAirSystemTestAvailable(BitHelper.isBitSet(rawBytes[2], 3));
      ((SparkEngineMonitorStatus) monitorStatus).setSecondaryAirSystemTestIncomplete(BitHelper.isBitSet(rawBytes[3], 3));

      ((SparkEngineMonitorStatus) monitorStatus).setEvaporativeSystemTestAvailable(BitHelper.isBitSet(rawBytes[2], 2));
      ((SparkEngineMonitorStatus) monitorStatus).setEvaporativeSystemTestIncomplete(BitHelper.isBitSet(rawBytes[3], 2));

      ((SparkEngineMonitorStatus) monitorStatus).setHeatedCatalystTestAvailable(BitHelper.isBitSet(rawBytes[2], 1));
      ((SparkEngineMonitorStatus) monitorStatus).setHeatedCatalystTestIncomplete(BitHelper.isBitSet(rawBytes[3], 1));

      ((SparkEngineMonitorStatus) monitorStatus).setCatalystTestAvailable(BitHelper.isBitSet(rawBytes[2], 0));
      ((SparkEngineMonitorStatus) monitorStatus).setCatalystTestIncomplete(BitHelper.isBitSet(rawBytes[3], 0));

    } else {
      monitorStatus = new CompressionEngineMonitorStatus();
      
      ((CompressionEngineMonitorStatus) monitorStatus).setEgrVvtTestAvailable(BitHelper.isBitSet(rawBytes[2], 7));
      ((CompressionEngineMonitorStatus) monitorStatus).setEgrVvtTestIncomplete(BitHelper.isBitSet(rawBytes[3], 7));

      ((CompressionEngineMonitorStatus) monitorStatus).setPmFilterTestAvailable(BitHelper.isBitSet(rawBytes[2], 6));
      ((CompressionEngineMonitorStatus) monitorStatus).setPmFilterTestIncomplete(BitHelper.isBitSet(rawBytes[3], 6));

      ((CompressionEngineMonitorStatus) monitorStatus).setExhaustGasSensorTestAvailable(BitHelper.isBitSet(rawBytes[2], 5));
      ((CompressionEngineMonitorStatus) monitorStatus).setExhaustGasSensorTestIncomplete(BitHelper.isBitSet(rawBytes[3], 5));

      // bit 4 is reserved

      ((CompressionEngineMonitorStatus) monitorStatus).setBoostPressureTestAvailable(BitHelper.isBitSet(rawBytes[2], 3));
      ((CompressionEngineMonitorStatus) monitorStatus).setBoostPressureTestIncomplete(BitHelper.isBitSet(rawBytes[3], 3));

      // bit 2 is reserved

      ((CompressionEngineMonitorStatus) monitorStatus).setNoxScrTestAvailable(BitHelper.isBitSet(rawBytes[2], 1));
      ((CompressionEngineMonitorStatus) monitorStatus).setNoxScrTestIncomplete(BitHelper.isBitSet(rawBytes[3], 1));

      ((CompressionEngineMonitorStatus) monitorStatus).setNmhcCatalystTestAvailable(BitHelper.isBitSet(rawBytes[2], 0));
      ((CompressionEngineMonitorStatus) monitorStatus).setNmhcCatalystTestIncomplete(BitHelper.isBitSet(rawBytes[3], 0));
    }


    monitorStatus.setMisfireTestAvailable(BitHelper.isBitSet(rawBytes[1], 0));
    monitorStatus.setFuelSystemTestAvailable(BitHelper.isBitSet(rawBytes[1], 1));
    monitorStatus.setMisfireTestIncomplete(BitHelper.isBitSet(rawBytes[1], 4));
    monitorStatus.setComponentsTestAvailable(BitHelper.isBitSet(rawBytes[1], 2));
    monitorStatus.setFuelSystemTestIncomplete(BitHelper.isBitSet(rawBytes[1], 5));
    monitorStatus.setComponentsTestIncomplete(BitHelper.isBitSet(rawBytes[1], 6));

    monitorStatus.setMilOn(BitHelper.isBitSet(rawBytes[0], 7));
    monitorStatus.setDtcCount(rawBytes[0] & 0x7F);

    return monitorStatus;
  }
}
