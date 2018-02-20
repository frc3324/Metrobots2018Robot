package org.metrobots.commands.auto;

import com.kauailabs.navx.frc.AHRS;

import org.metrobots.Constants;
import  org.metrobots.Robot;
import	org.metrobots.subsystems.DriveTrain;
import org.metrobots.commands.teleop.DriveTank;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {
	
	
	private double specifiedAngle = 0; //angle that robot should go to
	private double startTime, passedTime;
	private double runningSpeed = 0.0;
	private double angleToTravel;
	private static final double speed = 0.5;
	private boolean isInitialized;
	private boolean isDone = false;
	private int count = 0;
	/**
	 * Rotates to the specified angle at the specified speed. 
	 * @param angle
	 * @param speed
	 */
	public Rotate(double angle) {
		requires(Robot.mDriveTrain);
		requires(Robot.mGyro);
		specifiedAngle = angle;
	}
	
	/**
	 * When the command starts, set current angle to zero 
	 */
	@Override
	protected void initialize() {
	}
	
	/**
	 * Rotate to specified angle (from current angle), at specified speed. 
	 */
	protected void execute() {
//		isDone = false;
//		SmartDashboard.putBoolean("Initialized?", true);
		DriverStation.reportError("Initialized ", true);
		double measuredAngle = Robot.mGyro.getPidAngle();
        SmartDashboard.putNumber("Gyro", measuredAngle);
        angleToTravel = Math.abs(specifiedAngle) - Math.abs(measuredAngle);
        SmartDashboard.putNumber("angle to travel:", angleToTravel);
//		speed = angleToTravel / specifiedAngle;
        if (measuredAngle > specifiedAngle) {
            /*leftSideSpeed = angleDifference / 180;
            rightSideSpeed = angleDifference / 180;*/
            runningSpeed = -speed;
        } else if (specifiedAngle > measuredAngle) {
            runningSpeed = speed;
        }
        if (angleToTravel < Constants.AUTO_ROTATE_ANGLE_THRESHOLD ) {
        	runningSpeed = 0;
        	isDone = true;
        }
    	SmartDashboard.putBoolean("Is turn over?", isDone);
        SmartDashboard.putNumber("RunningSpeed:", runningSpeed);
        Robot.mDriveTrain.tankDrive(runningSpeed, -runningSpeed, false);
        SmartDashboard.putNumber("Turning", count);
        count++;
        //drivetrain.tankDrive(leftSpeed, rightSpeed);
    }

    /**
     * When the current angle is equal to the specified angle, returns true. 
     */
    @Override
    protected boolean isFinished() {
        return isDone;
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
