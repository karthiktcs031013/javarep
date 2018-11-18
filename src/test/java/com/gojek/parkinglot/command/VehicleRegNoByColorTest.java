package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkinglot.model.ParkinglotVO;

public class VehicleRegNoByColorTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testTraceRegNoByVehicleColor() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> vehicleRegNoByColor = new VehicleRegNoByColor();
		ParkinglotVO parkinglotVO2 = vehicleRegNoByColor.execute("registration_numbers_for_cars_with_colour White",
				parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals("KA-4234,KA-4237", parkinglotVO2.getRegNoByVehicleColor());
	}
}
