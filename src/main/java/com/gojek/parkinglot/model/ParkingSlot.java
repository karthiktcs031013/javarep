package com.gojek.parkinglot.model;

import java.time.LocalDateTime;

public class ParkingSlot implements Slot {

	private Integer slotNumber;
	private Vehicle vehicle;
	private Boolean isAvailable;
	private LocalDateTime entryTime;

	public Integer getSlotNumber() {
		return slotNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entryTime == null) ? 0 : entryTime.hashCode());
		result = prime * result + ((isAvailable == null) ? 0 : isAvailable.hashCode());
		result = prime * result + ((slotNumber == null) ? 0 : slotNumber.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		ParkingSlot other = (ParkingSlot) obj;
		if (entryTime == null) {
			if (other.entryTime != null)
				return false;
		} else if (!entryTime.equals(other.entryTime))
			return false;
		if (isAvailable == null) {
			if (other.isAvailable != null)
				return false;
		} else if (!isAvailable.equals(other.isAvailable))
			return false;
		if (slotNumber == null) {
			if (other.slotNumber != null)
				return false;
		} else if (!slotNumber.equals(other.slotNumber))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	public static class Builder {
		private Integer slotNumber;
		private Vehicle vehicle;
		private Boolean isAvailable;
		private LocalDateTime entryTime;

		public Builder slotNumber(Integer slotNumber) {
			this.slotNumber = slotNumber;
			return this;
		}

		public Builder vehicle(Vehicle vehicle) {
			this.vehicle = vehicle;
			return this;
		}

		public Builder isAvailable(Boolean isAvailable) {
			this.isAvailable = isAvailable;
			return this;
		}

		public Builder entryTime(LocalDateTime entryTime) {
			this.entryTime = entryTime;
			return this;
		}
		
		public Builder copyBuilder(ParkingSlot parkingSlot) {
			this.slotNumber = parkingSlot.getSlotNumber();
			this.vehicle = parkingSlot.getVehicle();
			this.isAvailable = parkingSlot.getIsAvailable();
			this.entryTime = parkingSlot.getEntryTime();
			return this;
		}

		public ParkingSlot build() {
			return new ParkingSlot(this);
		}
	}

	private ParkingSlot(Builder builder) {
		this.slotNumber = builder.slotNumber;
		this.vehicle = builder.vehicle;
		this.isAvailable = builder.isAvailable;
		this.entryTime = builder.entryTime;
	}
}
