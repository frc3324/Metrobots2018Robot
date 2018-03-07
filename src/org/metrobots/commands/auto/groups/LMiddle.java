package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.RotatePID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class LMiddle extends CommandGroup {

    public LMiddle() {

    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(65));
    	this.addSequential(new RotatePID(-90, 1));
    	this.addSequential(new MoveArm(11.75));
//    	this.addParallel(new MoveArm(0));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(36));
    	this.addSequential(new RotatePID(90, 1));
    	this.addSequential(new DriveForward(65));
    	this.addSequential(new CubeControl(-0.5));
    	
    }
}

