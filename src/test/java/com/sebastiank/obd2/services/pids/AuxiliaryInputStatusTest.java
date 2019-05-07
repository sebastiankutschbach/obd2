package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.AuxiliaryInputStatus;
import com.sebastiank.obd2.services.responses.EAuxiliaryInputStatus;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class AuxiliaryInputStatusTest {
  private AuxiliaryInputStatus sut = new AuxiliaryInputStatus();

  @Test
  public void getPid() {
    assertEquals(0x1E, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Auxiliary input status", sut.getDescription());
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
  public void getPhysicalValueInactive() {
    assertEquals(EAuxiliaryInputStatus.POWER_TAKE_OFF_INACTIVE, sut.getPhysicalValue(new byte[] {(byte) 0x00}));
  }

  @Test
  public void getPhysicalValueActive() {
    assertEquals(EAuxiliaryInputStatus.POWER_TAKE_OFF_ACTIVE, sut.getPhysicalValue(new byte[] {(byte) 0x01}));
  }
}