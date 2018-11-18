package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

public class SlotNoByVehicleColorValidationTest {

    private SlotNoByVehicleColorValidation slotNoByVehicleColorValidation;

    @Before
    public void before() {
        slotNoByVehicleColorValidation = new SlotNoByVehicleColorValidation();
    }

    @Test
    public void testValidCommand() throws InvalidInputException {
        slotNoByVehicleColorValidation.validate("slot_numbers_for_cars_with_colour White");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidCommand() throws InvalidInputException {
        slotNoByVehicleColorValidation.validate("slot_numbers_for_cars_with_Regno White");
    }

    @Test(expected = InvalidInputException.class)
    public void testMoreCommandLength() throws InvalidInputException {
        slotNoByVehicleColorValidation.validate("slot_numbers_for_cars_with_colour White 323");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidCommand1() throws InvalidInputException {
        slotNoByVehicleColorValidation.validate("slot_numbers_for_cars_with_colours White");
    }

    @Test(expected = InvalidInputException.class)
    public void testLessCommandLength() throws InvalidInputException {
        slotNoByVehicleColorValidation.validate("slot_numbers_for_cars_with_colour");
    }
}
