package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

/**
 *
 */
public class LLLeft extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN
    public LLLeft() {
    	
    	this.addSequential(new DriveForward(0.5, 5));
    	this.addSequential(new Rotate(90, 1));
    	//addSequential(new arm)
    	this.addSequential(new Rotate(-90, 1));
    	this.addSequential(new DriveForward(.5, 5));
    	
    }
}
