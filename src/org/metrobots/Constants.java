package src.org.metrobots;

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
	public final static int flMotorPort = 6;
	public final static int blMotorPort = 7;
	public final static int frMotorPort = 0;
	public final static int brMotorPort = 1;
	public final static int intakeMotorPort = 8;//6
	public final static int climbMotorPort = 7; //5
	public final static int launchMotorPort = 4;
	public final static int feederMotorPort = 5; //7
	public final static int agitatorMotorPort = 6;//8
	
	/*
	 * Pneumatic Ports
	 */
	public final static int gearPushPort = 0;
	public final static int gearPullPort = 1;

	/*
	 * Sensor ports
	 */
	public final static int opticalEncoderPort = 0; // Analog
	//public final static SPI.Port navxPort = SPI.Port.kMXP;
	public final static int flEncoder1 = 4; // Not actually
	public final static int flEncoder2 = 5; // Not actually
	public final static int blEncoder1 = 0;
	public final static int blEncoder2 = 1;
	public final static int frEncoder1 = 6; // Not actually
	public final static int frEncoder2 = 7; // Not actually
	public final static int brEncoder1 = 2;
	public final static int brEncoder2 = 3;
	public final static int shooterEncoder1 = 10; // Pin 0 on MXP theoretically
	public final static int shooterEncoder2 = 11; // Pin 1 on MXP
	public final static int ultrasonicOut = 8;
	public final static int ultrasonicIn = 9;
	
	/*public final static int leftEncoderPortA = ?;
	public final static int leftEncoderPortB = ?;
	public final static int rightEncoderPortA = ?;
	public final static int rightEncoderPortB = ?;*/
	

	/*
	 * Driver station ports
	 */
	public final static int motionGamepadPort = 0; //Primary driver controller
	public final static int mechanismGamepadPort = 1; //Secondary driver controller

	/*
	 * 
	 * Shooter variables
	 */
	public final static double kStraightP = 0.03; //80, 20 700
	public final static double kStraightI = 0.0;
	public final static double kStraightD = 0.0; //175, 100 300
	public final static double kFloatPeriod = 0.00;
	public final static double kTolerance = 2.0;
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
	
	public final static double CIRCUMFERENCE = 2; //Need to measure
	public final static double PULSES = 256; 
	
}
