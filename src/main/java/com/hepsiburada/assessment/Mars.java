package com.hepsiburada.assessment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mars {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] upperRightCoordinates = scanner.nextLine().split(" ");
		Border.x = Integer.parseInt(upperRightCoordinates[0]);
		Border.y = Integer.parseInt(upperRightCoordinates[1]);
		List<Rover> rovers = new ArrayList<Rover>();
		while(scanner.hasNextLine()) {

			String[] positionAndDirectionOfRover = scanner.nextLine().split(" ");
			int posX = Integer.parseInt(positionAndDirectionOfRover[0]);
			int posY = Integer.parseInt(positionAndDirectionOfRover[1]);
			char direction = positionAndDirectionOfRover[2].charAt(0);
			String instructions = scanner.nextLine();
			rovers.add(new Rover(new Position(posX, posY, direction), instructions));
		}
		scanner.close();
		
		rovers.forEach(r -> {
			r.moveByInstructions();
			System.out.println(r.getPosition().toString()); 
		});
	}
}