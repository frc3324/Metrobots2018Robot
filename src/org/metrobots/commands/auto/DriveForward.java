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

public class DriveForward extends Command {

	double speed, currentDistance, distanceToTravel, LSpeed, RSpeed; //goalDistance
	double goalDistance = 0.0;
	double currentPulse = 0.0;
	
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
		DriveTrain.clearEncoder();
	}
	
	@Override
	protected void execute() {
		speed = 0.75;
//		goalDistance = 60;
//		currentPulse = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2.0;
		currentPulse = (DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0;
		SmartDashboard.putNumber("AVERAGE PULSE: ", currentPulse);
//		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
//		speed = pulsesToTravel / totalPulses;
		SmartDashboard.putNumber("goalDistance", goalDistance);
		distanceToTravel = goalDistance - currentPulse;
		if (Math.abs(distanceToTravel / goalDistance) < 0.35) {
			speed = distanceToTravel / goalDistance;
		}
		LSpeed = speed;
		RSpeed = speed * 0.95;
		SmartDashboard.putNumber("SPEED: ", speed);
		//make speed negative to go forward in real life
		Robot.mDriveTrain.tankDrive(LSpeed, RSpeed, true);
	}	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		currentDistance = (int) ((DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0);
		currentPulse = (DriveTrain.getLeftDistance() - DriveTrain.getRightDistance()) / 2.0;
		if (Math.abs(speed) > 0.3) {
			return false;
		} else {
			return true;
		}
//		return false;
		
	}
	
	@Override
	protected void interrupted() {}
	
}