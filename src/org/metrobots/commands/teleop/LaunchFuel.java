package org.metrobots.commands.teleop;

import org.metrobots.Constants;
import org.metrobots.subsystems.Shooter;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop control of shooter mechanism<br>
 * <br>
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 * Feb 8: Added agitator. - Xander
 * 
 */
public class LaunchFuel extends Command {

	public Shooter shooter;
	private MetroController gamepad;

	

	/**
	 * Get the objects necessary to operate the shooter
	 * 
	 * @param sh
	 *            shooter object
	 * @param gp
	 *            handheld controller for operating shooter
	 */
	public LaunchFuel(Shooter sh, MetroController gp) {
		shooter = sh;
		shooter.enable();
		gamepad = gp;
	}

	/**
	 * Function constantly run during teleop. Controls:<br>
	 * <b>X</b>: set RPM to speed for key<br>
	 * <b>Y</b>: stop shooter<br>
	 * <b>B</b>: load fuel into shooter, if it is up to speed
	 */
	public void execute() {
		if (gamepad.getButton(MetroController.BUTTON_X)) {
			//shooter.flywheel.set(Constants.kFlywheelSpeed);
			shooter.setTargetSpeed(Constants.keyShootingRPM);
		} else if (gamepad.getButton(MetroController.BUTTON_Y)) {
			shooter.setTargetSpeed(0);
			//shooter.flywheel.set(0);
		}
		shooter.agitate(gamepad.getAxis(MetroController.LEFT_Y));
		if (gamepad.getButton(MetroController.BUTTON_B)) {
			shooter.feed(true);
			//shooter.agitate(true);
		} else {
			shooter.feed(false);
			//shooter.agitate(false);
		}
		//shooter.modulateShooterSpeed(gamepad.getAxis(MetroGamepad.RIGHT_Y));
			
		
	}

	/*
	 * Necessary function that returns false.
	 */
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