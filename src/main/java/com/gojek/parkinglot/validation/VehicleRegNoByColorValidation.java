package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class VehicleRegNoByColorValidation implements BaseValidation<String> {

	@Override
	public void validate(String inputCommand) throws InvalidInputException {
		String[] commands = inputCommand.split(ParkingSlotConstants.DELIMETER);
		verifyCommand(commands[0], Command.REG_NO_BY_COLOR.getValue());
		verifySyntax(2, commands.length);
	}

}
