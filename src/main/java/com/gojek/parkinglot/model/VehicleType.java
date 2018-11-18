package com.gojek.parkinglot.model;

public enum VehicleType {

	MOTER_CYCLE("S"), CAR("M"), BUS("L");

	private final String type;

	VehicleType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
