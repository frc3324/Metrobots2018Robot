package org.metrobots.commands.teleop;

import org.metrobots.OI;
import org.metrobots.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Moves the intake arm from forward to backward with the press of a button.
 * The button acts as a toggle.
 * 
 */
public class ControlArm extends Command {

	public IntakeArm mIntakeArm = new IntakeArm();
//	Encoder leftEncoder;
//	Encoder rightEncoder;
	boolean finished = false;
	int number = 0;
	
	XboxController gamepad1 = new XboxController(1);
	
	boolean startPosition = true; //Assumes arm in starting position at match start
	double goalPulse = 0.0;
	double armSpeed = 0.0;
	 
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
    	mIntakeArm.resetEncoder();
    	
//    	DriverStation.reportError("HERE!!!!!", false);
//    	
    }

    // Called repeatedly when this Command is scheduled to run
    /*
     * voltage to motor speed
     * 
     */
    protected void execute() {
//    	if (OI.is1APressed()) {
////	    DriverStation.reportError("A pressed", false);
//	    goalPulse = 180.0; //should be the maxPulse
//	    armThingy();
////	    mIntakeArm.armMovement(0.75);
//	}
//
//	else if (OI.is1XPressed()) {
////	    DriverStation.reportError("X pressed", false);
//	    goalPulse = 155.0;
//	    armThingy();
////	    mIntakeArm.armMovement(0.25);
//	}
//	    
//	else if (OI.is1YPressed()) {
////	    DriverStation.reportError("Y pressed", false);
//	    goalPulse = 70.0 + mIntakeArm.getRawArm();
//	    armThingy();
////	    mIntakeArm.armMovement(-0.25);
//	}
//	    
//	else if (OI.is1BPressed()) {
////	    DriverStation.reportError("B pressed", false);
//	   	goalPulse = 0.0;
//	    armThingy();
////	   	mIntakeArm.armMovement(-0.75);
//	}
//	else {
//		//mIntakeArm.armMovement(0.0);
//	}
    		
//    	double leftY = gamepad1.getY(Hand.kLeft);
//    	mIntakeArm.armMovement(leftY);
//    	
//    	if (gamepad1.getAButtonPressed()) {
//    		DriverStation.reportError("A pressed", true);
//    		goalPulse = 20.0;
//    	}
//    	else if (gamepad1.getBButtonPressed()) {
//    		DriverStation.reportError("B pressed", true);
//    		goalPulse = 40.0;
//    	}
//    	else {
//    		goalPulse = 50.0;
//    	}
    	
    	if (gamepad1.getAButtonPressed()) {
    		goalPulse = 30.0;
    	}
    	else {
    		goalPulse = 20.0;
    	}
    	double speed = 0.0;
    	double currentPulse = mIntakeArm.getRawArm();
		SmartDashboard.putNumber("currentPulse: ", currentPulse);
    	double diffPulse = goalPulse - currentPulse;
    	
    	if (diffPulse > 4.0) {
    		speed = diffPulse / 10;
        	finished = false;
    	}
    	else {
    		speed = 0.0;
    		finished = true;
    	}
    	
    	mIntakeArm.armMovement(speed);
    	
//    	if (diffPulse > 0.5) {
////        	double velocity = diffPulse / 200;
//    		if (diffPulse < 0.0) {
//    			speed = -speed;
//    		}
//        	mIntakeArm.armMovement(speed);
////    		finished = false;
//    	}
//    	else {
////    		mIntakeArm.armMovement(0.0);
////    		finished = true;
//    		
//    	}
    	SmartDashboard.putNumber("DIFFPULSE: ", diffPulse);
    	
//    	mIntakeArm.armMovement(0.5);
//    	mIntakeArm.printEncoder();
    	//mIntakeArm.printEncoder(); //right
    	
//    	double leftY = gamepad1.getY(Hand.kLeft);
//    	double speedArm = leftY * 0.5;
//    	mIntakeArm.armMovement(speedArm);
//    	if (OI.is1APressed()) {
////    	    DriverStation.reportError("A pressed", false);
//    	    goalPulse = 180.0; //should be the maxPulse
//    	    armThingy();
////    	    mIntakeArm.armMovement(0.75);
//    	}
//
//    	else if (OI.is1XPressed()) {
////    	    DriverStation.reportError("X pressed", false);
//    	    goalPulse = 155.0;
//    	    armThingy();
////    	    mIntakeArm.armMovement(0.25);
//    	}
//    	    
//    	else if (OI.is1YPressed()) {
////    	    DriverStation.reportError("Y pressed", false);
//    	    goalPulse = 70.0 + mIntakeArm.getRawArm();
//    	    armThingy();
////    	    mIntakeArm.armMovement(-0.25);
//    	}
//    	    
//    	else if (OI.is1BPressed()) {
////    	    DriverStation.reportError("B pressed", false);
//    	   	goalPulse = 0.0;
//    	    armThingy();
////    	   	mIntakeArm.armMovement(-0.75);
//    	}
//    	else {
//    		//mIntakeArm.armMovement(0.0);
//    	}
//    }
//    	
//   public void armThingy() {
//	   
//    	double maxPulse = 60.0;
//    	double currentPulse = mIntakeArm.getRawArm();
////    double armSpeed = 0.0;
//    
//    double diffPulse = goalPulse - currentPulse;
////    DriverStation.reportError("diffPulse: " + diffPulse, true);
//    
//    
////    if (goalPulse > currentPulse && diffPulse < 1.0) {
////    	armSpeed = go positive
////    }
////    else if (goalPulse < currentPulse && diffPulse < 1.0) {
////    	armSpeed = negative;
////    }
//    if (Math.abs(diffPulse) > 10.0) {
////    	DriverStation.reportError("diffpulse: " + diffPulse, true);
//    	armSpeed = (diffPulse / maxPulse);
//    	if (armSpeed > 1.0) {
//    		armSpeed = 1.0;
//    	}
//    	else if (armSpeed < -1.0) {
//    		armSpeed = -1.0;
//    	}
//    	else {
//    		armSpeed = diffPulse / maxPulse;
//    	}
//        mIntakeArm.armMovement(-armSpeed);
//        finished = false;
//    } else {
//    	mIntakeArm.armMovement(0.0);
//    	finished = true;
//    }
//    
//    	DriverStation.reportError("GOALPULSE: " + mIntakeArm.getRawArm(), false);
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
//    	mIntakeArm.armMovement(-0.5);
//    DriverStation.reportError("VALUE FOR THE ENCODER GET: " + mIntakeArm.getRawArm(), true);
//    double currentPulse = mIntakeArm.getRawArm();
//    DriverStation.reportError("currenPulse: " + currentPulse, false);
//    double maxPulse = 60.0;
////    double armSpeed = 0.0;
//    
//    double diffPulse = goalPulse - currentPulse;
////    DriverStation.reportError("diffPulse: " + diffPulse, true);
//    
//    while (Math.abs(diffPulse) > 10.0) {
////    	DriverStation.reportError("diffpulse: " + diffPulse, true);
//    	armSpeed = diffPulse / maxPulse;
//        mIntakeArm.armMovement(armSpeed);
//        finished = false;
//    }
    
    
//  double goalPulseFullForward = 180.0;
//  double goalPulseSwitchForward = 155.0;
//  double goalPulseScaleForward = 110.0;
//  double goalPulseScaleBackward = 70.0;
//  double goalPulseSwitchBackward = 45.0;	
//  double goalPulseFullBackward = 0.0;
    
//    if (state) {
//    	
//    }
//    else {
//	    while (!state) {
//	    	armSpeed = -armSpeed;
//	    }
//    }
//    
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
//    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
