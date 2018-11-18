package com.gojek.parkinglot.command;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parkinglot.model.ParkinglotVO;

public class SlotNoByVehicleColorTest {
	@Test
	public void testSlotNoByVehicleColor() {
		ParkinglotVO parkinglotVO = TestData.createPark();
		BaseExecutor<String, ParkinglotVO> slotNoByColor = new SlotNoByVehicleColor();
		ParkinglotVO parkinglotVO2 = slotNoByColor.execute("slot_numbers_for_cars_with_colour White", parkinglotVO);
		Assert.assertNotNull(parkinglotVO2);
		Assert.assertEquals("1,5", parkinglotVO2.getSlotNoByVehicleColor());
	}
}
