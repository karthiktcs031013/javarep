package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkinglot.model.ParkinglotVO;

public class StatusTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testStatus() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> status = new StatusExecutor();
		ParkinglotVO parkinglotVO2 = status.execute("status", parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals(6, parkinglotVO2.getParkingSlots().size());
	}
}
