package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class ObdStandardTest {

  private ObdStandard sut = new ObdStandard();

  @Test
  public void getPid() {
    assertEquals(0x1C, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("OBD standards this vehicle conforms to", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sut.getDataBytesReturned());
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
  public void getPhysicalValue() {
    assertEquals("OBD-II as defined by the CARB", sut.getPhysicalValue(new byte[] {(byte) 0x01}));
  }

  @Test
  public void getPhysicalValueInvalid() {
    assertNull(sut.getPhysicalValue(new byte[] {(byte) 0x00}));
  }

  @Test
  public void getPhysicalValueReserved() {
    assertEquals("Reserved", sut.getPhysicalValue(new byte[] {(byte) 0xF9}));
  }
}