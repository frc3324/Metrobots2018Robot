package org.metrobots.commands.teleop;


import org.metrobots.OI;
import org.metrobots.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PressureSwitch extends Command {
	boolean gearShifterStatus = false;
	
	Timer timer;
	private double currentTime;
	private double currentEncoder;
	private double velocity;
	boolean switchFinished;
	private int val = 0;
	/**
	 * Move pnuematic piston to opposite state when called. <p>
	 */
	
    public PressureSwitch() {
    	requires(Robot.mPneumatics);
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriverStation.reportError("HERE", false);
    	timer.start();
    	//compressor.setClosedLoopControl(true);
    	//compressor.start();
    	//compressor = new Compressor(0);
    	
    	//compressor.stop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation.reportError("0A IS PRESSED!", false);
    	SmartDashboard.putNumber("Pressure Count", val);
    	val++;
    	if (gearShifterStatus) {
//    		Robot.mPneumatics.setHighGear();
    		gearShifterStatus = !gearShifterStatus;
    		switchFinished = true;
    		
    	} else {
    		Robot.mPneumatics.setLowGear();
//    		gearShifterStatus = !gearShifterStatus;
    		switchFinished = true;
    	}
    	
//    	if (/*Current Encoder*/ > 18.85) {
//    		currentTime = timer.get();
//    		currentEncoder = 
//    		velocity = currentTime / currentEncoder;
//    		
//    	}
//    	SmartDashboard.putBoolean("Switch Status", gearShifterStatus);
    }
    	
    	/*catch (RuntimeException ex){
    		DriverStation.reportError(""+ ex, true);
    	}*/
    	
   // }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return switchFinished;
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
