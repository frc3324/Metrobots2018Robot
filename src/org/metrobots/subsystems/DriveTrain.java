package org.metrobots.subsystems;
// Import WPI libraries

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/*TODO Auto-generated constructor stub
 Add encoders, gyro, and/or other sensors */

// Identify Drivetrain as a subsystem (class)
public class DriveTrain extends	Subsystem {
	
	//Template for constructor of the SpeedControllerGroup class
	
	WPI_TalonSRX flMotor = new WPI_TalonSRX(0); // Instantiate the motors as a new TalonSRX motor controller
	WPI_TalonSRX blMotor = new WPI_TalonSRX(1); 
	SpeedControllerGroup lMotors = new SpeedControllerGroup(flMotor, blMotor); // Combine the left motors into one lMotors speed controller group
	
	WPI_TalonSRX frMotor = new WPI_TalonSRX(2); //repeat for right motors
	WPI_TalonSRX brMotor = new WPI_TalonSRX(3);
	SpeedControllerGroup rMotors = new SpeedControllerGroup(frMotor, brMotor);
	
	DifferentialDrive mDrive = new DifferentialDrive(lMotors, rMotors);

	public void tankDrive(double leftSpeed, double rightSpeed) { // Creating left and right speed from WPILib's tankDrive
		mDrive.tankDrive(leftSpeed, rightSpeed, true);
	
	}
	
	protected void initDefaultCommand() {
		//Do nothing by default if code is broken
	}

}