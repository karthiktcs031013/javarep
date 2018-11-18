package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;

public interface BaseValidation<U> {
	
	void validate(U u) throws InvalidInputException;

	default void verifySyntax(int expectedTokens, int actualTokens) throws InvalidInputException {
		if (expectedTokens != actualTokens) {
			throw new InvalidInputException("Invalid syntax");
		}
	}

	default void verifyCommand(String inputCommand, String command) throws InvalidInputException {
		if (!inputCommand.equals(command)) {
			throw new InvalidInputException("Syntax Error !!");
		}
	}
}
