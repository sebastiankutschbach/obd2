package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.OxygenSensorsPresent;
import com.sebastiank.obd2.services.responses.OxygenSensorPresence;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class OxygenSensorsPresentTest {

  private OxygenSensorsPresent sutTwoBanks = new OxygenSensorsPresent(true);
  private OxygenSensorsPresent sutFourBanks = new OxygenSensorsPresent(false);

  @Test
  public void getPid() {

    assertEquals(0x13, sutTwoBanks.getPid());
    assertEquals(0x1D, sutFourBanks.getPid());
  }

  @Test
  public void getDescription() {

    assertEquals("Oxygen sensors present (in 2 banks)", sutTwoBanks.getDescription());
    assertEquals("Oxygen sensors present (in 4 banks)", sutFourBanks.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(1, sutTwoBanks.getDataBytesReturned());
  }

  @Test
  public void getMinValue() {
    assertEquals(Double.NaN, sutTwoBanks.getMinValue(), TestConstants.EPSILON);
  }

  @Test
  public void getMaxValue() {
    assertEquals(Double.NaN, sutTwoBanks.getMaxValue(), TestConstants.EPSILON);
  }

  @Test
  public void getUnit() {
    assertEquals(Unit.NO_UNIT, sutTwoBanks.getUnit());
  }

  @Test
  public void getPhysicalValueTestLength() {
    OxygenSensorPresence[] presences = sutTwoBanks.getPhysicalValue(new byte[] {(byte) 0x00});
    assertEquals(2, presences.length);

    presences = sutFourBanks.getPhysicalValue(new byte[] {(byte) 0x00});
    assertEquals(4, presences.length);
  }

  @Test
  public void getPhysicalValueTwoBanks() {
    OxygenSensorPresence[] presences = sutTwoBanks.getPhysicalValue(new byte[] {(byte) 0x55});
    assertTrue(presences[0].isSensor1Present());
    assertFalse(presences[0].isSensor2Present());
    assertTrue(presences[0].isSensor3Present());
    assertFalse(presences[0].isSensor4Present());

    assertTrue(presences[1].isSensor1Present());
    assertFalse(presences[1].isSensor2Present());
    assertTrue(presences[1].isSensor3Present());
    assertFalse(presences[1].isSensor4Present());
  }

  @Test
  public void getPhysicalValueFourBanks() {
    OxygenSensorPresence[] presences = sutFourBanks.getPhysicalValue(new byte[] {(byte) 0x55});
    assertTrue(presences[0].isSensor1Present());
    assertFalse(presences[0].isSensor2Present());
    assertFalse(presences[0].isSensor3Present());
    assertFalse(presences[0].isSensor4Present());

    assertTrue(presences[1].isSensor1Present());
    assertFalse(presences[1].isSensor2Present());
    assertFalse(presences[1].isSensor3Present());
    assertFalse(presences[1].isSensor4Present());

    assertTrue(presences[2].isSensor1Present());
    assertFalse(presences[2].isSensor2Present());
    assertFalse(presences[2].isSensor3Present());
    assertFalse(presences[2].isSensor4Present());

    assertTrue(presences[3].isSensor1Present());
    assertFalse(presences[3].isSensor2Present());
    assertFalse(presences[3].isSensor3Present());
    assertFalse(presences[3].isSensor4Present());
  }
}
