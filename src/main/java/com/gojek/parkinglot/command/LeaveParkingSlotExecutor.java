package com.gojek.parkinglot.command;

import java.util.List;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class LeaveParkingSlotExecutor implements BaseExecutor<String, ParkinglotVO> {

	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {
		String str = inputCommand.split(ParkingSlotConstants.DELIMETER)[1];
		int slotNo = Integer.parseInt(str);
		List<ParkingSlot> parkingSlots = parkinglotVO.getParkingSlots();
		ParkingSlot parkingSlot = parkinglotVO.getParkingSlots().get(slotNo - 1);
		ParkingSlot updatedSlot = new ParkingSlot.Builder().copyBuilder(parkingSlot).vehicle(null)
				.isAvailable(Boolean.TRUE).build();
		parkingSlots.set(slotNo - 1, updatedSlot);
		parkinglotVO.setParkingSlots(parkingSlots);
		return parkinglotVO;
	}

}
