package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parkinglot.model.ParkinglotVO;

public class SlotNoByVehicleRegNoTest {

	@Test
	public void testSlotNoByVehicleRegNO() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> slotNoByRegNo = new SlotNoByVehicleRegNo();
		ParkinglotVO parkinglotVO2 = slotNoByRegNo.execute("slot_number_for_registration_number KA-4234", parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals("1", parkinglotVO2.getSlotNoByVehicleRegNo());
	}
}
