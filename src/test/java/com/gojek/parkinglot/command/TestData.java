package com.gojek.parkinglot.command;

import java.util.Arrays;
import java.util.List;

import com.gojek.parkinglot.model.ParkingSlot;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.model.Vehicle;
import com.gojek.parkinglot.model.VehicleType;

public class TestData {

	public static ParkinglotVO createPark() {
		ParkinglotVO parkinglotVO = new ParkinglotVO();
		parkinglotVO.setParkingSlots(createParkingSlots());
		return parkinglotVO;
	}

	public static List<ParkingSlot> createParkingSlots() {
		ParkingSlot parkingSlot1 = new ParkingSlot.Builder().isAvailable(Boolean.FALSE).vehicle(
				new Vehicle.Builder().color("White").registrationNumber("KA-4234").vehicleType(VehicleType.CAR).build())
				.slotNumber(1).build();
		ParkingSlot parkingSlot2 = new ParkingSlot.Builder().isAvailable(Boolean.FALSE).vehicle(
				new Vehicle.Builder().color("Red").registrationNumber("KA-4235").vehicleType(VehicleType.CAR).build())
				.slotNumber(2).build();
		ParkingSlot parkingSlot4 = new ParkingSlot.Builder().isAvailable(Boolean.FALSE).vehicle(
				new Vehicle.Builder().color("Blue").registrationNumber("KA-4236").vehicleType(VehicleType.CAR).build())
				.slotNumber(4).build();
		ParkingSlot parkingSlot5 = new ParkingSlot.Builder().isAvailable(Boolean.FALSE).vehicle(
				new Vehicle.Builder().color("White").registrationNumber("KA-4237").vehicleType(VehicleType.CAR).build())
				.slotNumber(5).build();
		ParkingSlot parkingSlot6 = new ParkingSlot.Builder().isAvailable(Boolean.FALSE).vehicle(
				new Vehicle.Builder().color("Red").registrationNumber("KA-4238").vehicleType(VehicleType.CAR).build())
				.slotNumber(6).build();
		ParkingSlot parkingSlot3 = new ParkingSlot.Builder().isAvailable(Boolean.TRUE).vehicle(
				new Vehicle.Builder().color("Blue").registrationNumber("KA-4239").vehicleType(VehicleType.CAR).build())
				.slotNumber(3).build();
		List<ParkingSlot> parkingSlots = Arrays.asList(parkingSlot1, parkingSlot2, parkingSlot4, parkingSlot5,
				parkingSlot6, parkingSlot3);
		return parkingSlots;
	}

}
