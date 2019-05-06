package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class EngineCoolantTemperatureTest {

  private EngineCoolantTemperature sut = new EngineCoolantTemperature();

  @Test
  public void getPid() {
    assertEquals(0x05, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Engine coolant temperature", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(-40.0, sut.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(215.0, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.DEGREE_CELSIUS, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(-40.0, sut.getPhysicalValue(new byte[] {(byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        160.0,
        sut.getPhysicalValue(new byte[] {(byte) 0xC8}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(215.0, sut.getPhysicalValue(new byte[] {(byte) 0xFF}), TestConstants.EPSILON);
  }

}