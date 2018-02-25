package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeArm extends Subsystem {
	
//	DigitalInput limitSwitch = new DigitalInput(9);
//    Counter counter = new Counter(limitSwitch);
	static Encoder armEncoder = new Encoder(Constants.ArmEncoderACLK, Constants.ArmEncoderDT, Constants.ArmEncoderSW);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);
//	static Encoder testArmEncoder = new Encoder(Constants.testArmEncoderA, Constants.testArmEncoderB);
	
	private WPI_TalonSRX armMotorLeft = new WPI_TalonSRX(Constants.MOTOR_PORT_ARM_LEFT);
	private WPI_TalonSRX armMotorRight = new WPI_TalonSRX(Constants.MOTOR_PORT_ARM_RIGHT);
	private SpeedControllerGroup armMotors = new SpeedControllerGroup(armMotorLeft, armMotorRight);
	
	public IntakeArm() {
		// CAUTION: direction already set, don't change it
		if (armMotorLeft.getInverted()) {
			armMotorLeft.setInverted(true);
		}
	}
	 
	/**
	 * Reset the arm encoder to zero.
	 */
//    public boolean isSwitchSet() {
//        return counter.get() > 0;
//    }
//    public void initializeCounter() {
//        counter.reset();
//    }
	public void resetEncoder() {
		armEncoder.reset();
//		testArmEncoder.reset();
	}
	
	/**
	 * Get encoder distance in units.
	 * @return
	 */
	public double getRawArm() {
//		return armEncoder.getRate();
		return armEncoder.getDistance();
//		return 0.00;
//		return testArmEncoder.get();
	}
	
	public void printEncoder() {
		//SmartDashboard.putNumber("R Rate: ", armEncoder.get()); // unit: distance per sec
		int val = 0;
		SmartDashboard.putNumber("Program is Running", val);
		val++;
		SmartDashboard.putNumber("R Rate:", armEncoder.get());
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
	
	/**
	 * Move the arm at the specified speed.
	 * @param speed
	 */
	public void armMovement(double speed) {
		armMotors.set(speed);
	}
	
    public void initDefaultCommand() {
        //Do nothing
    }
}