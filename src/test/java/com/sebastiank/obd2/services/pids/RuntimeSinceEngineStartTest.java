package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.RuntimeSinceEngineStart;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class RuntimeSinceEngineStartTest {

  private RuntimeSinceEngineStart sut = new RuntimeSinceEngineStart();

  @Test
  public void getPid() {
    assertEquals(0x1F, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Run time since engine start", sut.getDescription());
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
    assertEquals(65535.0, sut.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.SECONDS, sut.getUnit());
  }

  @Test
  public void getPhysicalValueLowerLimit() {
    assertEquals(0.0, sut.getPhysicalValue(new byte[] {(byte) 0x00, (byte) 0x00}), TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValue() {
    assertEquals(
        63874.0,
        sut.getPhysicalValue(new byte[] {(byte) 0xF9, (byte) 0x82}),
        TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValueUpperLimit() {
    assertEquals(65535.0, sut.getPhysicalValue(new byte[] {(byte) 0xFF, (byte) 0xFF}), TestConstants.EPSILON);
  }

}