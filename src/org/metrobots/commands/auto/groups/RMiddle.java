package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class RMiddle extends CommandGroup {

    public RMiddle() {
    	this.addSequential(new Pause(0.5));
    	this.addSequential(new DriveForward(25));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
//    	this.addSequential(new MoveArm(11.75));
//    	this.addParallel(new MoveArm(0));
    	this.addSequential(new Pause(0.5));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(36));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(32));
    	this.addSequential(new Pause(0.01));
    	this.addSequential(new CubeControl(-0.4, 2));
    }

}
