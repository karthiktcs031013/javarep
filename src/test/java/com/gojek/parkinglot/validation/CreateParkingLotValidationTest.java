package com.gojek.parkinglot.validation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gojek.parkinglot.exception.InvalidInputException;

public class CreateParkingLotValidationTest {

	private CreateParkingLotValidation createParkingLotValidation = null;

	@Before
	public void beforeAllTestMethods() {
		createParkingLotValidation = new CreateParkingLotValidation();
	}

	@Test
	public void testCreateCommand() throws InvalidInputException {
		createParkingLotValidation.validate("create_parking_lot 6");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInput() throws InvalidInputException {
		createParkingLotValidation.validate("leave_parking_lot 6");
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithNegativeSlots() throws InvalidInputException {
		createParkingLotValidation.validate("create_parking_lot -1");
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithMoreWords() throws InvalidInputException {
		createParkingLotValidation.validate("create_parking_lot 7 33");
	}

	@Test(expected = InvalidInputException.class)
	public void testInValidInputWithInvalidCommand() throws InvalidInputException {
		createParkingLotValidation.validate("create_parking_lot23 7 33");
	}

}
