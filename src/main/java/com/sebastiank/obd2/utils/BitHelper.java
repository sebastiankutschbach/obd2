package com.sebastiank.obd2.utils;

public final class BitHelper {

  private BitHelper() {
    //avoid instantiation
  }

  public static boolean isBitSet(byte b, int bit)
  {
    return (b & (1 << bit)) != 0;
  }

  public static int countSetBits(byte b) {
    int setBitsCount = 0;
    for (int bitIndex = 0; bitIndex < 8; bitIndex++) {
      if(isBitSet(b, bitIndex)) {
        setBitsCount++;
      }
    }
    return setBitsCount;
  }

}
