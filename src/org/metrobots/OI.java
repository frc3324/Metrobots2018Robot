package org.metrobots;

import org.metrobots.commands.teleop.Outtake;
import org.metrobots.commands.teleop.ArmBackward;
import org.metrobots.commands.teleop.ArmBackwardSwitch;
import org.metrobots.commands.teleop.ArmForward;
import org.metrobots.commands.teleop.ArmForwardSwitch;
import org.metrobots.commands.teleop.ClimberSlideDown;
import org.metrobots.commands.teleop.ClimberSlideUp;
import org.metrobots.commands.teleop.Intake;
//import org.metrobots.commands.teleop.Outtake;
//import org.metrobots.commands.teleop.Intake;
//import org.metrobots.commands.teleop.Climb;
//import org.metrobots.commands.teleop.Intake;
//import org.metrobots.commands.teleop.MoveArm;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static XboxController gamepad0 = new XboxController(0);
	private static XboxController gamepad1 = new XboxController(1);
	
	private int val = 0;
	
	/**
	 * Primary driver buttons assignments
	 */
	Button aButton0 = new JoystickButton(gamepad0, MetroController.BUTTON_A);
	
	/**
	 * Secondary driver buttons assignments
	 */
	Button aButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_A);
	Button bButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_B);
	Button xButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_X);
	Button yButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_Y);
	Button backButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_BACK);
	Button startButton1 = new JoystickButton(gamepad1, MetroController.BUTTON_START);
	
	Button leftBumper1 = new JoystickButton(gamepad1, MetroController.LB);
	Button rightBumper1 = new JoystickButton(gamepad1, MetroController.RB);
	
	/**
	 * Controller buttons.
	 * 
	 * aButton -> PressureSwitch
	 * bButton -> MoveArm
	 * 
	 */
	public OI() {
		
		/** Primary driver gamepad (gamepad0)
		 * 
		 */
//		aButton0.whenPressed(new PressureSwitch());
		
		/**
		 * Secondary driver gamepad (gamepad1)
		 */
		
		backButton1.whenPressed(new ClimberSlideUp());
		startButton1.whenPressed(new ClimberSlideDown());
		
		leftBumper1.whenPressed(new Intake());
		rightBumper1.whenPressed(new Outtake());
		xButton1.whenPressed(new ArmBackward());
		aButton1.whenPressed(new ArmBackwardSwitch());
		bButton1.whenPressed(new ArmForwardSwitch());
		yButton1.whenPressed(new ArmForward());
//		rightBumper1.whenPressed(new Outtake());
		
//		aButton1.whenPressed(new MoveForward());
//		bButton1.whenPressed(new MoveForwardSwitch());
//		xButton1.whenPressed(new MoveBackwardSwitch());
//		yButton1.whenPressed(new MoveBackward());
//		
//		leftBumper1.whenPressed(new );
//		aButton.whenPressed(new PressureSwitch());
		//		if (inTakeEnable = false) {
//			yButton.whenPressed(new Outtake());;
//			inTakeEnable = true;
//		}
//		else {
//			leftBumper.whenPressed(new StopIntake());
//			inTakeEnable = false;
//		}
//		if (inTakeEnable = false) {
//			rightBumper.whenPressed(new ());
//			inTakeEnable = true;
//		}
//		else {
//			leftBumper.whenPressed(new StopIntake());
//			inTakeEnable = false;
//		}
		
		
		
		SmartDashboard.putNumber("have OI", val);
		val++;
		
		/**
		 * Secondary driver gamepad (gamepad1)
		 */
		
//		leftBumper.whileHeld(new Intake());
//		rightBumper.whileHeld(new Outtake());
		//yButton.whileHeld(new Climb()); //Actually, make this a trigger, b/c not enough buttons 
	}
//	public static double get0LeftY () {
//		return gamepad0.getY(Hand.kLeft);
//		
//	}
//	
//	public static double get0LeftX () {
//		return gamepad0.getX(Hand.kLeft);
//		
//	}
//	
//	public static double get0RightX () {
//		return gamepad0.getX(Hand.kRight);
//		
//	}
//	
//	public static double get0RightY () {
//		return gamepad0.getY(Hand.kRight);
//		
//	}
	/**
	 * Determine if the A button is pressed on the primary driver controller.
	 * @return true or false
	 */
	
	public static boolean is0APressed() {
		return gamepad0.getAButtonPressed();
	}
	
	/**
	 * Determine if the B button is pressed on the primary driver controller.
	 * @return true or false
	 */
	public static boolean is0BPressed() {
		return gamepad0.getBButton();
	}
	
	/**
	 * Determine if the X button is pressed on the primary driver controller.
	 * @return true or false
	 */
	public static boolean is0XPressed() {
		return gamepad0.getXButton();
	}
	
	/**
	 * Determine if the Y button is pressed on the primary driver controller.
	 * @return true or false
	 */
	public static boolean is0YPressed() {
		return gamepad0.getYButtonPressed();
	}
	
	public static boolean is1APressed() {
		return gamepad1.getAButtonPressed();
	}
	
	public static boolean is1BPressed() {
		return gamepad1.getBButtonPressed();
	}
	
	public static boolean is1XPressed() {
		return gamepad1.getXButtonPressed();
	}
	
	public static boolean is1YPressed() {
		return gamepad1.getYButtonPressed();
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

