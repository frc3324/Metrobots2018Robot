package org.metrobots.commands.teleop;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Winches extends Command {
	double winchMotorSpeed = -1.0;
    public Winches() {
    	requires(Robot.mClimber);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // executes like a guillotine
    //or the salem witch trials
    protected void execute() {
    	double currentPulseArm = Robot.mIntakeArm.getRawArm();
    	if (currentPulseArm < 45) {
    		Robot.mIntakeArm.armMovement(0.2);
    	} else {
    		Robot.mIntakeArm.armMovement(0.0);
    	}
    	Robot.mClimber.reelWinch(winchMotorSpeed);
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