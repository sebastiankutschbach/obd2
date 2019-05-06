package com.sebastiank.obd2.services.showcurrentdata.pid;

import static org.junit.Assert.*;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.utils.Unit;
import org.junit.Test;

public class OxygenSensorTest {

  private OxygenSensor sut = new OxygenSensor(1);

  @Test
  public void getNumberOfValues() {
    assertEquals(2, sut.getNumberOfValues());
  }

  @Test
  public void getPid() {
    assertEquals(0x14, sut.getPid());
  }

  @Test
  public void getDescription() {
    assertEquals("Oxygen Sensor 1\n" + "A: Voltage\n" + "B: Short term fuel trim", sut.getDescription());
  }

  @Test
  public void getDataBytesReturned() {
    assertEquals(2, sut.getDataBytesReturned());
  }

  @Test
  public void getMinValues() {
    assertEquals(0.0, sut.getMinValues()[0], TestConstants.EPSILON);
    assertEquals(-100.0, sut.getMinValues()[1], TestConstants.EPSILON);
  }

  @Test
  public void getMaxValues() {
    assertEquals(1.275, sut.getMaxValues()[0], TestConstants.EPSILON);
    assertEquals(99.2, sut.getMaxValues()[1], TestConstants.EPSILON);
  }

  @Test
  public void getUnits() {
    assertEquals(Unit.VOLTS, sut.getUnits()[0]);
    assertEquals(Unit.PERCENT, sut.getUnits()[1]);
  }

  @Test
  public void getPhysicalValuesLowerLimit() {
    final Double[] physicalValues = sut.getPhysicalValues(new byte[]{(byte) 0x00, (byte) 0x00});
    assertEquals(0, physicalValues[0], TestConstants.EPSILON);
    assertEquals(-100, physicalValues[1], TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValues() {
    final Double[] physicalValues = sut.getPhysicalValues(new byte[]{(byte) 0xC8, (byte) 0xC8});
    assertEquals(1, physicalValues[0], TestConstants.EPSILON);
    assertEquals(56.25, physicalValues[1], TestConstants.EPSILON);
  }

  @Test
  public void getPhysicalValuesUpperLimit() {
    final Double[] physicalValues = sut.getPhysicalValues(new byte[]{(byte) 0xFF, (byte) 0xFF});
    assertEquals(1.275, physicalValues[0], TestConstants.EPSILON);
    assertEquals(99.21875, physicalValues[1], TestConstants.EPSILON);
  }
}