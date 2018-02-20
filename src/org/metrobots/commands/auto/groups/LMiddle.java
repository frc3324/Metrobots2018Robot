package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.DriveForward1;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.RotatePID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LMiddle extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN THIS
    public LMiddle() {
    	
    	//test rotate
    	//this.addParallel(new Rotate(90, 0.5));
    	this.addSequential(new DriveForward1(60));
    	this.addSequential(new DriveForward1(60));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90));
    	this.addSequential(new GyroReset());
//    	this.addSequential(new DriveForward(5));
//    	this.addSequential(new Rotate(90, 1));
//    	this.addSequential(new DriveForward(5));
    	//addSequential(new arm);
    	
    }
}

