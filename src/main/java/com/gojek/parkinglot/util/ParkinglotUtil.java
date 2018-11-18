package com.gojek.parkinglot.util;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import com.gojek.parkinglot.model.ParkingSlot;

public class ParkinglotUtil {

	private ParkinglotUtil() {

	}

	public static final BiPredicate<ParkingSlot, String> PERDICATE_BY_COLOR = (slot, color) -> slot.getVehicle()
			.getColor().equalsIgnoreCase(color);

	public static final BiPredicate<ParkingSlot, String> PREDICATE_BY_REG_NO = (slot, regNO) -> slot.getVehicle()
			.getRegistrationNumber().equalsIgnoreCase(regNO);

	public static final Function<ParkingSlot, String> FETCH_REG_NO_BY_COLOR = slot -> slot.getVehicle()
			.getRegistrationNumber();

	public static final Function<ParkingSlot, String> FETCH_SLOT_NO = slot -> "" + slot.getSlotNumber();


	public static <R> Predicate<R> not(Predicate<R> predicate) {
		return predicate.negate();
	}

}
