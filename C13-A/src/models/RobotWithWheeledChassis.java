package models;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class RobotWithWheeledChassis {

	private Wheel wheel1;
	private Wheel wheel2;
	private Chassis chassis;
	private MovePilot pilot;
	private double squareWidth = 85;
	private double linearSpeed = 100; // Speed in robot units/second
	private double angularSpeed = 90; // Speed in degrees/second
	private double linearAcceleration = 100; // Acceleration in robot units/second^2
	private double angularAcceleration = 90; // Acceleration in degrees/second^2

	public RobotWithWheeledChassis() {
		wheel1 = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-78);
		wheel2 = WheeledChassis.modelWheel(Motor.B, 43.2).offset(78);
		chassis = new WheeledChassis(new Wheel[] { wheel1, wheel2 }, WheeledChassis.TYPE_DIFFERENTIAL);
		pilot = new MovePilot(chassis);
		chassis.setLinearSpeed(linearSpeed);
		chassis.setAngularSpeed(angularSpeed);
		chassis.setLinearAcceleration(linearAcceleration);
		chassis.setAngularAcceleration(angularAcceleration);
	}

	public void rotateRight() {
		pilot.rotate(90.0);
	}

	public void rotateLeft() {
		pilot.rotate(-90.0);
	}

	public void moveSquaresForward(double number) {
		pilot.travel(squareWidth * number);
	}

	public void moveSquaresBackward(double number) {
		pilot.travel(-squareWidth * number);
	}

	public void goToSquareNumber(int number) {
		switch (number) {
		case 0:
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(1);
			break;
		case 1:
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(2);
			break;
		case 2:
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(3);
			break;
		case 3:
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(1);
			break;
		case 4:
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(2);
			break;
		case 5:
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			this.moveSquaresForward(3);
			break;
		case 6:
			this.rotateRight();
			this.moveSquaresForward(1.5);
			this.rotateLeft();
			this.moveSquaresForward(1);
			break;
		case 7:
			this.rotateRight();
			this.moveSquaresForward(1.5);
			this.rotateLeft();
			this.moveSquaresForward(2);
			break;
		case 8:
			this.rotateRight();
			this.moveSquaresForward(1.5);
			this.rotateLeft();
			this.moveSquaresForward(3);
			break;
		}
	}

	public void returnFromSquareNumber(int number) {
		switch (number) {
		case 0:
			this.moveSquaresBackward(1);
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			break;
		case 1:
			this.moveSquaresBackward(2);
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			break;
		case 2:
			this.moveSquaresBackward(3);
			this.rotateRight();
			this.moveSquaresForward(0.5);
			this.rotateLeft();
			break;
		case 3:
			this.moveSquaresBackward(1);
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			break;
		case 4:
			this.moveSquaresBackward(2);
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			break;
		case 5:
			this.moveSquaresBackward(3);
			this.rotateRight();
			this.moveSquaresBackward(0.5);
			this.rotateLeft();
			break;
		case 6:
			this.moveSquaresBackward(1);
			this.rotateRight();
			this.moveSquaresBackward(1.5);
			this.rotateLeft();
			break;
		case 7:
			this.moveSquaresBackward(2);
			this.rotateRight();
			this.moveSquaresBackward(1.5);
			this.rotateLeft();
			break;
		case 8:
			this.moveSquaresBackward(3);
			this.rotateRight();
			this.moveSquaresBackward(1.5);
			this.rotateLeft();
			break;
		}
	}

	public void correctStartPosition(int deviation) {
		pilot.rotate(45);
		pilot.travel(14 * deviation);
		pilot.rotate(-45);
		pilot.travel(-10 * deviation);
	}

	public void drawX(int size) {
		pilot.rotate(45);
		pilot.travel(size);
		pilot.travel((size)*-0.5);
		pilot.rotate(90);
		pilot.travel((size)*-0.5);
		pilot.travel(size);
		pilot.travel((size)*-0.5);
		pilot.rotate(-45);
	}
	
}
