package org.metrobots.commands.auto;

import org.metrobots.Constants;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CubeControl extends Command {

	double cubeSpeed;
	
	/**
	 * Spin wheels inward. <p>
	 * Set a positive number to intake, a negative number to outtake.
	 */
    public CubeControl(double speed) {
    	cubeSpeed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mCubeController.intake(cubeSpeed); //was -0.6
//	    Robot.mCubeController.intake(1.0);
    }
	    
    //  
    //protected void execute() {
//    	if (gamepad1.getBumperPressed(Hand.kRight)) {
////    		if (isOn = false) {
//    			motorSpeed = -1;
////    			isOn = true;
////    		} else {
////        		motorSpeed = 0;	
////        		isOn = false;
//    		}    
//    	 mCubeController.intake(motorSpeed);
//    }
// 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
