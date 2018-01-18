package org.metrobots.commands.teleop;

import org.metrobots.subsystems.Scrounger;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop control of scrounger mechanism<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 */
public class IntakeFuel extends Command {

	public Scrounger scrounger;
	private MetroController gamepad;

	/**
	 * Get the objects necessary to operate the shooter
	 * 
	 * @param scr
	 *            scrounger object
	 * @param gp
	 *            handheld controller for operating scrounger
	 */
	public IntakeFuel(Scrounger scr, MetroController gp) {
		scrounger = scr;
		gamepad = gp;
	}

	/**
	 * Function constantly run during teleop. Controls:<br>
	 * <b>Right Bumper</b>: scrounge
	 */
	public void execute() {
		if (gamepad.getButton(MetroController.LB)) {
			scrounger.intake(-1);
		} else if (gamepad.getAxis(MetroController.LT) > 0.1) {
			scrounger.intake(1);
		} else {
			scrounger.intake(0);
		}
	}

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
