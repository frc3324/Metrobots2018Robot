package org.metrobots.commands.teleop;

import org.metrobots.Constants;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PressureSwitch extends Command {
	boolean gearShifterStatus = false;
	Compressor compressor;
	Solenoid gearshifter;
	
	/**
	 * Move pnuematic piston to opposite state when called. <p>
	 */
    public PressureSwitch() {
    	compressor = new Compressor(0);
    	gearshifter = new Solenoid(4);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//compressor.setClosedLoopControl(true);
    	//compressor.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation.reportError("random world", false);
	    gearShifterStatus = !gearShifterStatus;
	    gearshifter.set(gearShifterStatus);
    	
    	/*catch (RuntimeException ex){
    		DriverStation.reportError(""+ ex, true);
    	}*/
    	
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
