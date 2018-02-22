package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
<<<<<<< HEAD:src/org/metrobots/commands/teleop/IntakeTeleop.java
public class IntakeTeleop extends Command {
	
=======
public class Intake extends Command {
		
>>>>>>> origin/master:src/org/metrobots/commands/teleop/Intake.java
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
<<<<<<< HEAD:src/org/metrobots/commands/teleop/IntakeTeleop.java
    	Robot.mCubeController.intake(Constants.intakeMotorSpeed);
=======
	    	Robot.mCubeController.intake(1.0);
>>>>>>> origin/master:src/org/metrobots/commands/teleop/Intake.java
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
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
