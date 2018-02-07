package org.metrobots.subsystems;

import org.metrobots.Constants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Climber mechanism for Metrobot<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 */
public class Climber extends Subsystem {

	WPI_VictorSPX miniMotor = new WPI_VictorSPX(Constants.climberNotTheWinch);
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
