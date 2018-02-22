package org.metrobots;

import java.io.IOException;

import org.metrobots.botcv.communication.CommInterface;
import org.metrobots.commands.AutoConfiguration;
import org.metrobots.commands.DriveGroup;
import org.metrobots.commands.auto.groups.LLeft;
import org.metrobots.commands.auto.groups.LMiddle;
//import org.metrobots.commands.auto.groups.LL;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.subsystems.CubeController;
import org.metrobots.subsystems.DriveTrain;
//import org.metrobots.util.LimitSwitch;
import org.metrobots.subsystems.Gyro;
import org.metrobots.subsystems.IntakeArm;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main robot code<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 * Feb 8: Added agitator Talon and stuff - Xander
 * 
 */
public class Robot extends IterativeRobot {
	
	DigitalInput forwardLimitSwitch;
	//public String autoSet = "";      //is already called out in autoconfig
	public static boolean isAuto = false;
//	public static final LimitSwitch mLimitSwitch = new LimitSwitch();
	public static boolean limitSwitchValue = false;  
	/*
	 * Declare gamepad objects
	 */
	public OI mOI;
	public static final DriveTrain mDriveTrain = new DriveTrain(); //DriveTrain instantiated here
	public static final Gyro mGyro = new Gyro();
	public static final CubeController mCubeController = new CubeController();
	public static final IntakeArm mIntakeArm = new IntakeArm();
	/*
	 * Declare CANTalon (TalonSRX) objects
	 */

	/*
	 * Declare sensor objects
	 */
	
	
	/*
	 * Declare Pnuematic jazz
	 */

	/*
	 * Declare subsystems for the robot
	 */

	/**
	 * When the robot first boots up, initialize all of the gamepads, motor
	 * controllers, sensors, and subsystems
	 */
	public void robotInit() {
        DigitalInput forwardLimitSwitch = new DigitalInput(9);
		/*
		 * Initialize gamepads
		 */
        mOI = new OI();
		/*
		 * Initialize CANTalons (TalonSRX's)
		 */
		/*
		 * Initialize Pneumatic stuff
		 */
		
		/*
		 * Initialize sensors
		 */
		
		/*
		 * Initialize subsystems
		 */
		/*
		driveTrain = new OldDriveTrain(flMotor, blMotor, frMotor, brMotor, navx, flEncoder, blEncoder, frEncoder, brEncoder);
		intake = new Scrounger(intakeMotor);
		climber = new Climber(climbMotor);
		shooter = new Shooter(launchMotor, feederMotor, agitatorMotor, shooterEncoder);
		gearMech = new GearRod(gearPusher);
		*/

	}

	/**
	 * Initialize whatever you need to when the robot becomes disables
	 */
	public void disabledInit() {
//		isAuto = false;
//		Scheduler.getInstance().add(new AutoConfiguration());
		CameraServer.getInstance().startAutomaticCapture(); 
		CameraServer.getInstance().putVideo("Camera output", 1280, 720);
	}

	/**
	 * Runs constantly when the robot is disabled. Good for displaying stuff to
	 * the driver station
	 */
	public void disabledPeriodic() {
	//	Scheduler.getInstance().run(); // Run scheduler
//		DriverStation.reportError("X Button if the robot is on the left side, Y for middle, B for right.", false);
//		if (OI.is0APressed()) {
//			Scheduler.getInstance().add(new LLeft());
//			DriverStation.reportError("A pressed", false);
//		}
		//System.out.println("Ultrasonic" + ultrasonic.getRangeInches());
		
		/*System.out.println("flE:" + flEncoder.getDistance());
		System.out.println("blE:" + blEncoder.getDistance());
		System.out.println("frE:" + frEncoder.getDistance());
		System.out.println("brE:" + brEncoder.getDistance());*/
		
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
		
		//System.out.println("Autotype: " + autoType);
			
//		CameraServer.getInstance().getVideo();
		
//		SmartDashboard.putNumber("LEFT DISTANCE: ", mDriveTrain.getLeftDistance());
	}

	/**
	 * Initialize whatever you need to when the robot starts autonomous
	 */
	
	public void autonomousInit() {
		/*
		isAuto = true;
		Scheduler.getInstance().add(new AutoConfiguration());
		Scheduler.getInstance().run();
		*/
//		Scheduler.getInstance().add(new LLeft());
		Scheduler.getInstance().add(new LMiddle());
		//DriverStation.reportError("SOMETHING", false);
	}

	/**
	 * Runs constantly when autonomous is enabled
	 */
	public void autonomousPeriodic() {
//		Scheduler.getInstance().add(new LLeft());
		Scheduler.getInstance().run(); // Run scheduler
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
		
	}
	
	/**
	 * Initialize whatever you need to when the robot starts teleop
	 */
	public void teleopInit() {
		DriverStation.reportError("HELP ME", false);
		Scheduler.getInstance().add(new DriveGroup()); // Add DriveGroup to
														// scheduler
		//mDriveTrain.clearEncoder();
	}

	/**
	 * Runs constantly when teleop is enabled
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run(); // Run Scheduler
//		limitSwitchValue = mLimitSwitch.getSwitchPressed();
//		DriverStation.reportError("Pressed: " + limitSwitchValue, false);
		SmartDashboard.putNumber("TELEOP left: ", mDriveTrain.getLeftDistance());
	}

	/**
	 * Runs constantly when test mode is enabled
	 */
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
