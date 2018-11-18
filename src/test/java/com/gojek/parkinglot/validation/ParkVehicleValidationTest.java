package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

public class ParkVehicleValidationTest {

    ParkVehicleValidation parkVehicleValidation = null;

    @Before
    public void before() {
        parkVehicleValidation = new ParkVehicleValidation();
    }


    @Test
    public void testParkVehicleWithValidCommand() throws InvalidInputException{
        parkVehicleValidation.validate("park KA-090 RED");
    }

    @Test(expected = InvalidInputException.class)
    public void testParkVehicleWithWrongInput() throws InvalidInputException {
        parkVehicleValidation.validate("park");
    }

    @Test(expected = InvalidInputException.class)
    public void testParkVehicleWithWrongCommand() throws InvalidInputException {
        parkVehicleValidation.validate("parkvehicle KA-909 BLUE");
    }
}
