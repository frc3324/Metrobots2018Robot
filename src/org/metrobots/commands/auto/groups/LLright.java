package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import src.org.metrobots.commands.auto.DriveForward;

/**
 *
 */
public class LLright extends CommandGroup {
//THIS IS ARBITRARY DO NOT RUN
    public LLright() {
        addSequential(new DriveForward(.5, 18));
    }

	private void addSequential(DriveForward driveForward) {
		// TODO Auto-generated method stub
		
	}
}