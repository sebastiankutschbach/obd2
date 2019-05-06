package com.sebastiank.obd2.services;

import com.sebastiank.obd2.utils.Unit;

public interface ISingleValuePid extends IPid{

  double getMinValue();

  double getMaxValue();

  Unit getUnit();

  Object getPhysicalValue(byte[] rawBytes);
}
