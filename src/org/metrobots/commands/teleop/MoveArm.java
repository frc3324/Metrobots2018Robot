package org.metrobots.commands.teleop;

import org.metrobots.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MoveArm extends Command {

	public IntakeArm mIntakeArm = new IntakeArm();
	
    public MoveArm() {
    	requires(mIntakeArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*create a method for the speed of the arm movement
    	 * double speedofleft = encoder pulse value from the encoder / the number of pulses from the encoder from front to back
    	 * double speedofright = speedofleft;
    	 * Something like moveArm(speedofleft, speedofright);
    	*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
