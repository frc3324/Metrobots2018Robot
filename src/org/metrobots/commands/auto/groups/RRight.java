package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

/**
 *
 */
public class RRight extends CommandGroup {
//ALL CODE IS ARBITRARY DO NOT RUN
    public RRight() {

    	this.addSequential(new DriveForward(5));
    	this.addSequential(new Rotate(-90, 1));
    	//addSequential(new arm)
    	this.addSequential(new Rotate(90, 1));
    	this.addSequential(new DriveForward(5));
    	
    }

}
