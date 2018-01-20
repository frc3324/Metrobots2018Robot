package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
//import org.metrobots.subsystems.*; //name of drivetrain subsystem
import org.metrobots.util.MetroController;
import org.metrobots.subsystems.DriveTrain;
import org.metrobots.Constants;

public class DriveTank extends Command {
	
	private MetroController gamepad;
	private DriveTrain drivetrain; 
	
	public DriveTank(MetroController gp, DriveTrain dt) {
		gamepad = gp;
	}

	protected void execute() {
		// TODO Auto-generated method stub
		//Add robot sensitivity
		double leftY = gamepad.getLeftY(); // Get y value of left joystick
		double rightX = gamepad.getRightX(); // Get x value of right joystick 
		
		if (Math.abs(leftY) < .2) {
			leftY = Math.pow(leftY, 3);
		}
		if (Math.abs(rightX) < .2) {
			rightX = Math.pow(rightX, 3);
		}
		
		
		double prevLeftSideSpeed = leftY + rightX; // Add the Y-value of the left joystick with the X-value of the right joystick
		double prevRightSideSpeed = leftY - rightX; // Subtract the Y-value of the left joystick with the X-value of the right joystick
		
		double leftSideSpeed = 0.0;
		double rightSideSpeed = 0.0;
		
		if (Math.abs(leftY) > Constants.AXIS_DEADBAND) {
			if (prevLeftSideSpeed > 1.0) {
				leftSideSpeed = 1.0;
				rightSideSpeed = 1.0/prevLeftSideSpeed * prevRightSideSpeed;
				
				if (gamepad.getRightTrigger() > 0.3) {
					leftSideSpeed = (leftSideSpeed * 0.5);
					rightSideSpeed = (rightSideSpeed * 0.5);
				}
				else {
					drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
				}
			}
			else {
				drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
			}
		}
		else {
			drivetrain.tankDrive(0.0, 0.0);
		}
		
		if (Math.abs(rightX) > Constants.AXIS_DEADBAND) {
			if (prevRightSideSpeed < -1.0) {
				rightSideSpeed = -1.0;
				leftSideSpeed = (-1.0/prevRightSideSpeed * prevLeftSideSpeed);
				
				if (gamepad.getRightTrigger() > 0.3) {
					leftSideSpeed = (leftSideSpeed * 0.5);
					rightSideSpeed = (rightSideSpeed * 0.5);
				}
				else {
					drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
				}
			}
			else {
				drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
			}
		}
		else {
			drivetrain.tankDrive(0.0, 0.0);		
		}
		/*if (leftSideSpeed > 1.0) {
			leftSideSpeed = (1.0/leftSideSpeed * leftSideSpeed);			//ADEQUATELY IMPRESSIVE, although it equals 1
			rightSideSpeed = (1.0/ * rightSideSpeed);		//AS IS THIS
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); 
		}
		else {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); // Setting speed for the left/right motors according to joystick input
		}
		
		if (rightSideSpeed < -1.0) { 
			rightSideSpeed = (-1.0/rightSideSpeed * rightSideSpeed); 
			leftSideSpeed = (-1.0/leftSideSpeed * leftSideSpeed);
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); 
		}
		else {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
		}
		
		if (leftY > Constants.UPPER_DEADBAND || leftY < Constants.LOWER_DEADBAND) {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); // Setting speed for the left/right motors according to joystick input
		}
		else {
			drivetrain.tankDrive(0.0, 0.0); //If the value is in the deadband, ignore it
		}
		
		if (rightX > Constants.UPPER_DEADBAND || rightX < Constants.LOWER_DEADBAND) {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
		}
		else {
			drivetrain.tankDrive(0.0, 0.0); //If the value is in the deadband, ignore it
		}
		
		if (gamepad.getRightTrigger() > 0.3) {
			
			leftSideSpeed = (leftSideSpeed * 0.5);
			rightSideSpeed = (rightSideSpeed * 0.5);
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
		}
		else {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed);
		} */
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
}