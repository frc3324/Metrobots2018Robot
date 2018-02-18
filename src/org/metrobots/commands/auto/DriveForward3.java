package org.metrobots.commands.auto;

import org.metrobots.Constants;
import org.metrobots.Robot;
import org.metrobots.commands.auto.groups.LLeft;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;

public class DriveForward3 extends Command {

	DriveTrain mTrain = new DriveTrain();
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
	public DriveForward3(double distance) {
		distance = 0.0;
		//distance is equal to the circumference of the wheel times the amount of pulses = inches.
	}
	
	@Override
	protected void initialize() {
//		currentDistance = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2;
		mTrain.setSafetyEnabled(false);
		mTrain.clearEncoder();
	}
	
	@Override
	protected void execute() {
		goalDistance = 30; 
		double currentPulse = 0.0;
		currentPulse = mTrain.getLeftDistance();
		SmartDashboard.putNumber("STRING", currentPulse);
//		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
//		speed = pulsesToTravel / totalPulses;
		SmartDashboard.putNumber("goalDistance", goalDistance);
		distanceToTravel = goalDistance - currentDistance;
		speed = distanceToTravel / goalDistance;
		SmartDashboard.putNumber("SPEED: ", speed);
		//make speed negative to go forward in real life
		Robot.mDriveTrain.arcadeDrive(-speed, 0.0, true);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
