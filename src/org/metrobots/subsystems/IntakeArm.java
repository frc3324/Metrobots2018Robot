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
	
	static Encoder leftEncoder = new Encoder(Constants.leftArmEncoderA, Constants.leftArmEncoderB);
	static Encoder rightEncoder = new Encoder(Constants.rightArmEncoderA, Constants.rightArmEncoderB);
	
	WPI_VictorSPX lArmMotor = new WPI_VictorSPX(Constants.leftArmMotorPort);
	WPI_VictorSPX rArmMotor = new WPI_VictorSPX(Constants.rightArmMotorPort);
	
	SpeedControllerGroup armMotors = new SpeedControllerGroup (lArmMotor, rArmMotor);
	
	public IntakeArm() {
		leftEncoder.setDistancePerPulse(5); //5 is arbitrary number; would mean 5 degrees for every pulse
		rightEncoder.setDistancePerPulse(5);
		leftEncoder.getRate();
		rightEncoder.getRate();
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public double getLeftEncoderRaw() {
		return leftEncoder.get();
	}
	
	public double getRightEncoderRaw() {
		return rightEncoder.get();
	}
	
	public void printEncoder() {
		SmartDashboard.putNumber("R Rate: ", rightEncoder.get()); // unit: distance per sec
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