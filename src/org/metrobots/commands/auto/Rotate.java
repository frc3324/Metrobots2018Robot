package org.metrobots.commands.auto;

import com.kauailabs.navx.frc.AHRS;

import org.metrobots.Constants;
import  org.metrobots.Robot;
import	org.metrobots.subsystems.DriveTrain;
import org.metrobots.commands.teleop.DriveTank;

import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {
	
	
	private float specifiedAngle; //angle that robot should go to
	private double startTime, passedTime;
	private DriveTrain drivetrain;
	double speed;
	
	AHRS navx;
	
	/**
	 * Rotates to the specified angle at the specified speed. 
	 * @param angle
	 * @param speed
	 */
	public Rotate(float angle, double speed) {
		specifiedAngle = angle;  
		this.speed = speed;
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
	protected void execute() {
        double measuredAngle = navx.pidGet();    
//        SmartDashboard.putNumber("Gyro", measuredAngle);
        double runningSpeed = 0.0;
        
        if (measuredAngle > specifiedAngle) {
            /*leftSideSpeed = angleDifference / 180;
            rightSideSpeed = angleDifference / 180;*/
            runningSpeed = -speed;
        } else if (specifiedAngle > measuredAngle) {
            runningSpeed = speed;
        }
        if ((Math.abs(specifiedAngle)+Math.abs(measuredAngle)) > 180) {
            runningSpeed *= -1;
        }
        
        //runningSpeed = angleDifference / 180;
        Robot.mDriveTrain.tankDrive(runningSpeed, -runningSpeed, true);
        
        
        //drivetrain.tankDrive(leftSpeed, rightSpeed);
    }

    /**
     * When the current angle is equal to the specified angle, returns true. 
     */
    @Override
    protected boolean isFinished() {
        if (Math.abs(navx.pidGet()-specifiedAngle) <= Constants.AUTO_ROTATE_ANGLE_THRESHOLD) {
            return true;
        } else {
            return false;
        }
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
