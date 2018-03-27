package org.metrobots;

import java.io.IOException;

import org.metrobots.commands.DriveGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.RotatePID;
import org.metrobots.commands.auto.groups.LLeft;
import org.metrobots.commands.auto.groups.LMiddle;
import org.metrobots.commands.auto.groups.LRight;
import org.metrobots.commands.auto.groups.RLeft;
import org.metrobots.commands.auto.groups.RMiddle;
import org.metrobots.commands.auto.groups.RRight;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.subsystems.Climber;
import org.metrobots.subsystems.CubeController;
import org.metrobots.subsystems.DriveTrain;
import org.metrobots.subsystems.Gyro;
import org.metrobots.subsystems.IntakeArm;
import org.metrobots.subsystems.LimitSwitch;
import org.metrobots.subsystems.PIDStabilization;
import org.metrobots.subsystems.Pneumatics;
import org.metrobots.util.StatusLED;

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
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	public static final Pneumatics mPneumatics = new Pneumatics();
	public static final LimitSwitch mLimitSwitch = new LimitSwitch();
	public static final StatusLED mStatusLED = new StatusLED();
//	public static final PowerDistributionPanel mPowerDistributionPanel = new PowerDistributionPanel();

	Command selectedCommand;
	SendableChooser<Integer> autoSelector = new SendableChooser<Integer>();

	String gameData;
	String infoString;
	int defaultSet = 0;
	int left = 1;
	int middle = 2;
	int right = 3;
	
	/**
	 * When the robot first boots up, initialize all of the gamepads, motor
	 * controllers, sensors, and subsystems
	 * 
	 */
	public void robotInit() {
        mOI = new OI();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        autoSelector.addDefault("Default", defaultSet);
    	autoSelector.addObject("Left position", left);
    	autoSelector.addObject("Middle position", middle);
    	autoSelector.addObject("Right position", right);
        SmartDashboard.putData("CHOOSE ONE", autoSelector);
	}

	/**
	 * Initialize whatever you need to when the robot becomes disables
	 */
	public void disabledInit() {
		CameraServer.getInstance().startAutomaticCapture(); 
		CameraServer.getInstance().putVideo("Camera output", 1280, 720);
//		SmartDashboard.clearPersistent("");
	}

	/**
	 * Runs constantly when the robot is disabled. Good for displaying stuff to
	 * the driver station
	 */
	public void disabledPeriodic() {
//		CameraServer.getInstance().getVideo();
		/***************************************************/
//		Scheduler.getInstance().add(new AutoConfiguration());
//		setAutoCommand = mConfiguration.getAutoCommand();
//		DriverStation.reportError("Supposed command: " + setAutoCommand, false);
//		Scheduler.getInstance().run();
		/***************************************************/
		
	}

	/**
	 * Initialize whatever you need to when the robot starts autonomous
	 */
	
	public void autonomousInit() {
		/*******************CODETHATWORKS**************************/
//		Robot.mIntakeArm.resetEncoder();
//		Scheduler.getInstance().add(new DriveForward(60)); //little less than 60
//		Scheduler.getInstance().add(new RotatePID1());
		/*******************CODETHATWORKS**************************/
		Robot.mGyro.clear();
		if (autoSelector.getSelected() == 0) {
			selectedCommand = new DriveForward(68);
			infoString = "Default set (driveForward)";
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == left) {
			infoString = "LLeft";
			selectedCommand = new LLeft();
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == middle) {
			infoString = "LMiddle";
			selectedCommand = new LMiddle();
		}
		else if (gameData.charAt(0) == 'L' && autoSelector.getSelected() == right) {
			infoString = "LRight";
			selectedCommand = new LRight();
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == left) {
			infoString = "RLeft";
			selectedCommand = new RLeft();
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == middle) {
			infoString = "RMiddle";
			selectedCommand = new RMiddle();
		}
		else if (gameData.charAt(0) == 'R' && autoSelector.getSelected() == right) {
			infoString = "RRight";
			selectedCommand = new RRight();
		}
		else {
			DriverStation.reportError("No game data received.", false);
			selectedCommand = new DriveForward(68);
		}
		Scheduler.getInstance().add(selectedCommand);
		SmartDashboard.putString("COMMENCING: ", infoString);
	}

	/**
	 * Runs constantly when autonomous is enabled
	 */
	public void autonomousPeriodic() {
		/*******************CODETHATWORKS**************************/
		Scheduler.getInstance().run(); // Run scheduler
		/*******************CODETHATWORKS**************************/
		
	}
	
	/**
	 * Initialize whatever you need to when the robot starts teleop
	 */
	public void teleopInit() {
		Scheduler.getInstance().add(new DriveGroup());
	}

	/**
	 * Runs constantly when teleop is enabled
	 */
	public void teleopPeriodic() {
//		mStatusLED.setStateHigh();
		Scheduler.getInstance().run();
	}

	/**
	 * Runs constantly when test mode is enabled
	 */
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
