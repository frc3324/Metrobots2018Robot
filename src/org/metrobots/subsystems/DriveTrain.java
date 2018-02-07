package org.metrobots.subsystems;
// Import WPI libraries

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*TODO Auto-generated constructor stub
 Add encoders, gyro, and/or other sensors */

// Identify Drivetrain as a subsystem (class)
public class DriveTrain extends	Subsystem {
	
	//Template for constructor of the SpeedControllerGroup class
	
	static Encoder lEncoder = new Encoder(Constants.leftEncoderPortA, Constants.leftEncoderPortB);
	static Encoder rEncoder = new Encoder(Constants.rightEncoderPortA, Constants.rightEncoderPortB);
	private int rightEncoderValue = rEncoder.get();
	private int leftEncoderValue = lEncoder.get();
	private double distancePerPulse = Constants.CIRCUMFERENCE / Constants.PULSES;
	
	WPI_VictorSPX flMotor = new WPI_VictorSPX(Constants.flMotorPort); // Instantiate the motors as a new TalonSRX motor controller
	WPI_VictorSPX blMotor = new WPI_VictorSPX(Constants.blMotorPort); 
	SpeedControllerGroup lMotors = new SpeedControllerGroup(flMotor, blMotor); // Combine the left motors into one lMotors speed controller group
	
	WPI_VictorSPX frMotor = new WPI_VictorSPX(Constants.frMotorPort); //repeat for right motors
	WPI_VictorSPX brMotor = new WPI_VictorSPX(Constants.brMotorPort);
	SpeedControllerGroup rMotors = new SpeedControllerGroup(frMotor, brMotor);
	
	DifferentialDrive mDrive = new DifferentialDrive(lMotors, rMotors);
	
	public DriveTrain() {
		//mDrive.setSafetyEnabled(false);
		lEncoder.setDistancePerPulse(distancePerPulse);
		rEncoder.setDistancePerPulse(distancePerPulse);
	}
	/*
	public static double getLeftDistance() {
		return lEncoder.getDistance();
	}
	
	public static double getRightDistance() {
		return rEncoder.getDistance();
	}
	*/
	public void printEncoder() {
		SmartDashboard.putNumber("Right Encoder Value", rightEncoderValue);
		SmartDashboard.putNumber("Left Encoder Value", (double)leftEncoderValue);
		SmartDashboard.putData("tag", leftEncoderValue+"");
	}
	public void arcadeDrive(double ySpeed, double rotationSpeed, boolean squaredInputs) { // Creating left and right speed from WPILib's tankDrive
		mDrive.arcadeDrive(ySpeed, rotationSpeed, squaredInputs);
		//mDrive.tankDrive(leftSpeed, rightSpeed, true);
	
	}
	public void tankDrive(double xSpeed, double ySpeed, boolean squaredInputs) { // Creating left and right speed from WPILib's tankDrive
		mDrive.tankDrive(xSpeed, ySpeed, squaredInputs);
		//mDrive.tankDrive(leftSpeed, rightSpeed, true);
	
	}
	
	
	protected void initDefaultCommand() {
		//Do nothing by default if code is broken
	}

}