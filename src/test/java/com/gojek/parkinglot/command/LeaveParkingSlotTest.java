package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkinglot.model.ParkinglotVO;

public class LeaveParkingSlotTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testLeaveParkingSlot() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> leavePL = new LeaveParkingSlotExecutor();
		ParkinglotVO parkinglotVO2 = leavePL.execute("leave 5", parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals(6, parkinglotVO2.getParkingSlots().size());
	}

	@Test
	public void testInvalidInput() {
		exception.expect(RuntimeException.class);
		ParkinglotVO parkinglotVO = new ParkinglotVO();
		parkinglotVO.setParkingSlots(TestData.createParkingSlots());
		new LeaveParkingSlotExecutor().execute("leave dd", parkinglotVO);
	}

}
