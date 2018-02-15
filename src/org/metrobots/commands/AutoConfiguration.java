package org.metrobots.commands;

import org.metrobots.OI;
import org.metrobots.Robot;
import org.metrobots.commands.auto.groups.LLLeft;
import org.metrobots.commands.auto.groups.LLMiddle;
import org.metrobots.commands.auto.groups.LLRight;
import org.metrobots.commands.auto.groups.RLLeft;
import org.metrobots.commands.auto.groups.RLMiddle;
import org.metrobots.commands.auto.groups.RLRight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command for translating FMS input (in form of three letters as an L or R).
 * Also determined by the button pressed on the primary driver controller for driverstation position.
 */
public class AutoConfiguration extends Command {
private boolean isInitPosSet = false;
	
	String autoSet = "";
	
    public AutoConfiguration() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation.reportError("You have reached the beginning of execute in autoconfig", true);
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
//		while (!isInitPosSet) {
//			SmartDashboard.putString("Dr. B", "in the loop");
//			SmartDashboard.putString("Initial Position", "N/A");
//			if (OI.isXPressed()) {
//				SmartDashboard.putString("Initial Position", "Left");
//				isInitPosSet = !isInitPosSet;
//			}
//		}
//		SmartDashboard.putString("Dr. B", "You are out of the loop");
		if (gameData.charAt(0) == 'L') {
			//left auto code
			autoSet = "L";
		} 
		else {
			autoSet = "R";
		}
		
		if (OI.is0XPressed()) {		//left side on the field
			DriverStation.reportError("You pressed X", true);
			if (autoSet == "R") {
				Scheduler.getInstance().add(new RLLeft());
			}
		
			else if (autoSet == "L") {
				Scheduler.getInstance().add(new LLLeft());
			}
		}
		
		else if (OI.is0YPressed()) {	//middle side on the field
			DriverStation.reportError("You pressed Y", true);
			if (autoSet == "R")	{
				Scheduler.getInstance().add(new RLMiddle());
			}
			else if(autoSet == "L") {
				Scheduler.getInstance().add(new LLMiddle());
			}
		}
		
		else if (OI.is0BPressed()) {	//right side of the field
			DriverStation.reportError("You pressed B", true);
			if (autoSet == "R")	{
				Scheduler.getInstance().add(new RLRight());
			}
			else if(autoSet == "L")	{
				Scheduler.getInstance().add(new LLRight());
			}
		}
		
		else {
			
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.isAuto;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
