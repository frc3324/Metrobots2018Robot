package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.OI;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeTeleop extends Command {
	boolean isOn = false;
	private double inSpeed;
	
	/**
	 * Spin wheels inward. <p>
	 */
    public IntakeTeleop() {
    	requires(Robot.mCubeController);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//	    Robot.mCubeController.intake(-0.2);
    
	    
    //  
    //protected void execute() {
//    	if (OI.is1LeftBumperPressed()) {
//    		if (isOn = false) {
//    			motorSpeed = -1.0;
//    			isOn = true;
//    		} else {
//        		motorSpeed = 0.0;	
//        		isOn = false;
//    		}    
//    	 Robot.mCubeController.intake(motorSpeed);
//    	}

    	DriverStation.reportError("bah!!", false);
    	if (OI.is1RightBumperPressed()) {
    		inSpeed = -0.2;
    	}
    	else {
    		inSpeed = 0.0;
    	}
    	Robot.mCubeController.intake(inSpeed);
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.mCubeController.intake(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.mCubeController.intake(0.0);
    	
    }
}
