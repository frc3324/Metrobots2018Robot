<<<<<<< HEAD
//package org.metrobots.commands.teleop;
//
//import org.metrobots.subsystems.Climber;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class Climb extends Command {
//
//	public Climber mClimber = new Climber();
//	
//    public Climb() {
//    	requires(mClimber);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
// 
//    /**
//     *  When command is executed, the climber will enable while the button is pressed. 
//     *  Backdrive is handled by a wrench.
//     */
//    
//    protected void execute() {
//    	mClimber.climb(1.0);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
=======
 package org.metrobots.commands.teleop;

import org.metrobots.subsystems.Climber;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop control of climbing mechanism<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 */
public class Climb extends Command {

	public Climber climber;
	private MetroController gamepad;

	/**
	 * Get the objects necessary to operate the climber
	 * 
	 * @param cl
	 *            climber object
	 * @param gp
	 *            handheld controller for operating shooter
	 */
	public Climb(Climber cl, MetroController gp) {
		climber = cl;
		gamepad = gp;
	}
	double number = 0.0;

	/**
	 * Function constantly run during teleop. Controls:<br>
	 * <b>Y</b>: spin climb winch
	 */
	public void execute() {
		//if(gamepad.getButton(MetroGamepad.BUTTON_A))
		//	climber.climb(true);//This will never stop
		climber.climb(gamepad.getButton(MetroController.BUTTON_A));
	}

	/*
	 * Necessary function that returns false.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
>>>>>>> e992ef501360cda43be0b392a37e77846418c2a9
