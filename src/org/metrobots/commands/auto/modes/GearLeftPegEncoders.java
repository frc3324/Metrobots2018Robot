package org.metrobots.commands.auto.modes;

import org.metrobots.commands.auto.Brake;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.DriveForwardDistance;
import org.metrobots.commands.auto.DriveForwardUltrasonic;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.PlaceGear;
import org.metrobots.commands.auto.PlaceGearTime;
import org.metrobots.commands.auto.ShootGear;
import org.metrobots.commands.auto.ZeroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearLeftPegEncoders extends CommandGroup {
	public GearLeftPegEncoders() {
		this.addSequential(new DriveForwardDistance(-0.5, 850));
		this.addSequential(new Pause(0.15));
		this.addSequential(new ZeroTurn(50, 0.5));
		this.addSequential(new Pause(0.75));
		this.addSequential(new PlaceGearTime(4));
		this.addSequential(new DriveForward(-0.25, 1.25)); //was 1
		this.addSequential(new Brake(true));
		this.addSequential(new Pause(0.25));
		this.addSequential(new DriveForward(-0.1, 10));
		//this.addSequential(new ShootGear());
		/*this.addParallel(new Pause(0.5));
		this.addSequential(new DriveForward(0.5, 0.5));
		this.addSequential(new Pause(0.5));
		this.addSequential(new ZeroTurn(-60, 0.5));
		this.addSequential(new Pause(0.5));
		this.addSequential(new Brake(false));
		this.addSequential(new DriveForwardDistance(-1.0, 1500));*/
		//this.addSequential(new ShootGear());
	}
}
