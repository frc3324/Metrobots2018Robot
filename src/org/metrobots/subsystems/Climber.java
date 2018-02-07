package org.metrobots.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import src.org.metrobots.commands.teleop.WPI_VictorSPX;
import src.org.metrobots.Constants;

/**
 *
 */
public class Climber extends Subsystem {

	WPI_VictorSPX winch = new WPI_VictorSPX(Constants.winchMotorPort);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void Climber() {
		
	}
	
	public void SetClimberSpeed() {
		
	}
	public void winch(double speed) {
		winch.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

