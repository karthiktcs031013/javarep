package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

public class VehicleRegNoByColorValidationTest {
    private VehicleRegNoByColorValidation vehicleRegNoByColorValidation = null;

    @Before
    public void before() {
        vehicleRegNoByColorValidation = new VehicleRegNoByColorValidation();
    }

    @Test
    public void testValidCommand() throws InvalidInputException {
        vehicleRegNoByColorValidation.validate("registration_numbers_for_cars_with_colour White");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidCommand() throws  InvalidInputException {
        vehicleRegNoByColorValidation.validate("registration_numbers_for_cars_with_colours white");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidLength() throws  InvalidInputException {
        vehicleRegNoByColorValidation.validate("registration_numbers_for_cars_with_colours white ew");
    }
}
