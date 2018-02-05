package org.metrobots.commands.teleop;

import org.metrobots.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO
 * Add the switch/scale code.
 */
public class MoveArm extends Command {

	public IntakeArm mIntakeArm = new IntakeArm();
	Encoder leftEncoder;
	Encoder rightEncoder;
	boolean finished = false;
	
	boolean startPosition = true; //Assumes arm in starting position at match start
	
	/**
	 * Move the arm to its opposite position when called. <p>
	 */
    public MoveArm() {
    	requires(mIntakeArm);
    }

    /*
     * Encoders reset to 0.0.
     * Arm should be set to starting position.
     */
    protected void initialize() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * voltage to motor speed
     * 
     */
    protected void execute() {
    	double armSpeed;
    	double currentPosition = 0.0;
    	double maxPulse = 60.0;
    	
    	if (leftEncoder.getDirection() == false && rightEncoder.getDirection() == false) { //meaning arm in position 0.0 and moving forward
    		currentPosition = ((Math.abs(leftEncoder.getDistance()) - maxPulse) + (Math.abs(rightEncoder.getDistance())) - maxPulse) / 2.0; //Average distance in degrees from encoders, scaled from distancePerPulse
    		//motors will move at most speed 1 (forwards), but that can be changed if needed
    		if (currentPosition == maxPulse) {
    			finished = true;
    		}
    	}
    	//The else is wrong
    	else { //meaning arm in position "60.0"
    		currentPosition = -((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2.0);
    		if (currentPosition == 0.0) {
    			finished = true;
    		}
    		//motors will move forwards at most speed -1 (backwards) 
    	}
    	
    	armSpeed = currentPosition / maxPulse; //Speed decreases as reaches max position of encoder (60 is arbitrary number for max degrees)
    	mIntakeArm.armMovement(armSpeed);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
