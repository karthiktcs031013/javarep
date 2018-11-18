package com.gojek.parkinglot.validation;

import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.exception.InvalidInputException;

public class LeaveParkingLotValidationTest {

	private LeaveParkingLotValidation leaveParkingLotValidation = null;

	@Before
    public void before() {
	    leaveParkingLotValidation = new LeaveParkingLotValidation();
    }

	@Test
	public void testLeaveCommand() throws InvalidInputException {
		LeaveParkingLotValidation leaveParkingLotValidation = new LeaveParkingLotValidation();
		leaveParkingLotValidation.validate("leave 4");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInput() throws InvalidInputException {
		LeaveParkingLotValidation leaveParkingLotValidation = new LeaveParkingLotValidation();
		leaveParkingLotValidation.validate("sfdsfds 4");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithNegativeSlots() throws InvalidInputException {
		LeaveParkingLotValidation leaveParkingLotValidation = new LeaveParkingLotValidation();
		leaveParkingLotValidation.validate("leave -4");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithMoreWords() throws InvalidInputException {
		LeaveParkingLotValidation leaveParkingLotValidation = new LeaveParkingLotValidation();
		leaveParkingLotValidation.validate("leave 4 2ed");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithInvalidCommand() throws InvalidInputException {
		LeaveParkingLotValidation leaveParkingLotValidation = new LeaveParkingLotValidation();
		leaveParkingLotValidation.validate("leavevehicle 4 2ed");
	}
}
