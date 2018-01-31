package org.metrobots.commands.teleop;

import org.metrobots.subsystems.Climber;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop control of climbing mechanism<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 */
public class Climb extends Command {

	public Climber climber;
	private MetroController gamepad;

	/**
	 * Get the objects necessary to operate the climber
	 * 
	 * @param cl
	 *            climber object
	 * @param gp
	 *            handheld controller for operating shooter
	 */
	public Climb(Climber cl, MetroController gp) {
		climber = cl;
		gamepad = gp;
	}

	/**
	 * Function constantly run during teleop. Controls:<br>
	 * <b>Y</b>: spin climb winch
	 */
	public void execute() {
		//if(gamepad.getButton(MetroGamepad.BUTTON_A))
		//	climber.climb(true);//This will never stop
		climber.climb(gamepad.getButton(MetroController.BUTTON_A));
	}

	/*
	 * Necessary function that returns false.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
