package org.metrobots.commands;

import org.metrobots.OI;
import org.metrobots.Robot;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.groups.LLeft;
import org.metrobots.commands.auto.groups.LMiddle;
import org.metrobots.commands.auto.groups.LRight;
import org.metrobots.commands.auto.groups.RLeft;
import org.metrobots.commands.auto.groups.RMiddle;
import org.metrobots.commands.auto.groups.RRight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Command for translating FMS input (in form of three letters as an L or R).
 * Also determined by the button pressed on the primary driver controller for driverstation position.
 */
public class AutoConfiguration extends Command {
	
	LLeft LLeft = new LLeft();
	LMiddle LMiddle = new LMiddle();
	LRight LRight = new LRight();
	RLeft RLeft = new RLeft();
	RMiddle RMiddle = new RMiddle();
	RRight RRight = new RRight();
	
	Command selectedCommand;
	
	int defaultSet = 0;
	int left = 1;
	int middle = 2;
	int right = 3;
	
	int aValue = 0;
	
	String autoSet = "";
	String gameData;
	
	boolean finished;
	
	SendableChooser<Integer> autoSelector = new SendableChooser<Integer>();

    public AutoConfiguration() {
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	
    	SmartDashboard.putString("Game Data:", gameData);
//    	SmartDashboard.putString("What driverstation position are you in?", null);
    	
    	autoSelector.addDefault("Default", defaultSet);
    	autoSelector.addObject("Left position", left);
    	autoSelector.addObject("Middle position", middle);
    	autoSelector.addObject("Right position", right);
    	
    	SmartDashboard.putData("Autonomous selector", autoSelector);
    	
//		while (!isInitPosSet) {
//			SmartDashboard.putString("Dr. B", "in the loop");
//			SmartDashboard.putString("Initial Position", "N/A");
//			if (OI.isXPressed()) {
//				SmartDashboard.putString("Initial Position", "Left");
//				isInitPosSet = !isInitPosSet;
//			}
//		}
		if (autoSelector.getSelected() == 0) {
			selectedCommand = new DriveForward(10);
			finished = false;
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == left) {
			SmartDashboard.putString("You selected LLeft!", "");
//			Scheduler.getInstance().add(new LLeft());
			selectedCommand = new LLeft();
			finished = true;
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == middle) {
			SmartDashboard.putString("You selected LMiddle!", "");
//			Scheduler.getInstance().add(new LMiddle());
			selectedCommand = new LMiddle();
			finished = true;
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == right) {
			SmartDashboard.putString("You selected LRight!", "");
//			Scheduler.getInstance().add(new LRight());
			selectedCommand = new LRight();
			finished = true;
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == left) {
			SmartDashboard.putString("You selected RLeft!", "");
//			Scheduler.getInstance().add(new RLeft());
			selectedCommand = new RLeft();
			finished = true;
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == middle) {
			SmartDashboard.putString("You selected RMiddle!", "");
//			Scheduler.getInstance().add(new RMiddle());
			selectedCommand = new RMiddle();
			finished = true;
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == right) {
			SmartDashboard.putString("You selected RRight!", "");
//			Scheduler.getInstance().add(new RRight());
			selectedCommand = new RRight();
			finished = true;
		}
		DriverStation.reportError("Selected" + autoSelector.getSelected(), false);
//		else if (gameData == null || autoSelector.getSelected() == null) {
//			selectedCommand = new DriveForward(192);
//			finished = false;
//		}
		
    }
//		if (OI.is0XPressed()) {		//left side on the field
//			DriverStation.reportError("You pressed X", true);
//			if (autoSet == "R") {
//				Scheduler.getInstance().add(new RLeft());
//			}
//		
//			else if (autoSet == "L") {
//				Scheduler.getInstance().add(new LLeft());
//			}
//		}
//		
//		else if (OI.is0YPressed()) {	//middle side on the field
//			DriverStation.reportError("You pressed Y", true);
//			if (autoSet == "R")	{
//				Scheduler.getInstance().add(new RMiddle());
//			}
//			else if(autoSet == "L") {
//				Scheduler.getInstance().add(new LMiddle());
//			}
//		}
//		
//		else if (OI.is0BPressed()) {	//right side of the field
//			DriverStation.reportError("You pressed B", true);
//			if (autoSet == "R")	{
//				Scheduler.getInstance().add(new RRight());
//			}
//			else if(autoSet == "L")	{
//				Scheduler.getInstance().add(new LRight());
//			}
//		}
//    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
    
    public Command getAutoCommand() {
    	return selectedCommand;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
