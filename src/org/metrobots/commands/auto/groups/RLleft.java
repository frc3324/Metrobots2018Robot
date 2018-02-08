package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import src.org.metrobots.commands.auto.DriveForward;

/**
 *
 */
public class RLleft extends CommandGroup {
//ALL NUMBERS ARE ARBITRARY DO NOT RUN
    public RLleft() {
    	addSequential(new DriveForward(.5, 18));
    	
    }

	private void addSequential(DriveForward driveForward) {
		// TODO Auto-generated method stub
		
	}
}
