package org.metrobots.commands;

import org.metrobots.Robot;
import org.metrobots.commands.teleop.ClimberSlide;
import org.metrobots.commands.teleop.ControlArm;
import org.metrobots.commands.teleop.DriveTank;
import org.metrobots.commands.teleop.Intake;
import org.metrobots.commands.teleop.Outtake;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.commands.teleop.Winches;

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
	 * &emsp;ControlArm<br>
	 */
	//Set ControlArm and ClimberSlide to different controls
	public DriveGroup() {
		this.addParallel(new DriveTank()); //gamepad0, joysticks
		this.addParallel(new PressureSwitch()); //gamepad0, a button
//		this.addParallel(new ControlArm()); //gamepad1, left joystick
		this.addParallel(new Intake()); //gamepad1, left bumper
		this.addParallel(new Outtake()); //gamepad1, right bumper
		this.addParallel(new ClimberSlide()); //gamepad1, a button and b button //a and x
		this.addParallel(new Winches()); //gamepad1, x button // b button
		//There is something wrong with the intakeArm or MoveArm class that make the robot not move and prints out "output not updated enough"
	}
	
}
