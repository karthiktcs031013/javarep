package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class SlotNoByRegNoValidation implements BaseValidation<String> {

	@Override
	public void validate(String inputCommand) throws InvalidInputException {
		String[] commands = inputCommand.split(ParkingSlotConstants.DELIMETER);
		verifyCommand(commands[0], Command.SLOT_NO_BY_REG_NO.getValue());
		verifySyntax(2, commands.length);
	}

}
