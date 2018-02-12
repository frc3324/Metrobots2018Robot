package org.metrobots.commands;

import org.metrobots.commands.auto.groups.LLLeft;
import org.metrobots.commands.auto.groups.LLMiddle;
import org.metrobots.commands.auto.groups.LLRight;
import org.metrobots.commands.auto.groups.RLLeft;
import org.metrobots.commands.auto.groups.RLMiddle;
import org.metrobots.commands.auto.groups.RLRight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;

public class AutoConfiguration {
	
	public String autoType = "";
	
	XboxController gamepad0 = new XboxController(0);
	
	public AutoConfiguration() {
	
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		String autoSet;
		
		if (gameData.charAt(0) == 'L') {
			//left auto code
			autoSet = "L";
		} 
		else {
			autoSet = "R";
		}
	
		if (autoSet == "R" || autoSet == "L") {
			System.out.println("X Button if the robot is on the left side, A for middle, B for right.");
		}
		
		if (gamepad0.getXButtonPressed()) {		//left side on the field
			if (autoSet == "R") {
				Scheduler.getInstance().add(new RLLeft());
			}
		
			else if (autoSet == "L") {
				Scheduler.getInstance().add(new LLLeft());
			}
		}
		
		else if (gamepad0.getAButtonPressed()) {	//middle side on the field
			if (autoSet == "R")	{
				Scheduler.getInstance().add(new RLMiddle());
			}
			else if(autoSet == "L") {
				Scheduler.getInstance().add(new LLMiddle());
			}
		}
		
		else if (gamepad0.getBButtonPressed()) {	//right side of the field
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
}
