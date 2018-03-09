package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.metrobots.OI;
import org.metrobots.Robot;

public class DriveTank extends Command {
	
	boolean slowModeActivated = false;
	boolean isTurning;
	double turnRate;
	public DriveTank() {
		requires(Robot.mDriveTrain);
	}

	protected void execute() {
//		// TODO Auto-generated method stub
//		//Add robot sensitivity
		Robot.mDriveTrain.printEncoder();
		double leftY = OI.get0LeftY(); // Get y value of left joystick
		double rightX = OI.get0RightX(); // Get x value of right joystick 
		
		SmartDashboard.putNumber("RightX", rightX);
		SmartDashboard.putNumber("LeftY", leftY);
		if (Math.abs(rightX) < 0.05) {
			Robot.mPIDStabilzation.GyroStabilize(leftY);
		} else if (Math.abs(rightX) > 0) {
			Robot.mDriveTrain.arcadeDrive(leftY, -rightX, true);
			Robot.mPIDStabilzation.turnControllerDisable();
		}
	
		if (OI.get0RightBumperToggled()) {
			slowModeActivated = !slowModeActivated;
		}
		
		if (slowModeActivated) {
			leftY *= 0.5;
		}
		DriverStation.reportError("LEFTY: "  + leftY, true);
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
