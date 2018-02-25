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
		Robot.mDriveTrain.setSafetyEnabled(false);
		DriveTrain.clearEncoder();
	}
	
	@Override
	protected void execute() {
//		goalDistance = 10; 
//		double currentPulse = 0.0;
//		currentPulse = mTrain.getLeftDistance();
//		SmartDashboard.putNumber("STRING", currentPulse);
////		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
////		speed = pulsesToTravel / totalPulses;
//		SmartDashboard.putNumber("goalDistance", goalDistance);
//		distanceToTravel = goalDistance - currentDistance;
//		speed = distanceToTravel / goalDistance;
//		SmartDashboard.putNumber("SPEED: ", speed);
//		//make speed negative to go forward in real life
//		Robot.mDriveTrain.arcadeDrive(-speed, 0.0, true);
		currentDistance = (DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0;
		SmartDashboard.putNumber("AVERAGE DRIVETRAIN PULSE: ", currentPulse);
		distanceToTravel = goalDistance - currentDistance;
		if (Math.abs(distanceToTravel / goalDistance) < 0.35) {
			speed = distanceToTravel / goalDistance;
		}
		LSpeed = speed;
		RSpeed = speed * 0.95;
		if (Math.abs(distanceToTravel) < 1) {
			driveFinished = true;
		}
		//make speed negative to go forward in real life
		Robot.mDriveTrain.tankDrive(LSpeed, RSpeed, true);
		
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

	@Override
	protected void interrupted() {}
	
}