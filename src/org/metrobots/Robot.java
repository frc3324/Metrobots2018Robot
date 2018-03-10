package org.metrobots;

import java.io.IOException;

import org.metrobots.commands.AutoConfiguration;
//import org.metrobots.commands.AutoConfiguration;
import org.metrobots.commands.DriveGroup;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.DriveForward;
//import org.metrobots.commands.auto.DriveForwardTime;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.groups.LLeft;
//import org.metrobots.commands.auto.groups.LLeft;
//import org.metrobots.commands.auto.groups.LMiddle;
//import org.metrobots.commands.auto.groups.LL;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.subsystems.Climber;
import org.metrobots.subsystems.CubeController;
import org.metrobots.subsystems.DriveTrain;
//import org.metrobots.util.LimitSwitch;
import org.metrobots.subsystems.Gyro;
import org.metrobots.subsystems.IntakeArm;
import org.metrobots.subsystems.LimitSwitch;
import org.metrobots.subsystems.PIDStabilization;
import org.metrobots.subsystems.Pneumatics;
import org.metrobots.util.StatusLED;

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
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
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
	public static boolean isAuto = false;
//	public static final LimitSwitch mLimitSwitch = new LimitSwitch();
	public static boolean limitSwitchValue = false;  
	double encoderValue;
	Command setAutoCommand;
	
	/*
	 * Declare gamepad objects
	 */
	public OI mOI;
	public static final DriveTrain mDriveTrain = new DriveTrain();
	public static final Gyro mGyro = new Gyro();
	public static final CubeController mCubeController = new CubeController();
	public static final PIDStabilization mPIDStabilzation = new PIDStabilization();
	public static final IntakeArm mIntakeArm = new IntakeArm();
	public static final Climber mClimber = new Climber();
	public static final AutoConfiguration mConfiguration = new AutoConfiguration();
	public static final Pneumatics mPneumatics = new Pneumatics();
	public static final LimitSwitch mLimitSwitch = new LimitSwitch();
//	public static final StatusLED mStatusLED = new StatusLED();

	
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
	 * 
	 */

	public void robotInit() {
        SmartDashboard.putData(mClimber);
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
//        SmartDashboard.putData(Robot.mClimber);

	}

	/**
	 * Initialize whatever you need to when the robot becomes disables
	 */
	public void disabledInit() {
//		isAuto = false;
//		Scheduler.getInstance().add(new AutoConfiguration());
		CameraServer.getInstance().startAutomaticCapture(); 
		CameraServer.getInstance().putVideo("Camera output", 1280, 720);
//		SmartDashboard.clearPersistent("");
	}

	/**
	 * Runs constantly when the robot is disabled. Good for displaying stuff to
	 * the driver station
	 */
	public void disabledPeriodic() {
//		DriverStation.reportError("X Button if the robot is on the left side, Y for middle, B for right.", false);
		//System.out.println("Ultrasonic" + ultrasonic.getRangeInches());
		
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
			
//		CameraServer.getInstance().getVideo();
		
//		SmartDashboard.putNumber("LEFT DISTANCE: ", mDriveTrain.getLeftDistance());
		
		/***************************************************/
//		Scheduler.getInstance().add(new AutoConfiguration());
//		Scheduler.getInstance().run();
//		setAutoCommand = mConfiguration.getAutoCommand();
//		DriverStation.reportError("Supposed command: " + setAutoCommand, false);
//		mIntakeArm.printEncoder();
		/***************************************************/
		
	}

	/**
	 * Initialize whatever you need to when the robot starts autonomous
	 */
	
	public void autonomousInit() {
		
//		isAuto = true;
//		Scheduler.getInstance().add(new AutoConfiguration());
//		Scheduler.getInstance().run();
		
//		Scheduler.getInstance().add(new LLeft());
//		Scheduler.getInstance().add(new LMiddle());
		//DriverStation.reportError("SOMETHING", false);
//		Scheduler.getInstance().add(setAutoCommand);
//		Scheduler.getInstance().run();
//		setAutoCommand.start();
//		autoCommand = new DriveForward(192);
		
//		if (autoCommand != null) {
			//autoCommand.start();
//			Scheduler.getInstance().add(new DriveForward(192));
//		Scheduler.getInstance().add(new CubeControl(-1.0)); //-0.3 for switch
//		Scheduler.getInstance().add(new LLeft());
		/*******************CODETHATWORKS**************************/
		Robot.mIntakeArm.resetEncoder();
		Scheduler.getInstance().add(new DriveForward(76.78));
//		Scheduler.getInstance().add(new RotatePID1());
		/*******************CODETHATWORKS**************************/
//		}
    	
    	
    	//Only if DriveForward running
//    	Scheduler.getInstance().add(new DriveForward(192));
//    	DriverStation.reportError("Auto name" + Scheduler.getInstance().getName(), false);
	}

	/**
	 * Runs constantly when autonomous is enabled
	 */
	public void autonomousPeriodic() {
		/*******************CODETHATWORKS**************************/
		Scheduler.getInstance().run(); // Run scheduler
		/*******************CODETHATWORKS**************************/
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
	}
	
	/**
	 * Initialize whatever you need to when the robot starts teleop
	 */
	public void teleopInit() {
		Scheduler.getInstance().add(new DriveGroup());
		//mDriveTrain.clearEncoder();
	}

	/**
	 * Runs constantly when teleop is enabled
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		limitSwitchValue = mLimitSwitch.getSwitchPressed();
//		DriverStation.reportError("Pressed: " + limitSwitchValue, false);
//		SmartDashboard.putNumber("TELEOP left: ", mDriveTrain.getLeftDistance());
		SmartDashboard.putNumber("1Right y", OI.get1RightY());
	}

	/**
	 * Runs constantly when test mode is enabled
	 */
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
