package org.metrobots.commands.teleop;

import org.metrobots.OI;
import org.metrobots.subsystems.Climber;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class Winches extends Command {

	Climber mClimber = new Climber();
	double winchSpeed = 0.0;
	XboxController gamepad1 = new XboxController(1);
	
    public Winches() {
    	requires(mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // executes like a guillotine
    //or the salem witch trials
    protected void execute() {
    	if (gamepad1.getXButton()) {
    		winchSpeed = -1.0;
    	}
//    	else if (gamepad1.getYButton()){
//    		winchSpeed = 1.0;
//    	}
    	else {
    		winchSpeed = 0.0;
    	}
    	mClimber.reelWinch(winchSpeed);
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