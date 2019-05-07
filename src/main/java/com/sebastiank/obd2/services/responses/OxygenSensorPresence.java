package com.sebastiank.obd2.services.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OxygenSensorPresence {
  private int bankNumber;
  private boolean sensor1Present;
  private boolean sensor2Present;
  private boolean sensor3Present;
  private boolean sensor4Present;
}
