package com.gojek.parkinglot.validation;

import com.gojek.parkinglot.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

public class StatusValidationTest {

    private StatusValidation statusValidation = null;

    @Before
    public void before() {
        statusValidation = new StatusValidation();
    }

    @Test
    public void testValidStatusCommand() throws InvalidInputException {
        statusValidation.validate("status");
    }

    @Test(expected = InvalidInputException.class)
    public void testInValidStatusCommand() throws InvalidInputException {
        statusValidation.validate("statusparking");
    }

    @Test(expected = InvalidInputException.class)
    public void testValidStatusCommandLength() throws InvalidInputException {
        statusValidation.validate("status 32");
    }

}
