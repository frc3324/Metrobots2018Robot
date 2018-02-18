package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LMiddle extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN THIS
    public LMiddle() {
    	
    	//test rotate
    	this.addParallel(new Rotate(90, 0.5));
//    	this.addSequential(new DriveForward(5));
//    	this.addSequential(new Rotate(-90, 1));
//    	this.addSequential(new DriveForward(5));
//    	this.addSequential(new Rotate(90, 1));
//    	this.addSequential(new DriveForward(5));
    	//addSequential(new arm);
    	
    }
}

