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
    	
    	this.addSequential(new DriveForward(-50));
    	this.addSequential(new Rotate(90, 1));
    	//this.addSequential(new );
    	this.addSequential(new Rotate(-90, 1));
    	this.addSequential(new DriveForward(5));
    	
    }
}
