package com.sebastiank.obd2.services.pids.showcurrentdata;

import com.sebastiank.obd2.services.pids.IPid;
import java.util.ArrayList;
import java.util.List;

public class ShowCurrentDataPids {
  public static final List<IPid> PIDS =
      new ArrayList<IPid>() {
        {
          add(new AuxiliaryInputStatus());
          add(new CalculatedEngineLoad());
          add(new CommandedSecondaryAirStatus());
          add(new EngineCoolantTemperature());
          add(new EngineRpm());
          add(new FreezeDtcs());
          add(new FuelPressure());
          add(new FuelSystemStatus());
          add(new IntakeAirTemperature());
          add(new IntakeManifoldAbsolutePressure());
          add(new MafAirFlowRate());
          add(new MonitorStatusSinceDtcsCleared());
          add(new ObdStandard());
          add(new OxygenSensor(1));
          add(new OxygenSensor(2));
          add(new OxygenSensor(3));
          add(new OxygenSensor(4));
          add(new OxygenSensor(5));
          add(new OxygenSensor(6));
          add(new OxygenSensor(7));
          add(new OxygenSensor(8));
          add(new OxygenSensorsPresent(true));
          add(new OxygenSensorsPresent(false));
          add(new PidsSupported(true));
          add(new PidsSupported(false));
          add(new RuntimeSinceEngineStart());
          add(new FuelTrim(1, true));
          add(new FuelTrim(1, false));
          add(new FuelTrim(2, true));
          add(new FuelTrim(2, false));
          add(new ThrottlePosition());
          add(new TimingAdvance());
          add(new VehicleSpeed());
        }
      };

  public static IPid getDescriptionFor(int pid) {
    return PIDS.stream()
        .filter(description -> description.getPid() == pid)
        .findFirst()
        .orElse(null);
  }
}
