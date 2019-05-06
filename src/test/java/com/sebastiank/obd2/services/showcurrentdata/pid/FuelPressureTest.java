package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class FuelPressureTest {


  private FuelPressure sut = new FuelPressure();

  @Test
  public void getPid() {
    assertEquals(0x0A, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Fuel pressure (gauge pressure)", sut.getDescription());
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
    assertEquals(765.0, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.KILO_PASCAL, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(0.0, sut.getPhysicalValue(new byte[] {(byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        600.0,
        sut.getPhysicalValue(new byte[] {(byte) 0xC8}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(765.0, sut.getPhysicalValue(new byte[] {(byte) 0xFF}), TestConstants.EPSILON);
  }


}