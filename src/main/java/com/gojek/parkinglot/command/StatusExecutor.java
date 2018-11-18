package com.gojek.parkinglot.command;

import java.util.List;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.util.ParkinglotUtil;

public class StatusExecutor implements BaseExecutor<String,ParkinglotVO> {

	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {

		List<ParkingSlot> parkingSlots = parkinglotVO.getParkingSlots();
		System.out.println("Slot NO.\t Registration No \t Color");
		parkingSlots.stream().filter(ParkinglotUtil.not(ParkingSlot::getIsAvailable)).forEach(parkingSlot -> {
			System.out.println(parkingSlot.getSlotNumber() + "\t\t\t" + parkingSlot.getVehicle().getRegistrationNumber()
					+ "\t\t" + parkingSlot.getVehicle().getColor());
		});
		return parkinglotVO;
	}

}
