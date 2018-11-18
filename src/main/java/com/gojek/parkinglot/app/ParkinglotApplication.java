package com.gojek.parkinglot.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gojek.parkinglot.config.ParkingLotConfig;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.park.ParkingLotTemplate;
import com.gojek.parkinglot.util.Command;
import com.gojek.parkinglot.util.ParkingSlotConstants;

public class ParkinglotApplication {

	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");

	public static void main(String[] args) {
		if (args.length == 0) {
			interactiveMode();
		} else {
			readFromFile(args[0]);
		}
	}

	@SuppressWarnings("resource")
	private static void interactiveMode() {
		System.out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		ParkinglotVO updatedParkinglotVO = null;
		while (!exitCommands.contains(input)) {
			updatedParkinglotVO = executeCommand(input, updatedParkinglotVO);
			input = inputScanner.nextLine();
		}
		System.out.println("*** Parking lot application shutdown. ***");
		inputScanner.close();
	}

	private static void readFromFile(String filePath) {
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			List<String> lines = stream.collect(Collectors.toList());
			ParkinglotVO updatedParkinglotVO = null;
			for (String line : lines) {
				updatedParkinglotVO = executeCommand(line, updatedParkinglotVO);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("*** Parking lot application shutdown. ***");

	}

	private static ParkinglotVO executeCommand(String inputCommand, ParkinglotVO updatedParkinglotVO) {
		String command = inputCommand.split(ParkingSlotConstants.DELIMETER)[0];
		Optional<ParkingLotTemplate> parkingTemplateOptional = Optional
				.ofNullable(ParkingLotConfig.parkingLotCommand().get(command));
		if (parkingTemplateOptional.isPresent()) {
			updatedParkinglotVO = command.equals(Command.CREATE.getValue())
					? parkingTemplateOptional.get().parkVehicle(inputCommand, null)
					: parkingTemplateOptional.get().parkVehicle(inputCommand, updatedParkinglotVO);
		} else {
			System.out.println("Invalid command");
		}
		return updatedParkinglotVO;
	}

}
