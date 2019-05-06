package com.sebastiank.obd2.services;

import com.sebastiank.obd2.utils.Unit;

public interface IMultiValuePid extends IPid {

  int getNumberOfValues();

  double[] getMinValues();

  double[] getMaxValues();

  Unit[] getUnits();

  Object[] getPhysicalValues(byte[] rawBytes);
}
