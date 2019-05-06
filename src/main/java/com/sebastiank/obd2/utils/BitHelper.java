package com.sebastiank.obd2.utils;

public final class BitHelper {

  private BitHelper() {
    //avoid instantiation
  }

  public static boolean isBitSet(byte b, int bit)
  {
    return (b & (1 << bit)) != 0;
  }

}
