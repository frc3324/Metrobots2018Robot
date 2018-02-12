package org.metrobots.commands.teleop;

import org.metrobots.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Moves the intake arm from forward to backward with the press of a button.
 * The button acts as a toggle.
 * 
 */
public class ControlArm extends Command {

	public IntakeArm mIntakeArm = new IntakeArm();
	Encoder leftEncoder;
	Encoder rightEncoder;
	boolean finished = false;
	
	XboxController gamepad1 = new XboxController(1);
	
	boolean startPosition = true; //Assumes arm in starting position at match start
	
	/**
	 * Move the arm to its opposite position when called. <p>
	 */
    public ControlArm() {
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
    double goalPulse = 0.0;
    if (gamepad1.getAButtonPressed()) {
    	goalPulse = 180.0; //should be the maxPulse
    }
    if (gamepad1.getXButtonPressed()) {
    	goalPulse = 155.0;
    }
    if (gamepad1.getYButtonPressed()) {
    	goalPulse = 70.0;
    }
    if (gamepad1.getBButtonPressed()) {
    	goalPulse = 0.0;
    }
//    double goalPulseFullForward = 180.0;
//    double goalPulseSwitchForward = 155.0;
//    double goalPulseScaleForward = 110.0;
//    double goalPulseScaleBackward = 70.0;
//    double goalPulseSwitchBackward = 45.0;	
//    double goalPulseFullBackward = 0.0;
    
    double currentPulse = (leftEncoder.get() + rightEncoder.get()) / 2.0;
    double maxPulse = 0.0;
    double armSpeed = 0.0;
    boolean state = false;
    
    double diffPulse = goalPulse - currentPulse;
    
//    if (state) {
//    	
//    }
//    else {
//	    while (!state) {
//	    	armSpeed = -armSpeed;
//	    }
//    }
//    
    while (Math.abs(diffPulse) > 1.9) {
    	armSpeed = diffPulse / maxPulse;
        mIntakeArm.armMovement(armSpeed);
    }
	
//    	if (leftEncoder.getDirection() == false && rightEncoder.getDirection() == false) { //meaning arm in position 0.0 and moving forward
//    		goalValue = ((Math.abs(leftEncoder.getDistance()) - maxPulse) + (Math.abs(rightEncoder.getDistance())) - maxPulse) / 2.0; //Average distance in degrees from encoders, scaled from distancePerPulse
//    		//motors will move at most speed 1 (forwards), but that can be changed if needed
//    		if (goalValue > (maxPulse - 0.5)) {
//    			finished = true;
//    		}
//    	}
//    	//The else is wrong, b/c the execute is run continuously, and will just go the opposite direction when execute is done.
//    	else { //meaning arm in position "60.0"
//    		goalValue = -((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2.0);
//    		if (goalValue < 0.5) {
//    			finished = true;
//    		}
//    		//motors will move forwards at most speed -1 (backwards) 
//    	}
    
    
//    	double armSpeed = 0.0;
//    	double positionGoal = 0.0;
//    	double maxPulse = 60.0; //Arbitrary number for max pulses in rotation of arm
//    	double maxDegrees = 50.0; //Number based off the maxPulse, translated to degrees
//    	
//    	//If the left encoder value is not within the goal and the left encoders are going in false direction, then...
//    	if (leftEncoder.getDistancePerPulse() != (maxDegrees - 0.5) && leftEncoder.getDirection() == false) {
//    		//Get average distance in degrees from encoders, scaled from distancePerPulse
//    		positionGoal = ((Math.abs(leftEncoder.getDistance()) - maxPulse) + (Math.abs(rightEncoder.getDistance())) - maxPulse) / 2.0; 
//    		//motors will move at most speed 1 (forwards), but that can be changed if needed
//    		//If the pulse value is in range of the goal, finish command
//    		if (positionGoal > (maxPulse - 0.5)) {
//    			finished = true;
//    		}
//    	}
//    	
//    	//if (leftencoder value is not in threshold of goal and its last direction was the direction we need to go) {
//    		
//    			//if (leftencoder value less than goal and going in the direction that we need to go, it is going to the right) {
//    			//}
//    			//else if (leftencoder value more than goal and going in the direction that we need to go, it is going to left) { }
//    	//}		
//    	if (leftEncoder.getDirection() == false && rightEncoder.getDirection() == false) { //meaning arm in position 0.0 and moving forward
//    		positionGoal = ((Math.abs(leftEncoder.getDistance()) - maxPulse) + (Math.abs(rightEncoder.getDistance())) - maxPulse) / 2.0; //Average distance in degrees from encoders, scaled from distancePerPulse
//    		//motors will move at most speed 1 (forwards), but that can be changed if needed
//    		if (positionGoal > (maxPulse - 0.5)) {
//    			finished = true;
//    		}
//    	}
//    	//The else is wrong, b/c the execute is run continuously, and will just go the opposite direction when execute is done.
//    	else { //meaning arm in position "60.0"
//    		positionGoal = -((Math.abs(leftEncoder.getDistance()) + Math.abs(rightEncoder.getDistance())) / 2.0);
//    		if (positionGoal < 0.5) {
//    			finished = true;
//    		}
//    		//motors will move forwards at most speed -1 (backwards) 
//    	}
//    	
//    	if (positionGoal > 50) {
//    		armSpeed = positionGoal / maxPulse; //Speed decreases as reaches max position of encoder (60 is arbitrary number for max degrees)	
//    	}
//    	else {
//    		armSpeed = positionGoal ;
//    	}
//    	
//    	mIntakeArm.armMovement(armSpeed);
//    	
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
