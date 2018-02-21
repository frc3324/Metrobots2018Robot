package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.metrobots.subsystems.*; //name of drivetrain subsystem
import org.metrobots.util.MetroController;
import org.metrobots.subsystems.DriveTrain;
import org.metrobots.Constants;
import org.metrobots.OI;
import org.metrobots.Robot;

public class DriveTank extends Command {
	
	XboxController gamepad0 = new XboxController(0);
	
	public DriveTank() {
		requires(Robot.mDriveTrain);
	}

	protected void execute() {
		// TODO Auto-generated method stub
		//Add robot sensitivity
		Robot.mDriveTrain.printEncoder();
		double leftY = gamepad0.getY(Hand.kLeft); // Get y value of left joystick
		double rightX = gamepad0.getX(Hand.kRight); // Get x value of right joystick 
		
		SmartDashboard.putNumber("RightX", rightX);
		
		
		//System.out.println("LEFTY: " + leftY + " RIGHTX: " + rightX);
		//System.out.println("LeftY: " + leftY);
		//System.out.println("RightX: " + rightX);
//		if (Math.abs(leftY) < .2) { // If the Y-axis of the left axis is below 0.2, cube it, reducing the sensitivity when it's below 0.2
//			leftY = 25 * Math.pow(leftY, 3);
//		}

//		if (Math.abs(rightX) < .2) {
//			rightX = 25 * Math.pow(rightX, 3); // repeat for the x-value on the right side 
//		}
		
		/*double leftSideSpeed = leftY - rightX; // Add the Y-value of the left joystick with the X-value of the right joystick
		double rightSideSpeed = leftY + rightX; // Subtract the Y-value of the left joystick with the X-value of the right joystick*/
		//System.out.println("Prevleftspeed: " + prevLeftSideSpeed);

		/*if (Math.abs(leftSideSpeed) > 1.0) {
			double reciprocal = 1.0 / leftSideSpeed;
			leftSideSpeed *= reciprocal;
			rightSideSpeed *= reciprocal;
		}	
		if (Math.abs(rightSideSpeed) > 1.0) {
			double reciprocal = 1.0 / rightSideSpeed;
			rightSideSpeed *= reciprocal;
			leftSideSpeed *= reciprocal; 
		}*/
//		if (leftY > 0) {
//			rightX = -rightX;
//		}
		//DriverStation.reportError("A before: " + rightX, false);
//	if (gamepad.getXButtonPressed()) {
////			DriverStation.reportError("A after: " + rightX, false);
//			leftY = leftY * 0.5;
//			rightX = rightX * 0.5;
//		}
		//Robot.mDriveTrain.printEncoder();
		//leftY = leftY * 0.1;
//		leftY *= 0.975;
		//rightY *= 1;
//		leftY *= 0.55;
//		rightX *= 0.55;
		Robot.mDriveTrain.arcadeDrive(leftY, -rightX, true);
		//Robot.mDriveTrain.arcadeDrive(leftY, rightX, true);
	//	DriverStation.reportError(", printTrace);
		//Robot.mDriveTrain.printEncoder();
		//DriverStation.reportError("something", false);
	}
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
//		DriveTrain.clearEncoder();
	
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
