package org.metrobots.commands.auto;

import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{
	double speed, distance, startingLocation, currentLocation;
	
	
	
	public DriveForward(double speed, double distance) {
		this.speed = speed;
		this.distance = distance;
	}

	@Override
	protected void execute() {
		Robot.mDriveTrain.tankDrive(speed, speed, true);
	}
	
	@Override
	protected void initialize() {
		startingLocation = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2);
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		currentLocation = (int) ((DriveTrain.getLeftDistance() + DriveTrain.getRightDistance()) / 2);
		if ((currentLocation - startingLocation) < distance) {
			return false;
		} else {
			return true;
		}
		
	}
	
}
