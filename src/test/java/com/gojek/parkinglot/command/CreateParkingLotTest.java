package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkinglot.model.ParkinglotVO;

public class CreateParkingLotTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testCreateParkingLot() {
		BaseExecutor<String, ParkinglotVO> createPL = new CreateParkingLotExecutor();
		ParkinglotVO parkinglotVO2 = createPL.execute("create_parking_lot 7", null);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals(7, parkinglotVO2.getParkingSlots().size());
	}

	@Test
	public void testInvalidInput() {
		exception.expect(RuntimeException.class);
		new CreateParkingLotExecutor().execute("create_parking_lot K", null);
	}

}
