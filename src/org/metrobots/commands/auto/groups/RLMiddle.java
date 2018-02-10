package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

/**
 *
 */
public class RLMiddle extends CommandGroup {
//ALL NUMBERS ARE ARBITRARY DO NOT RUN
    public RLMiddle() {
    	this.addSequential(new DriveForward(5));
    	this.addSequential(new Rotate(90, 1));
    	this.addSequential(new DriveForward(5));
    	this.addSequential(new Rotate(-90, 1));
    	this.addSequential(new DriveForward(5));
    	//addSequential(new arm);
    }

}
