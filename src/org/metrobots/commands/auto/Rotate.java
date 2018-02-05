package org.metrobots.commands.auto;

import com.kauailabs.navx.frc.AHRS;

import  org.metrobots.Robot;
import	org.metrobots.subsystems.DriveTrain;
import org.metrobots.commands.teleop.DriveTank;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Rotate extends Command {
	
	
	private float specifiedAngle; //angle that robot should go to
	private double startTime, passedTime;
	private DriveTrain drivetrain; 
	
	AHRS navx;
	
	double leftSideSpeed, rightSideSpeed, speed;
	/**
	 * Rotates to the specified angle at the specified speed. 
	 * @param angle
	 * @param speed
	 */
	public Rotate(float angle, double speed) {
		this.speed = speed;
		specifiedAngle = angle;
		leftSideSpeed = speed;
		rightSideSpeed = speed; 
	}
	
	/**
	 * When the command starts, set current angle to zero 
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
			leftSideSpeed = angleDifference / -180;
			rightSideSpeed = angleDifference / 180;
		} else if (specifiedAngle > measuredAngle) {
			leftSideSpeed = angleDifference / -180;
			rightSideSpeed = angleDifference / 180;
		}
		if (Math.abs(measuredAngle) + (Math.abs(specifiedAngle)) > 180) {
			leftSideSpeed *= -1;
			rightSideSpeed *= -1; 
		}
		
		Robot.mDriveTrain.tankDrive(leftSideSpeed * speed, rightSideSpeed * speed);
	}

	/**
	 * When the current angle is equal to the specified angle, returns true. 
	 */
	@Override
	protected boolean isFinished() {
		double measuredAngle = navx.pidGet();
		double angleDifference = specifiedAngle - measuredAngle;
		if (Math.abs(angleDifference) > 5) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Does nothing after the current angle is equal to the specified angle.
	 */
	@Override
	protected void end() {
		Robot.mDriveTrain.tankDrive(0, 0);
	}
	/**
	 * Do nothing
	 */
	@Override
	protected void interrupted() {}

}
