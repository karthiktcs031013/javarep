package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

public class SlotNoByRegNoValidationTest {

    private SlotNoByRegNoValidation slotNoByVehicleRegNo;

    @Before
    public void before() {
        slotNoByVehicleRegNo = new SlotNoByRegNoValidation();
    }

    @Test
    public void testValidCommand() throws InvalidInputException {
        slotNoByVehicleRegNo.validate("slot_number_for_registration_number White");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidCommand() throws InvalidInputException {
        slotNoByVehicleRegNo.validate("slot_number_for_registration_color White");
    }

    @Test(expected = InvalidInputException.class)
    public void testMoreCommandLength() throws InvalidInputException {
        slotNoByVehicleRegNo.validate("slot_number_for_registration_number White 323");
    }


    @Test(expected = InvalidInputException.class)
    public void testLessCommandLength() throws InvalidInputException {
        slotNoByVehicleRegNo.validate("slot_number_for_registration_number");
    }
}
