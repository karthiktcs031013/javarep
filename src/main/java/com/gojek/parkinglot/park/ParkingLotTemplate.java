package com.gojek.parkinglot.park;

import com.gojek.parkinglot.command.BaseExecutor;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.validation.BaseValidation;

public class ParkingLotTemplate<U extends BaseExecutor<String, ParkinglotVO>, V extends BaseValidation<String>, W extends ParkinglotVO> {

	private U baseCommand;
	private V baseValidation;

	public ParkingLotTemplate(U baseCommand, V baseValidation) {
		this.baseCommand = baseCommand;
		this.baseValidation = baseValidation;
	}

	public W parkVehicle(String inputCommand, W parkinglotVO) {
		W parkinglotVO2 = null;
		try {
			baseValidation.validate(inputCommand);
			parkinglotVO2 = (W) baseCommand.execute(inputCommand, parkinglotVO);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		return parkinglotVO2;
	}

}
