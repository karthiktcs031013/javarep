package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class ParkVehicleValidation implements BaseValidation<String> {

	@Override
	public void validate(String inputCommand) throws InvalidInputException {
		String[] commands = inputCommand.split(ParkingSlotConstants.DELIMETER);
		verifyCommand(commands[0], Command.PARK.getValue());
		verifySyntax(3, commands.length);
	}

}
