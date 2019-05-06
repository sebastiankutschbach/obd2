package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;

public class PidsSupportedTest {

  private PidsSupported sutLow = new PidsSupported(true);
  private PidsSupported sutHigh = new PidsSupported(false);

  @Test
  public void getPidLow() {
    assertEquals(0x00, sutLow.getPid());
  }

  @Test
  public void getPidHigh() {
    assertEquals(0x20, sutHigh.getPid());
  }

  @Test
  public void getDescriptionLow() {
    assertEquals("PIDs supported [01 - 20]", sutLow.getDescription());
  }

  @Test
  public void getDescriptionHigh() {
    assertEquals("PIDs supported [21 - 40]", sutHigh.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(4, sutLow.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(Double.NaN, sutLow.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(Double.NaN, sutLow.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.NO_UNIT, sutLow.getUnit());
  }

  @Test
  public void getPhysicalValueLow() {
    final Map<Integer, String> supportedPids =
        sutLow.getPhysicalValue(new byte[] {(byte) 0xBE, (byte) 0x1F, (byte) 0xA8, (byte) 0x13});

    assertEquals(17, supportedPids.size());

    assertTrue(supportedPids.keySet().contains(0x01));
    assertFalse(supportedPids.keySet().contains(0x02));
    assertTrue(supportedPids.keySet().contains(0x03));
    assertTrue(supportedPids.keySet().contains(0x04));
    assertTrue(supportedPids.keySet().contains(0x05));
    assertTrue(supportedPids.keySet().contains(0x06));
    assertTrue(supportedPids.keySet().contains(0x07));
    assertFalse(supportedPids.keySet().contains(0x08));
    assertFalse(supportedPids.keySet().contains(0x09));
    assertFalse(supportedPids.keySet().contains(0x0A));
    assertFalse(supportedPids.keySet().contains(0x0B));
    assertTrue(supportedPids.keySet().contains(0x0C));
    assertTrue(supportedPids.keySet().contains(0x0D));
    assertTrue(supportedPids.keySet().contains(0x0E));
    assertTrue(supportedPids.keySet().contains(0x0F));
    assertTrue(supportedPids.keySet().contains(0x10));
    assertTrue(supportedPids.keySet().contains(0x11));
    assertFalse(supportedPids.keySet().contains(0x12));
    assertTrue(supportedPids.keySet().contains(0x13));
    assertFalse(supportedPids.keySet().contains(0x14));
    assertTrue(supportedPids.keySet().contains(0x15));
    assertFalse(supportedPids.keySet().contains(0x16));
    assertFalse(supportedPids.keySet().contains(0x17));
    assertFalse(supportedPids.keySet().contains(0x18));
    assertFalse(supportedPids.keySet().contains(0x19));
    assertFalse(supportedPids.keySet().contains(0x1A));
    assertFalse(supportedPids.keySet().contains(0x1B));
    assertTrue(supportedPids.keySet().contains(0x1C));
    assertTrue(supportedPids.keySet().contains(0x1F));
    assertTrue(supportedPids.keySet().contains(0x20));
  }

  @Test
  @Ignore
  public void getPhysicalValueHigh() {
    final Map<Integer, String> supportedPids =
        sutHigh.getPhysicalValue(new byte[] {(byte) 0xBE, (byte) 0x1F, (byte) 0xA8, (byte) 0x13});

    assertEquals(17, supportedPids.size());

    assertTrue(supportedPids.keySet().contains(0x21));
    assertFalse(supportedPids.keySet().contains(0x22));
    assertTrue(supportedPids.keySet().contains(0x23));
    assertTrue(supportedPids.keySet().contains(0x24));
    assertTrue(supportedPids.keySet().contains(0x25));
    assertTrue(supportedPids.keySet().contains(0x26));
    assertTrue(supportedPids.keySet().contains(0x27));
    assertFalse(supportedPids.keySet().contains(0x28));
    assertFalse(supportedPids.keySet().contains(0x29));
    assertFalse(supportedPids.keySet().contains(0x2A));
    assertFalse(supportedPids.keySet().contains(0x2B));
    assertTrue(supportedPids.keySet().contains(0x2C));
    assertTrue(supportedPids.keySet().contains(0x2D));
    assertTrue(supportedPids.keySet().contains(0x2E));
    assertTrue(supportedPids.keySet().contains(0x2F));
    assertTrue(supportedPids.keySet().contains(0x30));
    assertTrue(supportedPids.keySet().contains(0x31));
    assertFalse(supportedPids.keySet().contains(0x32));
    assertTrue(supportedPids.keySet().contains(0x33));
    assertFalse(supportedPids.keySet().contains(0x34));
    assertTrue(supportedPids.keySet().contains(0x35));
    assertFalse(supportedPids.keySet().contains(0x36));
    assertFalse(supportedPids.keySet().contains(0x37));
    assertFalse(supportedPids.keySet().contains(0x38));
    assertFalse(supportedPids.keySet().contains(0x39));
    assertFalse(supportedPids.keySet().contains(0x3A));
    assertFalse(supportedPids.keySet().contains(0x3B));
    assertTrue(supportedPids.keySet().contains(0x3C));
    assertTrue(supportedPids.keySet().contains(0x3F));
    assertTrue(supportedPids.keySet().contains(0x40));
  }
}
