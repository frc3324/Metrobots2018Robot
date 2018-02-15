package org.metrobots;

//import org.metrobots.commands.teleop.Intake;
//import org.metrobots.commands.teleop.Climb;
//import org.metrobots.commands.teleop.Intake;
//import org.metrobots.commands.teleop.MoveArm;
//import org.metrobots.commands.teleop.Outtake;
import org.metrobots.commands.teleop.PressureSwitch;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	static XboxController gamepad0 = new XboxController(0);
	static XboxController gamepad1 = new XboxController(1);
	
	/**
	 * Primary driver buttons assignments
	 */
	
	/**
	 * DO NOT USE FOR SECONDARY DRIVER (x, y, a, b)
	 */
	Button aButton = new JoystickButton(gamepad1, MetroController.BUTTON_A);
	Button bButton = new JoystickButton(gamepad1, MetroController.BUTTON_B);
	Button xButton = new JoystickButton(gamepad1, MetroController.BUTTON_X);
	Button yButton = new JoystickButton(gamepad1, MetroController.BUTTON_Y);
	
	Button leftBumper = new JoystickButton(gamepad1, MetroController.LB);
	Button rightBumper = new JoystickButton(gamepad1, MetroController.RB);
	
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
		aButton.whenPressed(new PressureSwitch());
		
		/**
		 * Secondary driver gamepad (gamepad1)
		 */
//		leftBumper.whileHeld(new Intake());
//		rightBumper.whileHeld(new Outtake());
		//yButton.whileHeld(new Climb()); //Actually, make this a trigger, b/c not enough buttons 
	}
	
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

