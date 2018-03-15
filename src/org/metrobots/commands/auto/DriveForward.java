package org.metrobots.commands.auto;

import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {

	double speed, currentDistance, distanceToTravel, LSpeed, RSpeed; //goalDistance
	double goalDistance = 0.0;
	double currentPulse = 0.0;
	
	boolean driveFinished = false;
	
	/**
	 * Measurement testing from 3/10/18
	 * Speed: 1.0 Set: 100 Received: 174 in
	Speed: 1.0 Set: 100 Received: 167 in
	Speed: 0.5 Set: 100 Received: 
	Speed: 1.0 Set: 60 Received: 110 in
	Speed: 1.0 Set: 60 Received: 118 in
	Speed: 1.0 Set: 60 Received: 111 in
	//minus 2ish inches
	Speed: 1.0 Set: 76.78 Received: 135 in Encoder distance: 76.3849
	Speed: 1.0 Set: 100 Received: 172 R: 0.95
	Speed: 1.0 Set: 100 Received: 169 R: 0.95
	Speed: 0.75 Set: 100 Received: 146 R: 0.9
	//minus 2ish inches
	Speed: 0.5 Set: 100 Received: 137
	Speed: 0.5 Set: 100 Received: 137
	Speed: 1.0 Set: 76.78 Received: 133.75
	 */
	
	/**
	 * Method for auto drive forward.<p>
	 * 
	 * Speed of motor, -1 to 1. Distance to be 
	 * traveled by robot in inches.
	 * @param speed
	 * @param distance
	 */
	public DriveForward(double distance) {
		//distance is equal to the circumference of the wheel times the amount of pulses = inches.
		goalDistance = distance;
	}
	
	@Override
	protected void initialize() {
//		currentDistance = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2;
//		Robot.mDriveTrain.setSafetyEnabled(false);
		DriveTrain.clearEncoder();
	}
	
	@Override
	protected void execute() {

//		distanceToTravel = goalDistance - currentDistance;
//		speed = distanceToTravel / goalDistance;
//		Smd artDashboard.putNumber("SPEED: ", speed);
//		//make speed negative to go forward in real lifes
//		Robot.mDriveTrain.arcadeDrive(-speed, 0.0, true);
		currentDistance = (Math.abs(Robot.mDriveTrain.getLeftDistance()) + Math.abs(Robot.mDriveTrain.getRightDistance())) / 2.0;
		SmartDashboard.putNumber("AVERAGE DRIVETRAIN PULSE1: ", currentDistance);
		SmartDashboard.putNumber("Right from robot encoder: ", Robot.mDriveTrain.getRightDistance());
		distanceToTravel = goalDistance - currentDistance;	
		SmartDashboard.putNumber("GOAL DISTANCE", distanceToTravel);
		
		if (distanceToTravel < 10) {
			speed = 0.5;
		} 
		else {
			speed = 1;
		}
		
		LSpeed = speed;
		RSpeed = speed * 0.96;
		SmartDashboard.putNumber("LSpeed", LSpeed);
		SmartDashboard.putNumber("RSpeed", RSpeed);
//		Robot.mPIDStabilzation.GyroStabilize(-speed);
		if (Math.abs(distanceToTravel) < 0.5) {
			driveFinished = true;
		}
		
		//make speed negative to go forward in real life
		Robot.mDriveTrain.tankDrive(-LSpeed, -RSpeed, true);
		
//		Robot.mDriveTrain.arcadeDrive(-0.4, 0.0, true);
		
	}
	
	@Override
	protected boolean isFinished() {
		return driveFinished;
//		currentDistance = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2.0);
//		if (distanceToTravel != goalDistance) {
//			return false;
//		} else {
//			return true;
//		}

//		currentDistance = (int) ((DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0);
//		currentPulse = (DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0;
//		if (Math.abs(speed) > 0.3) {
//			return false;
//		} else {
//			return true;
//		}
//		
//		speed = 0.75;
//		goalDistance = 60;
//		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
//		speed = pulsesToTravel / totalPulses;
//	
	}	

	
	protected void end() {
		Robot.mDriveTrain.tankDrive(0.0, 0.0, false);
	}
	@Override
	protected void interrupted() {}
	
}