package org.metrobots.commands.teleop;

import edu.wpi.first.wpilibj.XboxController;

import org.metrobots.OI;
import org.metrobots.subsystems.Climber;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
public class ClimberSlide extends Command {
	XboxController gamepad1 = new XboxController(1);
	Climber mClimber = new Climber();
	
    public ClimberSlide() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//		double slideSpeed = gamepad.getY(Hand.kLeft); // Get y value of left joystick
    	double slideSpeed = 0.0;
    	
		if (gamepad1.getAButton()) {
			slideSpeed = 1.0;
		}
		else if (gamepad1.getBButton()) {
			slideSpeed = -1.0;
		}
		else {
			
		}
		mClimber.grabBar(slideSpeed);
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
