package org.metrobots.commands.teleop;

import org.metrobots.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Winches extends Command {
	
    public Winches() {
    	requires(Robot.mClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // executes like a guillotine
    //or the salem witch trials
    protected void execute() {
    	Robot.mClimber.reelWinch(-1.0);
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