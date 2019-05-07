package com.sebastiank.obd2.utils;

public enum EFuelSystemStatus {
  OPEN_LOOP_INSUFFICIENT_AIR_TEMP("Open loop due to insufficient engine temperature"),
	CLOSED_LOOP_USING_OXYGEN_SENSOR_FEEDBACK("Closed loop, using oxygen sensor feedback to determine fuel mix"),
  OPEN_LOOP_DUE_TO_ENGINE_LOAD_OR_FUEL_CUT_OFF("Open loop due to engine load OR fuel cut due to deceleration"),
  OPEN_LOOP_DUE_TP_SYSTEM_FAILURE("Open loop due to system failure"),
  CLOSED_LOOP_ERROR_IN_FEEDBACK_SYSTEM("Closed loop, using at least one oxygen sensor but there is a fault in the feedback system"),
  INVALID_RESPONSE("More than one bit was set - invalid response");

  private String description;

  EFuelSystemStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
