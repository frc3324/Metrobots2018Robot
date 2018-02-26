package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Outtake;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in foremost left of the left driverstation.
 */
public class LLeft extends CommandGroup {

    public LLeft() {
    	
    	this.addSequential(new DriveForward(192));
    	this.addSequential(new GyroReset());
    	this.addParallel(new Rotate(90));
    	this.addParallel(new MoveArm(0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(37));
    	this.addSequential(new MoveArm(33.25));
    	this.addSequential(new Outtake());
    }
}
