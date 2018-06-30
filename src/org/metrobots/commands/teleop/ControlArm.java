package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.OI;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Moves the intake arm from forward to backward with the press of a button.
 * The button acts as a toggle.
 * 
 */
public class ControlArm extends Command {
	boolean finished = false;
	int number = 0;

	boolean startPosition = true; //Assumes arm in starting position at match start
	double goalPulse = 0.0;
	double armSpeed = 0.0;
	
	boolean pastSwitch = false;

	/**
	 * Move the arm to its opposite position when called. <p>
	 */
    public ControlArm() {
    	requires(Robot.mIntakeArm);
    }

    /*
     * Arm should be set to starting position.
     */	
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * voltage to motor speed
     * 
     */
    protected void execute() {


    	double currentPulse = Robot.mIntakeArm.getRawArm();

		SmartDashboard.putNumber("CURRENTPULSE", currentPulse);

    	double leftY = OI.get1LeftYAxis();

    	DriverStation.reportError("X AXIS" + leftY, false);

    	Robot.mIntakeArm.armMovement(leftY);

    	double joystickCurrentPulse = Robot.mIntakeArm.getRawArm();

    	SmartDashboard.putNumber("CURRENTPULSE: ", joystickCurrentPulse);

     /**
      * Variables for moving the arm.
      * 
      * goalPulse is the specified pulse value from the encoders. Since there are six positions (full forward, switch forward, scale forward,
      * scale backward, switch backward, full backward), there will be six different goalPulses.
      * Note: The numbers for these ARE ARBITRARY and just happen to look like angles (but they will resemble the numbers eventually).
      * 
      * currentPulse is the pulse value that arm is at.
      * 
      * maxPulse is the maximum value able to be received from the encoders, assuming one end is 0.0 and there are no negative numbers.
      * 
      * armSpeed is the speed to set the arm motor to based on the code below.
      * 
      * differencePulse is the amount of pulses to travel in order to reach goalPulse.
      * 
      * state is whether the arm should be moving forward or backward to reach goalPulse. True if going toward front of robot, false if 
      * going backward.
      */
   

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return finished; 
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
