package com.gojek.parkinglot.model;

import java.util.List;

public class ParkinglotVO {

	private List<ParkingSlot> parkingSlots;
	private String regNoByVehicleColor;
	private String slotNoByVehicleRegNo;
	private String slotNoByVehicleColor;

	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public String getRegNoByVehicleColor() {
		return regNoByVehicleColor;
	}

	public String getSlotNoByVehicleRegNo() {
		return slotNoByVehicleRegNo;
	}

	public String getSlotNoByVehicleColor() {
		return slotNoByVehicleColor;
	}

	public void setParkingSlots(List<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public void setRegNoByVehicleColor(String regNoByVehicleColor) {
		this.regNoByVehicleColor = regNoByVehicleColor;
	}

	public void setSlotNoByVehicleRegNo(String slotNoByVehicleRegNo) {
		this.slotNoByVehicleRegNo = slotNoByVehicleRegNo;
	}

	public void setSlotNoByVehicleColor(String slotNoByVehicleColor) {
		this.slotNoByVehicleColor = slotNoByVehicleColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkingSlots == null) ? 0 : parkingSlots.hashCode());
		result = prime * result + ((regNoByVehicleColor == null) ? 0 : regNoByVehicleColor.hashCode());
		result = prime * result + ((slotNoByVehicleColor == null) ? 0 : slotNoByVehicleColor.hashCode());
		result = prime * result + ((slotNoByVehicleRegNo == null) ? 0 : slotNoByVehicleRegNo.hashCode());
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
		ParkinglotVO other = (ParkinglotVO) obj;
		if (parkingSlots == null) {
			if (other.parkingSlots != null)
				return false;
		} else if (!parkingSlots.equals(other.parkingSlots))
			return false;
		if (regNoByVehicleColor == null) {
			if (other.regNoByVehicleColor != null)
				return false;
		} else if (!regNoByVehicleColor.equals(other.regNoByVehicleColor))
			return false;
		if (slotNoByVehicleColor == null) {
			if (other.slotNoByVehicleColor != null)
				return false;
		} else if (!slotNoByVehicleColor.equals(other.slotNoByVehicleColor))
			return false;
		if (slotNoByVehicleRegNo == null) {
			if (other.slotNoByVehicleRegNo != null)
				return false;
		} else if (!slotNoByVehicleRegNo.equals(other.slotNoByVehicleRegNo))
			return false;
		return true;
	}

}
