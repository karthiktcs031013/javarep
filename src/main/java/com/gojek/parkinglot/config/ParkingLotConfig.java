package com.gojek.parkinglot.config;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parkinglot.command.CreateParkingLotExecutor;
import com.gojek.parkinglot.command.LeaveParkingSlotExecutor;
import com.gojek.parkinglot.command.ParkVehicleExecutor;
import com.gojek.parkinglot.command.SlotNoByVehicleColor;
import com.gojek.parkinglot.command.SlotNoByVehicleRegNo;
import com.gojek.parkinglot.command.StatusExecutor;
import com.gojek.parkinglot.command.VehicleRegNoByColor;
import com.gojek.parkinglot.park.ParkingLotTemplate;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.validation.CreateParkingLotValidation;
import com.gojek.parkinglot.validation.LeaveParkingLotValidation;
import com.gojek.parkinglot.validation.ParkVehicleValidation;
import com.gojek.parkinglot.validation.SlotNoByRegNoValidation;
import com.gojek.parkinglot.validation.SlotNoByVehicleColorValidation;
import com.gojek.parkinglot.validation.StatusValidation;
import com.gojek.parkinglot.validation.VehicleRegNoByColorValidation;

public class ParkingLotConfig {

	private ParkingLotConfig() {

	}

	public static Map<String, ParkingLotTemplate> parkingLotCommand() {
		Map<String, ParkingLotTemplate> parkingLotCommands = new HashMap<>();
		parkingLotCommands.put(Command.CREATE.getValue(),
				new ParkingLotTemplate(new CreateParkingLotExecutor(), new CreateParkingLotValidation()));
		parkingLotCommands.put(Command.LEAVE.getValue(),
				new ParkingLotTemplate(new LeaveParkingSlotExecutor(), new LeaveParkingLotValidation()));
		parkingLotCommands.put(Command.PARK.getValue(),
				new ParkingLotTemplate(new ParkVehicleExecutor(), new ParkVehicleValidation()));
		parkingLotCommands.put(Command.STATUS.getValue(),
				new ParkingLotTemplate(new StatusExecutor(), new StatusValidation()));
		parkingLotCommands.put(Command.REG_NO_BY_COLOR.getValue(),
				new ParkingLotTemplate(new VehicleRegNoByColor(), new VehicleRegNoByColorValidation()));
		parkingLotCommands.put(Command.SLOT_NO_BY_COLOR.getValue(),
				new ParkingLotTemplate(new SlotNoByVehicleColor(), new SlotNoByVehicleColorValidation()));
		parkingLotCommands.put(Command.SLOT_NO_BY_REG_NO.getValue(),
				new ParkingLotTemplate(new SlotNoByVehicleRegNo(), new SlotNoByRegNoValidation()));
		return parkingLotCommands;
	}

}
