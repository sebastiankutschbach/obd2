package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.FuelSystemStatus;
import com.sebastiank.obd2.services.responses.EFuelSystemStatus;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class FuelSystemStatusTest {

  private FuelSystemStatus sut = new FuelSystemStatus();

  @Test
  public void getPid() {
    assertEquals(0x03, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Fuel system status", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(2, sut.getDataBytesReturned());
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
  public void getPhysicalValueBit0Set() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x01, (byte) 0x00});
    assertEquals(EFuelSystemStatus.OPEN_LOOP_INSUFFICIENT_AIR_TEMP, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[1]);
  }

  @Test
  public void getPhysicalValueBit1Set() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x00, (byte) 0x02});
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.CLOSED_LOOP_USING_OXYGEN_SENSOR_FEEDBACK, systemStatuses[1]);
  }

  @Test
  public void getPhysicalValueBit2Set() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x04, (byte) 0x00});
    assertEquals(EFuelSystemStatus.OPEN_LOOP_DUE_TO_ENGINE_LOAD_OR_FUEL_CUT_OFF, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[1]);
  }

  @Test
  public void getPhysicalValueBit3Set() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x00, (byte) 0x08});
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.OPEN_LOOP_DUE_TP_SYSTEM_FAILURE, systemStatuses[1]);
  }

  @Test
  public void getPhysicalValueBit4Set() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x10, (byte) 0x00});
    assertEquals(EFuelSystemStatus.CLOSED_LOOP_ERROR_IN_FEEDBACK_SYSTEM, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[1]);
  }

  @Test
  public void getPhysicalValueBitMoreThanOneBit() {
    final EFuelSystemStatus[] systemStatuses = sut.getPhysicalValue(new byte[]{(byte) 0x11, (byte) 0x22});
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[0]);
    assertEquals(EFuelSystemStatus.INVALID_RESPONSE, systemStatuses[1]);
  }
}