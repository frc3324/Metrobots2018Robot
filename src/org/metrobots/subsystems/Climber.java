package org.metrobots.subsystems;

import org.metrobots.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Climber extends Subsystem {

	WPI_VictorSPX climber = new WPI_VictorSPX(Constants.climberMotorPort);
	WPI_VictorSPX miniMotor = new WPI_VictorSPX(Constants.climberNotTheWinch);
	
	public Climber() {
		
	}
	
	public void climb(double speed) {
		climber.set(speed);
	}
	
	/**
	 * Climber object
	 * 
	 * @param climbMotor
	 *            motor that is on the climber
	 */
	/**
	 * Spins winch to pick up robot
	 * 
	 * @param up
	 *            boolean which tells robot whether or not it should winch
	 */
	public void climberArm(double speed) {
		miniMotor.set(speed);
	}
	/*
	 * Necessary method that contains nothing
	 */
	protected void initDefaultCommand() {

	}
	
}

