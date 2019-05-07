package com.sebastiank.obd2.services.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ECommandedSecondaryAirStatus {
  UPSTREAM("Upstream"),
  DOWNSTREAM("Downstream of catalytic converter"),
  OUTSIDE_OR_OFF("From the outside atmosphere or off"),
  PUMP_COMMANDED_ON_DIAGNOSTICS("Pump commanded on for diagnostics"),
  INVALID_RESPONSE("No or several bits are set. Invalid response.");

  @Getter private String description;
}
