//this code was causing compiling warnings and preventing it from compiling
package org.metrobots.commands.teleop;

import org.metrobots.subsystems.GearRod;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.command.Command;

public class GearPlacement extends Command {
	private GearRod gearMech;
	private MetroController gamepad;
	
	public GearPlacement(GearRod gear, MetroController mgp) {
		gearMech = gear;
		gamepad = mgp;
	}
	
	public void execute () {
		if (gamepad.getButton(MetroController.RIGHT_CLICK)) {
			gearMech.ejectGear();
		} else if (gamepad.getButton(MetroController.LEFT_CLICK)) {
			gearMech.unejectGear();
		} else {
			gearMech.disablePusher();
		}
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void initialize() {}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}