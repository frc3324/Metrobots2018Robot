package org.metrobots.commands.auto;

import com.kauailabs.navx.frc.AHRS;

import  org.metrobots.Robot;
import	org.metrobots.subsystems.DriveTrain;
import org.metrobots.commands.teleop.DriveTank;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Rotate extends Command {
	
	
	private float specifiedAngle;
	private double startTime, passedTime;
	private DriveTrain drivetrain; 
	
	AHRS navx;
	
	/**
	 * Rotates to the specified angle at the specified speed. 
	 * @param angle
	 * @param speed
	 */
	public Rotate(float angle, double speed) {
		specifiedAngle = angle;  
	}
	
	/**
	 * Set current angle to zero 
	 */
	@Override
	protected void initialize() {
		navx.zeroYaw();
	}
	
	/**
	 * Rotate to specified angle (from current angle), at specified speed. 
	 */
	@Override
	protected void execute() {
		double measuredAngle = navx.pidGet();
		double angleDifference = specifiedAngle - measuredAngle;
		
		if (measuredAngle > specifiedAngle) {
			/*leftSideSpeed = angleDifference / 180;
			rightSideSpeed = angleDifference / 180;*/
		}
		
		//speed = angleDifference / 180;
		
		//leftSideSpeed = x;
		//rightSideSpeed = -x; 
		
		//drivetrain.tankDrive(leftSpeed, rightSpeed);
	}

	/**
	 * When the current angle is equal to the specified angle, returns true. 
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	/**
	 * Does nothing after the current angle is equal to the specified angle.
	 */
	@Override
	protected void end() {}
	
	/**
	 * Do nothing
	 */
	@Override
	protected void interrupted() {}

}
