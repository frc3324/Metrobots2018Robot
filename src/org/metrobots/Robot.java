package org.metrobots;

import java.io.IOException;

import org.metrobots.botcv.communication.CommInterface;
import org.metrobots.commands.DriveGroup;
import org.metrobots.subsystems.Climber;
import org.metrobots.subsystems.DriveTrain;
import org.metrobots.subsystems.GearRod;
import org.metrobots.subsystems.Scrounger;
import org.metrobots.util.MetroController;
import org.metrobots.util.OpticalEncoder;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Client;

/**
 * Main robot code<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 * Feb 8: Added agitator Talon and stuff - Xander
 * 
 */
public class Robot extends TimedRobot {

	/*
	 * Declare gamepad objects
	 */
	
	public static final DriveTrain mDriveTrain = new DriveTrain();
	
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
	public static Scrounger intake;
	public static Climber climber;
	public static GearRod gearMech;
	
	public String autoType = "LEFTGEAR";

	/**
	 * When the robot first boots up, initialize all of the gamepads, motor
	 * controllers, sensors, and subsystems
	 */
	public void robotInit() {
		/*
		 * Initialize gamepads
		 */
	
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
	}

	/**
	 * Runs constantly when the robot is disabled. Good for displaying stuff to
	 * the driver station
	 */
	public void disabledPeriodic() {
		Scheduler.getInstance().run(); // Run scheduler
		
		//System.out.println("Ultrasonic" + ultrasonic.getRangeInches());
		
		/*System.out.println("flE:" + flEncoder.getDistance());
		System.out.println("blE:" + blEncoder.getDistance());
		System.out.println("frE:" + frEncoder.getDistance());
		System.out.println("brE:" + brEncoder.getDistance());*/
		
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
		
		//System.out.println("Autotype: " + autoType);
		
	}

	/**
	 * Initialize whatever you need to when the robot starts autonomous
	 */
	public void autonomousInit() {
		
		
	}

	/**
	 * Runs constantly when autonomous is enabled
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run(); // Run scheduler
		//System.out.println("dir: " + comms.getDirection() + " mag:" + comms.getMagnitude());
		//System.out.println("x: " + comms.getXOffset() + " y:" + comms.getYOffset());
	}
	
	/**
	 * Initialize whatever you need to when the robot starts teleop
	 */
	public void teleopInit() {
		Scheduler.getInstance().add(new DriveGroup()); // Add DriveGroup to
														// scheduler
	}

	/**
	 * Runs constantly when teleop is enabled
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run(); // Run Scheduler
		 
	}

	/**
	 * Runs constantly when test mode is enabled
	 */
	public void testPeriodic() {
		//LiveWindow.run();
	}
}
