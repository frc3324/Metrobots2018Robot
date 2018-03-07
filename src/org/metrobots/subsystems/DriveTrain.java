package org.metrobots.subsystems;
// Import WPI libraries

import org.metrobots.Constants;
import org.metrobots.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*TODO Auto-generated constructor stub
 Add encoders, gyro, and/or other sensors */

// Identify Drivetrain as a subsystem (class)
public class DriveTrain extends	Subsystem implements PIDOutput {
	
	//Template for constructor of the SpeedControllerGroup class
	  AHRS ahrs;
	  PIDController turnController;
	  double rotateToAngleRate;
	  
	  /* The following PID Controller coefficients will need to be tuned */
	  /* to match the dynamics of your drive system.  Note that the      */
	  /* SmartDashboard in Test mode has support for helping you tune    */
	  /* controllers by displaying a form where you can enter new P, I,  */
	  /* and D constants and test the mechanism.                         */
	  
	static final double kP = 0.03;
	static final double kI = 0.00;
	static final double kD = 0.00;
	static final double kF = 0.00;
	private static Encoder lEncoder = new Encoder(Constants.leftEncoderPortA, Constants.leftEncoderPortB, false, Encoder.EncodingType.k4X);
	private static Encoder rEncoder = new Encoder(Constants.rightEncoderPortA, Constants.rightEncoderPortB, false, Encoder.EncodingType.k4X);
	private double distancePerPulse = Constants.CIRCUMFERENCE / Constants.PULSES;
	
	private double rightEncoderDistance = 0.0;
	private double leftEncoderDistance = 0.0;
	static final double kToleranceDegrees = 2.0f;


	WPI_VictorSPX flMotor = new WPI_VictorSPX(Constants.flMotorPort); // Instantiate the motors as a new TalonSRX motor controller
	WPI_VictorSPX blMotor = new WPI_VictorSPX(Constants.blMotorPort); 
	SpeedControllerGroup lMotors = new SpeedControllerGroup(flMotor, blMotor); // Combine the left motors into one lMotors speed controller group
	
	WPI_VictorSPX frMotor = new WPI_VictorSPX(Constants.frMotorPort); //repeat for right motors
	WPI_VictorSPX brMotor = new WPI_VictorSPX(Constants.brMotorPort);
	SpeedControllerGroup rMotors = new SpeedControllerGroup(frMotor, brMotor);
	
	DifferentialDrive mDrive = new DifferentialDrive(lMotors, rMotors);
	
	
	public DriveTrain() {
		mDrive.setSafetyEnabled(true);
		lEncoder.setDistancePerPulse(distancePerPulse);
		rEncoder.setDistancePerPulse(distancePerPulse);
		  try {
	          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
	          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
	          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
	          ahrs = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
	      turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	      turnController.setInputRange(-180.0f,  180.0f);
	      turnController.setOutputRange(-1.0, 1.0);
	      turnController.setAbsoluteTolerance(kToleranceDegrees);
	      turnController.setContinuous(true);
	      
	      /* Add the PID Controller to the Test-mode dashboard, allowing manual  */
	      /* tuning of the Turn Controller's P, I and D coefficients.            */
	      /* Typically, only the P value needs to be modified.                   */
	  }
	
	/**
	 * Set safety status of drivetrain motor controllers
	 * @param status
	 */
	public void setSafetyEnabled(boolean status) {
		mDrive.setSafetyEnabled(status);
	}

	
	/**
	 * Get distance of the left encoder in inches.
	 * @return
	 */
	public static double getLeftDistance() {
		return lEncoder.getDistance();
	}
	  public double RotatePID(double angle, double speed) {
          boolean rotateToAngle = false;
              turnController.setSetpoint(angle);
              rotateToAngle = true;
          double currentRotationRate;
          if ( rotateToAngle ) {
              turnController.enable();
              currentRotationRate = rotateToAngleRate * speed;
          } else {
              turnController.disable();
              currentRotationRate = 0;
          }
          try {
              /* Use the joystick X axis for lateral movement,          */
              /* Y axis for forward movement, and the current           */
              /* calculated rotation rate (or joystick Z axis),         */
              /* depending upon whether "rotate to angle" is active.    */
             mDrive.arcadeDrive(0, currentRotationRate, false);
          } catch( RuntimeException ex ) {
              DriverStation.reportError("Error communicating with drive system:  " + ex.getMessage(), true);
          }
          SmartDashboard.putNumber("Gyro", currentRotationRate);
          SmartDashboard.putNumber("Gyro1", ahrs.getAngle());
          return currentRotationRate;
      }
//	  SmartDashboard.putNumber("Gyro", currentRotationRate);

  /**
   * Runs during test mode
   */


  @Override
  /* This function is invoked periodically by the PID Controller, */
  /* based upon navX-MXP yaw angle input and PID Coefficients.    */
  public void pidWrite(double output) {
      rotateToAngleRate = output;
  }

	/**
	 * Get distance of the right encoder in inches.
	 * @return
	 */
	public static double getRightDistance() {
		return rEncoder.getDistance();
	}
	
	/**
	 * Reset both of the encoders.
	 */
	public static void clearEncoder() {
		lEncoder.reset();
		rEncoder.reset();
	}
	
	/**
	 * Print the encoder values in inches.
	 */
	public void printEncoder() {
		leftEncoderDistance = getLeftDistance();
		rightEncoderDistance = getRightDistance();
		
		// using raw values here, test purpose only
		leftEncoderDistance = lEncoder.get();
		rightEncoderDistance = rEncoder.get();
		
		
		// 
//		SmartDashboard.putNumber("Program is Running", val);
//		val++;
		SmartDashboard.putNumber("L Encoder Distance", leftEncoderDistance);
		SmartDashboard.putNumber("R Encoder Distance", rightEncoderDistance);
		// print speeds
		SmartDashboard.putNumber("L Rate", lEncoder.getRate());
		SmartDashboard.putNumber("R Rate", rEncoder.get()); // unit: distance per sec
	}
	
	/**
	 * Drive the robot with arcade drive. Combined usage of the controls in the y direction and rotation speed will result in turns.
	 * @param ySpeed
	 * 	Speed in the y direction in relation to the robot.
	 * @param rotationSpeed
	 * 	Speed of rotation.
	 * @param squaredInputs
	 * 	Sensitivity set when true. False when not.
	 */
	public void arcadeDrive(double ySpeed, double rotationSpeed, boolean squaredInputs) { // Creating left and right speed from WPILib's tankDrive
		mDrive.arcadeDrive(ySpeed, rotationSpeed, squaredInputs);
		//mDrive.tankDrive(leftSpeed, rightSpeed, true);
	
	}
	
	/**
	 * Drive the robot with tank drive. 
	 * @param xSpeed
	 * 	Speed in the x direction in relation to the robot.
	 * @param ySpeed
	 * 	Speed in the y direction in relation to the robot.
	 * @param squaredInputs
	 * 	Sensitivity set when true. False when not.
	 */
	public void tankDrive(double xSpeed, double ySpeed, boolean squaredInputs) { // Creating left and right speed from WPILib's tankDrive
		mDrive.tankDrive(xSpeed, ySpeed, squaredInputs);
		//mDrive.tankDrive(leftSpeed, rightSpeed, true);
	
	}
	
	protected void initDefaultCommand() {
		//Do nothing by default if code is broken
	}

}