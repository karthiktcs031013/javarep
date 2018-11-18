package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkinglot.model.ParkinglotVO;

public class ParkVehicleTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testCreateParkingLot() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> park = new ParkVehicleExecutor();
		ParkinglotVO parkinglotVO2 = park.execute("park KA-01-HH-9999 White", parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals(6, parkinglotVO2.getParkingSlots().size());
	}

}
