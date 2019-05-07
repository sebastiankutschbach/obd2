package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class TimingAdvanceTest {

  private TimingAdvance sut = new TimingAdvance();

  @Test
  public void getPid() {
    assertEquals(0x0E, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Timing advance", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(-64.0, sut.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(63.5, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.DEGREE_BEFORE_TDC, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(-64.0, sut.getPhysicalValue(new byte[] {(byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        36.0,
        sut.getPhysicalValue(new byte[] {(byte) 0xC8}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(63.5, sut.getPhysicalValue(new byte[] {(byte) 0xFF}), TestConstants.EPSILON);
  }


}