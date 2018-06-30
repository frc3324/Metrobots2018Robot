package org.metrobots.commands.auto;

import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {

	double finalSpeed, currentSpeed, currentDistance, distanceToTravel, LSpeed, RSpeed; //goalDistance
	double goalDistance = 0.0;
	
	boolean driveFinished = false;

	
	/**
	 * Method for auto drive forward.<p>
	 * 
	 * Distance to be traveled by robot.
	 * Speed of motor, -1 to 1. 
	 * @param distance
	 * @param speed
	 */
	public DriveForward(double distance, double speed) {
		//distance is equal to the circumference of the wheel times the amount of pulses = inches.
		goalDistance = distance;
		currentSpeed = speed; 
		
	}
	
	@Override
	protected void initialize() {
		DriveTrain.clearEncoder();
	}
	
	@Override
	protected void execute() {
		currentDistance = (Math.abs(DriveTrain.getLeftDistance()) + Math.abs(DriveTrain.getRightDistance())) / 2.0;
		SmartDashboard.putNumber("AVERAGE DRIVETRAIN PULSE1: ", currentDistance);
		distanceToTravel = goalDistance - currentDistance;	
		SmartDashboard.putNumber("GOAL DISTANCE", distanceToTravel);
		
		if (distanceToTravel < 10) {
			finalSpeed = -0.4 * currentSpeed;
		} 
		else {
			finalSpeed = -1 * currentSpeed;
		}
		
		LSpeed = finalSpeed;
		RSpeed = finalSpeed;
		if (Math.abs(distanceToTravel) < 1) { //0.5
			driveFinished = true;
		}
		
		//make speed negative to go forward in real life
		Robot.mDriveTrain.tankDrive(LSpeed, RSpeed, false);
		SmartDashboard.putNumber("Gyro!!!!", Robot.mGyro.getPidAngle());

	}
	
	@Override
	protected boolean isFinished() {
		return driveFinished;

	}	

	
	protected void end() {
		Robot.mDriveTrain.tankDrive(0.0, 0.0, false);
	}
	@Override
	protected void interrupted() {}
	
}