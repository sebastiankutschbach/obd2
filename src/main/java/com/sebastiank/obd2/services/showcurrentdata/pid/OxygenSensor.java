package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.IMultiValuePid;
import com.sebastiank.obd2.utils.Unit;

public class OxygenSensor implements IMultiValuePid {

  private int nr;

  public OxygenSensor(int nr) {
    this.nr = nr;
  }

  @Override
  public int getNumberOfValues() {
    return 2;
  }

  @Override
  public int getPid() {
    return 0x13 + this.nr;
  }

  @Override
  public String getDescription() {
    return "Oxygen Sensor " + this.nr + "\n" + "A: Voltage\n" + "B: Short term fuel trim";
  }

  @Override
  public int getDataBytesReturned() {
    return 2;
  }

  @Override
  public double[] getMinValues() {
    return new double[] {0.0, -100.0};
  }

  @Override
  public double[] getMaxValues() {
    return new double[] {1.275, 99.2};
  }

  @Override
  public Unit[] getUnits() {
    return new Unit[] {Unit.VOLTS, Unit.PERCENT};
  }

  @Override
  public Double[] getPhysicalValues(byte[] rawBytes) {
    final Double[] values = new Double[getNumberOfValues()];
    double rawVoltageValue = rawBytes[0] & 0xFF;
    double rawPercentageValue = rawBytes[1] & 0xFF;
    values[0] = (rawVoltageValue / 200.0);
    values[1] = (100.0/128.0 * rawPercentageValue - 100);
    return values;
  }
}
