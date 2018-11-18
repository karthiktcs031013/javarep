package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class CreateParkingLotValidation implements BaseValidation<String> {

	@Override
	public void validate(String inputCommand) throws InvalidInputException {
		String[] commands = inputCommand.split(ParkingSlotConstants.DELIMETER);
		verifyCommand(commands[0], Command.CREATE.getValue());
		verifySyntax(2, commands.length);
		if (Integer.parseInt(commands[1]) < 1) {
			throw new InvalidInputException("minimum number of slots required = 1");
		}
	}
}
