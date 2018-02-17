package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 */

public class IntakeArm extends Subsystem {
	
	static Encoder armEncoder = new Encoder(Constants.ArmEncoderACLK, Constants.ArmEncoderDT, Constants.ArmEncoderSW);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);
	
	WPI_TalonSRX armMotor = new WPI_TalonSRX(Constants.armMotorPort);
	
	public IntakeArm() {
		armEncoder.setDistancePerPulse(1); //5 is arbitrary number; would mean 5 degrees for every pulse
		armEncoder.get();
//		testArmEncoder.setDistancePerPulse(5);
//		testArmEncoder.getRate();
	}
	 
	public void resetEncoder() {
		armEncoder.reset();
//		testArmEncoder.reset();
	}
	
	public double getRawArm() {
//		return armEncoder.getRate();
		return armEncoder.getDistance();
//		return testArmEncoder.get();
	}
	
	public void printEncoder() {
		SmartDashboard.putNumber("R Rate: ", armEncoder.get()); // unit: distance per sec
		int val = 0;
		SmartDashboard.putNumber("Program is Running", val);
		val++;
		DriverStation.reportError("R rate: " + armEncoder.get(), false);
//		DriverStation.reportError("TESTRATE: " + testArmEncoder.get(), false);
//		SmartDashboard.putNumber("R Rate: ", testArmEncoder.get()); // unit: distance per sec
//		int val = 0;
//		SmartDashboard.putNumber("Program is Running", val);
//		val++;
	}
	 /**
	  * Move the arm at specified velocity.
	  * @param speed
	  */
	
	public void armMovement(double speed) {
		armMotor.set(speed);
	}
	
    public void initDefaultCommand() {
        //Do nothing
    }
}