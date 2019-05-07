package com.sebastiank.obd2.services.pids;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.pids.showcurrentdata.CommandedSecondaryAirStatus;
import com.sebastiank.obd2.services.responses.ECommandedSecondaryAirStatus;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class CommandedSecondaryAirStatusTest {


  private CommandedSecondaryAirStatus sut = new CommandedSecondaryAirStatus();

  @Test
  public void getPid() {
    assertEquals(0x12, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Commanded secondary air status", sut.getDescription());
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
  public void getPhysicalValueBit0Set() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x01});
    assertEquals(ECommandedSecondaryAirStatus.UPSTREAM, status);
  }

  @Test
  public void getPhysicalValueBit1Set() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x02});
    assertEquals(ECommandedSecondaryAirStatus.DOWNSTREAM, status);
  }

  @Test
  public void getPhysicalValueBit2Set() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x04});
    assertEquals(ECommandedSecondaryAirStatus.OUTSIDE_OR_OFF, status);
  }

  @Test
  public void getPhysicalValueBit3Set() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x08});
    assertEquals(ECommandedSecondaryAirStatus.PUMP_COMMANDED_ON_DIAGNOSTICS, status);
  }

  @Test
  public void getPhysicalValueNoBitSet() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x00});
    assertEquals(ECommandedSecondaryAirStatus.INVALID_RESPONSE, status);
  }

  @Test
  public void getPhysicalValueMultipleBitSet() {
    final ECommandedSecondaryAirStatus status = sut.getPhysicalValue(new byte[]{(byte) 0x55});
    assertEquals(ECommandedSecondaryAirStatus.INVALID_RESPONSE, status);
  }
}