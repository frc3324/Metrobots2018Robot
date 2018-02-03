package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeArm extends Subsystem {
	
	static Encoder leftEncoder = new Encoder(Constants.leftArmEncoderA, Constants.leftArmEncoderB);
	static Encoder rightEncoder = new Encoder(Constants.rightArmEncoderA, Constants.rightArmEncoderB);
	
	public IntakeArm() {
		leftEncoder.getDistancePerPulse();
		rightEncoder.getDistancePerPulse();
	}
	
	WPI_VictorSPX lArmMotor = new WPI_VictorSPX(Constants.leftArmMotorPort);
	WPI_VictorSPX rArmMotor = new WPI_VictorSPX(Constants.rightArmMotorPort);
	
	public void armMovement(double leftSpeed, double rightSpeed) {
		
	}
	
    public void initDefaultCommand() {
        //Do nothing
    }
}

