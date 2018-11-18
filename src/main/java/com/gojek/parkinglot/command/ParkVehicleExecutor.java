package com.gojek.parkinglot.command;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.model.Vehicle;
import com.gojek.parkinglot.model.VehicleType;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class ParkVehicleExecutor implements BaseExecutor<String, ParkinglotVO> {

	public ParkinglotVO execute(String inputCommand, ParkinglotVO parkinglotVO) {
		Vehicle vehicle = createVehicle(inputCommand);
		Optional<ParkingSlot> parkingSlotOptional = parkinglotVO.getParkingSlots().stream()
				.filter(ParkingSlot::getIsAvailable).findFirst();
		if (parkingSlotOptional.isPresent()) {
			System.out.println("Allocated slot number: " + parkingSlotOptional.get().getSlotNumber());
			ParkingSlot updatedParkingSlot = new ParkingSlot.Builder().copyBuilder(parkingSlotOptional.get())
					.isAvailable(Boolean.FALSE).vehicle(vehicle).entryTime(LocalDateTime.now()).build();
			List<ParkingSlot> parkingSlots = parkinglotVO.getParkingSlots();
			parkingSlots.set(updatedParkingSlot.getSlotNumber() - 1, updatedParkingSlot);
			parkinglotVO.setParkingSlots(parkingSlots);
		} else {
			System.out.println("Sorry, parking lot is full");
		}
		return parkinglotVO;
	}

	private Vehicle createVehicle(String inputString) {
		String[] inputs = inputString.split(ParkingSlotConstants.DELIMETER);
		return new Vehicle.Builder().registrationNumber(inputs[1]).color(inputs[2]).vehicleType(VehicleType.CAR)
				.build();
	}

}
