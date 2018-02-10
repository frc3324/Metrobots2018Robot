package org.metrobots.commands.auto;

import org.metrobots.Constants;
import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;

public class DriveForward extends Command{

	double distance, speed, currentDistance, goalDistance, distanceToTravel;
	
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
		this.distance = goalDistance;
	}
	
	@Override
	protected void initialize() {
		currentDistance = (DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2;
	}
	
	@Override
	protected void execute() {
//		pulsesToTravel = distance * (Constants.CIRCUMFERENCE / Constants.PULSES);
//		speed = pulsesToTravel / totalPulses;
		distanceToTravel = goalDistance - currentDistance;
		speed = distanceToTravel / goalDistance;
		Robot.mDriveTrain.tankDrive(speed, speed, true);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		currentDistance = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2);
		if (distanceToTravel != goalDistance) {
			return false;
		} else {
			return true;
		}
		
	}
	
	@Override
	protected void interrupted() {}
	
}
