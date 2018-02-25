package org.metrobots.commands.teleop;


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
	private DoubleSolenoid gearshifter = new DoubleSolenoid(0, 1);
	
	
	Timer timer;
	private double currentTime;
	private double currentEncoder;
	private double velocity;
	/**
	 * Move pnuematic piston to opposite state when called. <p>
	 */
	
    public PressureSwitch() {
    	timer = new Timer();

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	//compressor.setClosedLoopControl(true);
    	//compressor.start();
    	//compressor = new Compressor(0);
    	
    	//compressor.stop();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriverStation.reportError("A IS PRESSED!", false);
    	
    	
    	if (gearShifterStatus) {
    		gearshifter.set(DoubleSolenoid.Value.kForward);
    		gearShifterStatus = !gearShifterStatus;
    	} else {
    		gearshifter.set(DoubleSolenoid.Value.kReverse);
    		gearShifterStatus = !gearShifterStatus;
    	}
    	
//    	if (/*Current Encoder*/ > 18.85) {
//    		currentTime = timer.get();
//    		currentEncoder = 
//    		velocity = currentTime / currentEncoder;
//    		
//    	}
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
