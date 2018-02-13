package org.metrobots.commands;

import org.metrobots.Robot;
import org.metrobots.commands.teleop.ControlArm;
import org.metrobots.commands.teleop.DriveTank;
import org.metrobots.commands.teleop.PressureSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Group of commands that need to be run during teleop<br><br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 */
public class DriveGroup extends CommandGroup {
	
	/**
	 * Adds teleop commands to be run in parallel:<br>
	 * &emsp;DriveTank<br>
	 * &emsp;PressureSwitch<br>
	 * &emsp;MoveArm<br>
	 */
	public DriveGroup() {
		this.addParallel(new DriveTank());
		//this.addParallel(new PressureSwitch());
		this.addParallel(new ControlArm());
		//There is something wrong with the intakeArm or MoveArm class that make the robot not move and prints out "output not updated enough"
	}
	
}
