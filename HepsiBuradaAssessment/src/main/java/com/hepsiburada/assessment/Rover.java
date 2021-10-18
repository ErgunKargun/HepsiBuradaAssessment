package com.hepsiburada.assessment;

public class Rover {

	private Position position;
	private String instructions;
	
	public Rover(Position position, String instructions) {
		this.position = position;
		this.instructions = instructions;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public void moveByInstructions() {

		for (int i = 0; i < instructions.length(); i++) {
			char instruction = instructions.charAt(i);
			switch (instruction) {
			case 'M':
				move();
				break;
			default:
				turn(instruction);
				break;
			}
		}
	}

	private void turn(char instruction) {
		
		if(position.getDirection() == 'N') {
			if(instruction == 'L')
				position.setDirection('E');
			if(instruction == 'R')
				position.setDirection('W');
		}
		if(position.getDirection() == 'S') {
			if(instruction == 'L')
				position.setDirection('w');
			if(instruction == 'R')
				position.setDirection('E');
		}
		if(position.getDirection() == 'E') {
			if(instruction == 'L')
				position.setDirection('N');
			if(instruction == 'R')
				position.setDirection('S');
		}
		if(position.getDirection() == 'W') {
			if(instruction == 'L')
				position.setDirection('S');
			if(instruction == 'R')
				position.setDirection('N');
		}
	}

	private void move() {

		if(position.getDirection() == 'N') {
			if(Border.x < 0) {
				if(0 > position.getPosX() && position.getPosX() > Border.x) 
					position.setPosX(position.getPosX()+1);
			}
			else if(Border.x > 0) {
				if(0 < position.getPosX() && position.getPosX() < Border.x) 
					position.setPosX(position.getPosX()+1);
			}
		}
		if(position.getDirection() == 'S') {
			if(Border.x < 0) {
				if(0 > position.getPosX() && position.getPosX() > Border.x) 
					position.setPosX(position.getPosX()-1);
			}
			else if(Border.x > 0) {
				if(0 < position.getPosX() && position.getPosX() < Border.x) 
					position.setPosX(position.getPosX()-1);
			}
		}
		if(position.getDirection() == 'E') {
			if(Border.y < 0) {
				if(0 > position.getPosY() && position.getPosY() > Border.x) 
					position.setPosY(position.getPosY()+1);
			}
			else if(Border.y > 0) {
				if(0 < position.getPosY() && position.getPosY() < Border.y) 
					position.setPosY(position.getPosY()+1);
			}
		}
		if(position.getDirection() == 'W') {
			if(Border.y < 0) {
				if(0 > position.getPosY() && position.getPosX() > Border.x) 
					position.setPosY(position.getPosY()-1);
			}
			else if(Border.y > 0) {
				if(0 < position.getPosY() && position.getPosX() < Border.x) 
					position.setPosY(position.getPosY()-1);
			}
		}
	}	
}
