package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.command.Command;
//import org.metrobots.subsystems.*; //name of drivetrain subsystem
import org.metrobots.util.MetroController;
import org.metrobots.subsystems.DriveTrain;

public class DriveTank extends Command {
	
	private MetroController gamepad;
	private DriveTrain drivetrain; 
	
	public DriveTank(MetroController gp) {
		gamepad = gp;
		
	}

	protected void execute() {
		// TODO Auto-generated method stub
		double leftY = gamepad.getLeftY(); // Get y value of left joystick
		double rightX = gamepad.getRightX(); // Get x value of right joystick 
		
		double leftSideSpeed = leftY + rightX; // Add the Y-value of the left joystick with the X-value of the right joystick
		double rightSideSpeed = leftY - rightX; // Subtract the Y-value of the left joystick with the X-value of the right joystick
		
		if (leftSideSpeed > 1) {
			leftSideSpeed = (1/leftSideSpeed * leftSideSpeed);
			rightSideSpeed = (1/rightSideSpeed * leftSideSpeed);
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); 
		}
		else {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); // Setting speed for the left/right motors according to joystick input
		}
		
		if (rightSideSpeed < -1) {
			rightSideSpeed = (1/rightSideSpeed * rightSideSpeed);
			leftSideSpeed = (1/leftSideSpeed * leftSideSpeed);
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); 
		}
		else {
			drivetrain.tankDrive(leftSideSpeed, rightSideSpeed); // Setting speed for the left/right motors according to joystick input
		}
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