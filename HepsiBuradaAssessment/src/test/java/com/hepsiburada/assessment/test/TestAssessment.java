package com.hepsiburada.assessment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hepsiburada.assessment.Border;
import com.hepsiburada.assessment.Position;
import com.hepsiburada.assessment.Rover;

public class TestAssessment {

	@Test
	public void testMarsRovers() {

		List<String> excpectedOutputs = Arrays.asList("1 3 N", "5 1 E");
		List<String> outputs = new ArrayList<String>();

		Border.x = 5;
		Border.y = 5;

		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(new Rover(new Position(1, 2, 'N'), "LMLMLMLM"));
		rovers.add(new Rover(new Position(3, 3, 'E'), "MMRMMRMRRM"));

		rovers.forEach(r -> {
			r.moveByInstructions();
			outputs.add(r.getPosition().toString());
		});

		assertEquals(outputs, excpectedOutputs);
	}
}
