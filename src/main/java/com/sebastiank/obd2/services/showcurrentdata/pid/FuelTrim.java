package com.sebastiank.obd2.services.showcurrentdata.pid;

import com.sebastiank.obd2.services.ISingleValuePid;
import com.sebastiank.obd2.utils.Unit;

public class FuelTrim implements ISingleValuePid {

  private int bank;
  private boolean shortTerm;

  public FuelTrim(int bank, boolean shortTerm) {
    this.bank = bank;
    this.shortTerm = shortTerm;
  }

  @Override
  public int getPid() {
    if(bank == 1) {
      if(shortTerm) {
        return 0x06;
      } else {
        return 0x07;
      }
    } else if(bank == 2) {
      if(shortTerm) {
        return 0x08;
      } else {
        return 0x09;
      }
    }
    return -1;
  }

  @Override
  public String getDescription() {
    if(bank == 1) {
      if(shortTerm) {
        return "Short term fuel trim—Bank 1";
      } else {
        return "Long term fuel trim—Bank 1";
      }
    } else if(bank == 2) {
      if(shortTerm) {
        return "Short term fuel trim—Bank 2";
      } else {
        return "Long term fuel trim—Bank 2";
      }
    }
    return null;
  }

  @Override
  public int getDataBytesReturned() {
    return 1;
  }

  @Override
  public double getMinValue() {
    return -100.0;
  }

  @Override
  public double getMaxValue() {
    return 99.2;
  }

  @Override
  public Unit getUnit() {
    return Unit.PERCENT;
  }

  @Override
  public Double getPhysicalValue(byte[] rawBytes) {
    return (100.0/128.0 * (rawBytes[0] & 0xFF) - 100);
  }
}
