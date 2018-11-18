package com.gojek.parkinglot.util;

public enum Command {

	CREATE("create_parking_lot"), PARK("park"), LEAVE("leave"), STATUS("status"),
	REG_NO_BY_COLOR("registration_numbers_for_cars_with_colour"), SLOT_NO_BY_COLOR("slot_numbers_for_cars_with_colour"),
	SLOT_NO_BY_REG_NO("slot_number_for_registration_number");

	private final String value;

	Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
