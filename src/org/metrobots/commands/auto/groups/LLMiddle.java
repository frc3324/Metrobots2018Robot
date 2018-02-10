package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.subsystems.IntakeArm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LLMiddle extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN THIS
    public LLMiddle() {
    	
    	this.addSequential(new DriveForward(0.5, 5));
    	this.addSequential(new Rotate(-90, 1));
    	this.addSequential(new DriveForward(0.5, 5));
    	this.addSequential(new Rotate(90, 1));
    	this.addSequential(new DriveForward(0.5, 5));
    	//addSequential(new arm);
    	
    }
}

