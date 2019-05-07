package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class MafAirFlowRateTest {
  private MafAirFlowRate sut = new MafAirFlowRate();

  @Test
  public void getPid() {
    assertEquals(0x10, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("MAF air flow rate", sut.getDescription());
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
    assertEquals(655.35, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.GRAMS_PER_SECOND, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(0.0, sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        218.45,
        sut.getPhysicalValue(new byte[] {(byte) 0x55,(byte) 0x55}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(655.35, sut.getPhysicalValue(new byte[] {(byte) 0xFF, (byte) 0xFF}), TestConstants.EPSILON);
  }
}