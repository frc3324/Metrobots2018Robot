package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.XboxController;

import org.metrobots.OI;
import org.metrobots.subsystems.Climber;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
public class ClimberSlideDown extends Command {
	XboxController gamepad1 = new XboxController(1);
	Climber mClimber = new Climber();
	
    public ClimberSlideDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	mClimber.grabBar(-1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
//    	if (gamepad1.getBButton()) {
//    		mClimber.grabBar(-1.0);
//    	}
//    	else {
//    		mClimber.grabBar(0.0);
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
