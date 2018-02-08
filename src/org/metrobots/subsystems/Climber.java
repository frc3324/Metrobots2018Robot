package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	WPI_VictorSPX climber = new WPI_VictorSPX(Constants.climberMotorPort);
	
	public Climber() {
		
	}
	
	public void climb(double speed) {
		climber.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

