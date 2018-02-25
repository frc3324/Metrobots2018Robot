package org.metrobots.commands.auto;

import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command {
	
	double speed, currentDistance, distanceToTravel; //goalDistance
	double goalDistance = 0.0;
	
	/**
	 * Method for auto drive forward.<p>
	 * 
	 * Speed of motor, -1 to 1. Distance to be 
	 * traveled by robot in inches.
	 * @param speed
	 * @param distance
	 */
	public DriveForward(double goalDistance) {
		//distance is equal to the circumference of the wheel times the amount of pulses = inches.
		this.goalDistance = goalDistance;
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
		currentDistance = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2.0;
		distanceToTravel = goalDistance - currentDistance;
		
		Robot.mDriveTrain.arcadeDrive(-0.4, 0.0, true);
		
	}
	
	@Override
	protected boolean isFinished() {
//		currentDistance = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2.0);
//		if (distanceToTravel != goalDistance) {
//			return false;
//		} else {
//			return true;
//		}
		return false;
		
	}
	
	@Override
	protected void interrupted() {}
	
}
