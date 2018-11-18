package com.gojek.parkinglot.model;

public class Vehicle {

	private String registrationNumber;
	private String color;
	private VehicleType vehicleType;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((registrationNumber == null) ? 0 : registrationNumber.hashCode());
		result = prime * result + ((vehicleType == null) ? 0 : vehicleType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (registrationNumber == null) {
			if (other.registrationNumber != null)
				return false;
		} else if (!registrationNumber.equals(other.registrationNumber))
			return false;
		if (vehicleType != other.vehicleType)
			return false;
		return true;
	}

	public static class Builder {
		private String registrationNumber;
		private String color;
		private VehicleType vehicleType;

		public Builder registrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
			return this;
		}

		public Builder color(String color) {
			this.color = color;
			return this;
		}

		public Builder vehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}

		public Vehicle build() {
			return new Vehicle(this);
		}
	}

	private Vehicle(Builder builder) {
		this.registrationNumber = builder.registrationNumber;
		this.color = builder.color;
		this.vehicleType = builder.vehicleType;
	}
}
