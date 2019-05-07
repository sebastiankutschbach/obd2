package com.sebastiank.obd2.services.pids.showcurrentdata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sebastiank.obd2.TestConstants;
import com.sebastiank.obd2.services.ShowCurrentData;
import org.junit.Test;

public class ShowCurrentDataTest {

  private ShowCurrentData sut = new ShowCurrentData();

  @Test
  public void getServiceId() {
    assertEquals(0x01, sut.getServiceId());
  }

  @Test
  public void getServiceDescription() {
    assertEquals("Show current data", sut.getServiceDescription());
  }

  @Test
  public void createRequest() {
    final byte[] request = sut.createRequest(ShowCurrentDataPids.getDescriptionFor(1));
    assertEquals(0x01, request[0]);
    assertEquals(0x01, request[1]);
  }

  @Test
  public void interpretResponse() {
    final Object response = sut.interpretResponse(new byte[]{(byte) 0x01, (byte) 0x04, (byte) 0xFF});

    assertTrue(response instanceof Double);
    assertEquals(100.0, (double)response, TestConstants.EPSILON);
  }
}
