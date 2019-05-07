package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.ThrottlePosition;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class ThrottlePositionTest {
  private ThrottlePosition sut = new ThrottlePosition();

  @Test
  public void getPid() {
    assertEquals(0x11, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Throttle position", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(0.0, sut.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(100.0, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.PERCENT, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(0.0, sut.getPhysicalValue(new byte[] {(byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        33.3333333333333333,
        sut.getPhysicalValue(new byte[] {(byte) 0x55}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(100.0, sut.getPhysicalValue(new byte[] {(byte) 0xFF}), TestConstants.EPSILON);
  }
}