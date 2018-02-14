package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */
public class IntakeArm extends Subsystem {
	
	static Encoder armEncoder = new Encoder(Constants.leftArmEncoderA, Constants.leftArmEncoderB);
	
	WPI_VictorSPX lArmMotor = new WPI_VictorSPX(Constants.leftArmMotorPort);
	WPI_VictorSPX rArmMotor = new WPI_VictorSPX(Constants.rightArmMotorPort);
	
	SpeedControllerGroup armMotors = new SpeedControllerGroup (lArmMotor, rArmMotor);
	
	public IntakeArm() {
		armEncoder.setDistancePerPulse(5); //5 is arbitrary number; would mean 5 degrees for every pulse
		armEncoder.getRate();
	}
	
	public void resetEncoder() {
		armEncoder.reset();
	}
	
	public double getRawArm() {
		return armEncoder.get();
	}

	
	public void printEncoder() {
		SmartDashboard.putNumber("R Rate: ", armEncoder.get()); // unit: distance per sec
		int val = 0;
		SmartDashboard.putNumber("Program is Running", val);
		val++;
	}
	 /**
	  * Move the arm at specified velocity.
	  * @param speed
	  */
	
	public void armMovement(double speed) {
		armMotors.set(speed);
	}
	
    public void initDefaultCommand() {
        //Do nothing
    }
}