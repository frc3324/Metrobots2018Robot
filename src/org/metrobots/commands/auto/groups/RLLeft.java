package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;

/**
 *
 */
public class RLLeft extends CommandGroup {
//ALL NUMBERS ARE ARBITRARY DO NOT RUN
    public RLLeft() {
    	this.addSequential(new DriveForward(18));
    	
    }

}
