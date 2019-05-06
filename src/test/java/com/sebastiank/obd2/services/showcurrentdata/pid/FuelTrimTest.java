package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class FuelTrimTest {


  private FuelTrim sut1Short = new FuelTrim(1, true);
  private FuelTrim sut1Long = new FuelTrim(1, false);
  private FuelTrim sut2Short = new FuelTrim(2, true);
  private FuelTrim sut2Long = new FuelTrim(2, false);

  @Test
  public void getPid() {

    assertEquals(0x06, sut1Short.getPid());
    assertEquals(0x07, sut1Long.getPid());
    assertEquals(0x08, sut2Short.getPid());
    assertEquals(0x09, sut2Long.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Short term fuel trim—Bank 1", sut1Short.getDescription());
    assertEquals("Long term fuel trim—Bank 1", sut1Long.getDescription());
    assertEquals("Short term fuel trim—Bank 2", sut2Short.getDescription());
    assertEquals("Long term fuel trim—Bank 2", sut2Long.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sut1Short.getDataBytesReturned());
    assertEquals(1, sut1Long.getDataBytesReturned());
    assertEquals(1, sut2Short.getDataBytesReturned());
    assertEquals(1, sut2Long.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(-100.0, sut1Short.getMinValue(), TestConstants.EPSILON);
    assertEquals(-100.0, sut1Long.getMinValue(), TestConstants.EPSILON);
    assertEquals(-100.0, sut2Short.getMinValue(), TestConstants.EPSILON);
    assertEquals(-100.0, sut2Long.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(99.2, sut1Short.getMaxValue(), TestConstants.EPSILON);
    assertEquals(99.2, sut1Long.getMaxValue(), TestConstants.EPSILON);
    assertEquals(99.2, sut2Short.getMaxValue(), TestConstants.EPSILON);
    assertEquals(99.2, sut2Long.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.PERCENT, sut1Short.getUnit());
    assertEquals(Unit.PERCENT, sut1Long.getUnit());
    assertEquals(Unit.PERCENT, sut2Short.getUnit());
    assertEquals(Unit.PERCENT, sut2Long.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(-100.0, sut1Short.getPhysicalValue(new byte[] {(byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        56.25,
        sut1Short.getPhysicalValue(new byte[] {(byte) 0xC8}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(99.21875, sut1Short.getPhysicalValue(new byte[] {(byte) 0xFF}), TestConstants.EPSILON);
  }


}