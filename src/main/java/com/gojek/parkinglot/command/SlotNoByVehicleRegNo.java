package com.gojek.parkinglot.command;

import java.util.List;
import java.util.stream.Collectors;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.util.ParkingSlotConstants;
import com.gojek.parkinglot.util.ParkinglotUtil;

public class SlotNoByVehicleRegNo implements BaseExecutor<String, ParkinglotVO> {

	@Override
	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {
		String regNo = inputCommand.split(ParkingSlotConstants.DELIMETER)[1];
		List<ParkingSlot> parkingSlots = parkinglotVO.getParkingSlots();
		String slotNo = parkingSlots.stream().filter(ParkinglotUtil.not(ParkingSlot::getIsAvailable))
				.filter(parkingSlot -> ParkinglotUtil.PREDICATE_BY_REG_NO.test(parkingSlot, regNo))
				.map(ParkinglotUtil.FETCH_SLOT_NO).collect(Collectors.joining(","));
		System.out.println(slotNo.isEmpty() ? ParkingSlotConstants.NOT_FOUND : slotNo);
		parkinglotVO.setSlotNoByVehicleRegNo(slotNo);
		return parkinglotVO;
	}

}
