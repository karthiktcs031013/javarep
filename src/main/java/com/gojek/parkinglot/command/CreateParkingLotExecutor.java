package com.gojek.parkinglot.command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class CreateParkingLotExecutor implements BaseExecutor<String, ParkinglotVO> {

	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {
		String str = inputCommand.split(ParkingSlotConstants.DELIMETER)[1];
		Integer slots = Integer.parseInt(str);
		List<ParkingSlot> parkingSlots = IntStream.range(1, slots + 1)
				.mapToObj(i -> new ParkingSlot.Builder().isAvailable(Boolean.TRUE).slotNumber(i).build())
				.collect(Collectors.toList());
		System.out.println("Created a parking lot with " + slots + " Slots");
		ParkinglotVO parkinglotVO2 = new ParkinglotVO();
		parkinglotVO2.setParkingSlots(parkingSlots);
		return parkinglotVO2;
	}
}
