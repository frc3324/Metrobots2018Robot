package org.metrobots;

//import edu.wpi.first.wpilibj.SPI;

/**
 * Class with tons of constants that won't need to change on the fly.<br>
 * Examples: motor controller ports, sensor ports, xbox controller ports,
 * etc.<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 *
 * Feb 8: Added agitator Motor port; needs put on the robot - Xander
 *
 */
public class Constants {

	/*
	 * Motor ports
	 */
	public final static int flMotorPort = 0; //8
	public final static int blMotorPort = 3; //6
	//public final static int frMotorPort = 4; //4
	public final static int frMotorPort = 1; //for testing auto 2
	public final static int brMotorPort = 2; //0
	public final static int armMotorPort = 8;//6
	public final static int leftIntakeMotorPort = 9;
	public final static int rightIntakeMotorPort = 1;
	public final static int LINEAR_SLIDE_MOTOR_PORT = 3;
	public final static int WINCH_PORT = 7;
	
	/*
	 * Pneumatic Ports
	 */
//	public final static int gearPushPort = 0;
//	public final static int gearPullPort = 1;

	/*
	 * Sensor ports
	 */
	//public final static SPI.Port navxPort = SPI.Port.kMXP;
	/*public final static int flEncoder1 = 4; // Not actually
	public final static int flEncoder2 = 5; // Not actually
	public final static int blEncoder1 = 0;
	public final static int blEncoder2 = 1;
	public final static int frEncoder1 = 6; // Not actually
	public final static int frEncoder2 = 7; // Not actually
	public final static int brEncoder1 = 2;
	public final static int brEncoder2 = 3;*/
	public final static int shooterEncoder1 = 10; // Pin 0 on MXP theoretically
	public final static int shooterEncoder2 = 11; // Pin 1 on MXP
//	public final static int ultrasonicOut = 8;
//	public final static int ultrasonicIn = 9;
	
	public final static int leftEncoderPortA = 0;
	public final static int leftEncoderPortB = 1;
	public final static int rightEncoderPortA = 2;
	public final static int rightEncoderPortB = 3;
//	public final static int testArmEncoderA = 7; //7 for one on motor
//	public final static int testArmEncoderB = 8; //8 for one on motor
	public final static int ArmEncoderACLK = 6; //yellow
	public final static int ArmEncoderSW = 4; //yellow
	public final static int ArmEncoderDT = 5; //white
	
//	public final static int CAMERA_PORT = 0;
	

	/*
	 * Current measurement
	 */
	public final static int ARM_PORT = 6;
	
	/*
	 * Driver station ports
	 */
	public final static int primaryGamepadPort = 0; 
	public final static int secondaryGamepadPort = 1; 
	
	/*
	 * 
	 * Shooter variables
	 */
	public final static double kShooterP = 5000.0; //80, 20 700
	public final static double kShooterI = 0.0;
	public final static double kShooterD = 0.0; //175, 100 300
	public final static double kShooterTolerance = 0.1;
	public final static double maxShooterRPM = 5675.0;
	public final static int keyShootingRPM = 3500;//4000
	public static int airshipShootingRPM = 4500;
	public final static int opticalEncoderLow = 0;
	public final static int opticalEncoderHigh = 2000;
	public static double kFlywheelSpeed = 0.8;
	public final static double kFeederSpeed = 0.25;//1.0
	
	/*
	 * DriveTrain variables
	 */
	public static double kDriveHoldAngleP = 0.007;
	public final static double driveTrainAngleDeadband = 3;
	public final static double AXIS_DEADBAND = 0.05;
	
	public final static double CIRCUMFERENCE = 18.85; // (Inches) Need to measure in inches
	public final static double PULSES = 2639.43;
	public final static double INCH_PER_PULSE = 0.074; //circumference of wheel in inches / pulses
	public final static double AUTO_ROTATE_ANGLE_THRESHOLD = 1.0;
	
}
