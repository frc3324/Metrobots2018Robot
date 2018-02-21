package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.OI;
import org.metrobots.Robot;
import org.metrobots.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PressureSwitch extends Command {
	boolean gearShifterStatus = false;
	XboxController gamepad0  = new XboxController(0);
	private Compressor compressor = new Compressor(0);
	private DoubleSolenoid gearshifter = new DoubleSolenoid(0, 1);
	
	/**
	 * Move pnuematic piston to opposite state when called. <p>
	 */
    public PressureSwitch() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//compressor.setClosedLoopControl(true);
    	//compressor.start();
    	//compressor = new Compressor(0);
    	
    	//compressor.stop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (gamepad0.getAButton()) {
    		DriverStation.reportError("A IS PRESSED!", false);
    		if (gearShifterStatus) {
    			gearshifter.set(DoubleSolenoid.Value.kForward);
    			gearShifterStatus = !gearShifterStatus;
    		}
    		else {
    			gearshifter.set(DoubleSolenoid.Value.kReverse);
    			gearShifterStatus = !gearShifterStatus;
    		}
    	}
//    	gearshifter.set(DoubleSolenoid.Value.kOff);
    	SmartDashboard.putBoolean("Switch Status", gearShifterStatus);
    }
    	
    	/*catch (RuntimeException ex){
    		DriverStation.reportError(""+ ex, true);
    	}*/
    	
   // }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
