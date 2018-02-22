package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OuttakeTeleop extends Command {
	
	/**
	 * Spin wheels outward. <p>
	 */
    public OuttakeTeleop() {
    	requires(Robot.mCubeController);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mCubeController.intake(Constants.outtakeMotorSpeed);
  
    }
    
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
