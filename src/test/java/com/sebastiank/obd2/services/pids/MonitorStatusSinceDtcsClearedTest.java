package com.sebastiank.obd2.services.pids;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.MonitorStatusSinceDtcsCleared;
import com.sebastiank.obd2.services.responses.AbstractMonitorStatus;
import com.sebastiank.obd2.services.responses.CompressionEngineMonitorStatus;
import com.sebastiank.obd2.utils.IgnitionType;
import com.sebastiank.obd2.services.responses.SparkEngineMonitorStatus;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class MonitorStatusSinceDtcsClearedTest {

  private MonitorStatusSinceDtcsCleared sut = new MonitorStatusSinceDtcsCleared();

  @Test
  public void getPid() {
    assertEquals(0x01, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals(
        "Monitor status since DTCs cleared. (Includes malfunction indicator lamp (MIL) status and number of DTCs.)",
        sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(4, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(Double.NaN, sut.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(Double.NaN, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.NO_UNIT, sut.getUnit());
  }

  @Test
  public void getPhysicalValueCompression() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});

    assertEquals(IgnitionType.SPARK, monitorStatus.getIgnitionType());
  }

  @Test
  public void getPhysicalValueSpark() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x08, (byte) 0x00, (byte) 0x00});

    assertEquals(IgnitionType.COMPRESSION, monitorStatus.getIgnitionType());
  }

  @Test
  public void getPhysicalValueMilOff() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});

    assertFalse(monitorStatus.isMilOn());
  }

  @Test
  public void getPhysicalValueMilOn() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00});

    assertTrue(monitorStatus.isMilOn());
  }

  @Test
  public void getPhysicalValueDtcCount() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x7F, (byte) 0x00, (byte) 0x00, (byte) 0x00});

    assertEquals(127, monitorStatus.getDtcCount());
  }

  @Test
  public void getPhysicalValueCommonTest() {
    final AbstractMonitorStatus monitorStatus =
        sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x77, (byte) 0x00, (byte) 0x00});

    assertTrue(monitorStatus.isComponentsTestAvailable());
    assertTrue(monitorStatus.isComponentsTestIncomplete());

    assertTrue(monitorStatus.isFuelSystemTestAvailable());
    assertTrue(monitorStatus.isFuelSystemTestIncomplete());

    assertTrue(monitorStatus.isMisfireTestAvailable());
    assertTrue(monitorStatus.isMisfireTestIncomplete());
  }

  @Test
  public void getPhysicalValueCommonTestCompression() {
    final CompressionEngineMonitorStatus monitorStatus =
        (CompressionEngineMonitorStatus)
            sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x08, (byte) 0xFF, (byte) 0xFF});

    assertTrue(monitorStatus.isEgrVvtTestAvailable());
    assertTrue(monitorStatus.isEgrVvtTestIncomplete());

    assertTrue(monitorStatus.isPmFilterTestAvailable());
    assertTrue(monitorStatus.isPmFilterTestIncomplete());

    assertTrue(monitorStatus.isExhaustGasSensorTestAvailable());
    assertTrue(monitorStatus.isExhaustGasSensorTestIncomplete());

    assertTrue(monitorStatus.isBoostPressureTestAvailable());
    assertTrue(monitorStatus.isBoostPressureTestIncomplete());

    assertTrue(monitorStatus.isNoxScrTestAvailable());
    assertTrue(monitorStatus.isNoxScrTestIncomplete());

    assertTrue(monitorStatus.isNmhcCatalystTestAvailable());
    assertTrue(monitorStatus.isNmhcCatalystTestIncomplete());
  }

  @Test
  public void getPhysicalValueCommonTestSpark() {
    final SparkEngineMonitorStatus monitorStatus =
        (SparkEngineMonitorStatus)
            sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00, (byte) 0xFF, (byte) 0xFF});

    assertTrue(monitorStatus.isEgrTestAvailable());
    assertTrue(monitorStatus.isEgrTestIncomplete());

    assertTrue(monitorStatus.isOxygenSensorHeaterTestAvailable());
    assertTrue(monitorStatus.isOxygenSensorHeaterTestIncomplete());

    assertTrue(monitorStatus.isOxygenSensorTestAvailable());
    assertTrue(monitorStatus.isOxygenSensorTestIncomplete());

    assertTrue(monitorStatus.isAcRefrigerantTestAvailable());
    assertTrue(monitorStatus.isAcRefrigerantTestIncomplete());

    assertTrue(monitorStatus.isSecondaryAirSystemTestAvailable());
    assertTrue(monitorStatus.isSecondaryAirSystemTestIncomplete());

    assertTrue(monitorStatus.isEvaporativeSystemTestAvailable());
    assertTrue(monitorStatus.isEvaporativeSystemTestIncomplete());

    assertTrue(monitorStatus.isHeatedCatalystTestAvailable());
    assertTrue(monitorStatus.isHeatedCatalystTestIncomplete());

    assertTrue(monitorStatus.isCatalystTestAvailable());
    assertTrue(monitorStatus.isCatalystTestIncomplete());
  }
}
