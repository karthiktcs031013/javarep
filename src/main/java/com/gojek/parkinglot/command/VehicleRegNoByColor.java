package com.gojek.parkinglot.command;

import java.util.List;
import java.util.stream.Collectors;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.util.ParkingSlotConstants;
import com.gojek.parkinglot.util.ParkinglotUtil;

public class VehicleRegNoByColor implements BaseExecutor<String, ParkinglotVO> {

	@Override
	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {
		String color = inputCommand.split(ParkingSlotConstants.DELIMETER)[1];
		List<ParkingSlot> parkingSlots = parkinglotVO.getParkingSlots();
		String regNo = parkingSlots.stream().filter(ParkinglotUtil.not(ParkingSlot::getIsAvailable))
				.filter(parkingSlot -> ParkinglotUtil.PERDICATE_BY_COLOR.test(parkingSlot, color))
				.map(ParkinglotUtil.FETCH_REG_NO_BY_COLOR).collect(Collectors.joining(","));
		System.out.println(regNo.isEmpty() ? ParkingSlotConstants.NOT_FOUND : regNo);
		parkinglotVO.setRegNoByVehicleColor(regNo);
		return parkinglotVO;
	}

}
