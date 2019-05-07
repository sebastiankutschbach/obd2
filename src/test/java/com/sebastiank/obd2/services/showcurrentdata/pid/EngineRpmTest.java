package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class EngineRpmTest {

  private EngineRpm sut = new EngineRpm();

  @Test
  public void getPid() {
    assertEquals(0x0C, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Engine RPM", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(2, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(0.0, sut.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(16383.75, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.REVOLUTIONS_PER_MINUTE, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(0.0, sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        800.0,
        sut.getPhysicalValue(new byte[] {(byte) 0x0C, (byte) 0x80}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(16383.75, sut.getPhysicalValue(new byte[] {(byte) 0xFF, (byte) 0xFF}), TestConstants.EPSILON);
  }

}