package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import src.org.metrobots.commands.auto.DriveForward;
import src.org.metrobots.commands.auto.Rotate;

/**
 *
 */
public class RLmiddle extends CommandGroup {
//ALL NUMBERS ARE ARBITRARY DO NOT RUN
    public RLmiddle() {
    	addSequential(new DriveForward(0.5, 5));
    	addSequential(new Rotate(90, 1));
    	addSequential(new DriveForward(0.5, 5));
    	addSequential(new Rotate(-90, 1));
    	addSequential(new DriveForward(0.5, 5));
    	//addSequential(new arm);
    }

	private void addSequential(DriveForward driveForward) {
		// TODO Auto-generated method stub
		
	}

	private void addSequential(Rotate rotate) {
		// TODO Auto-generated method stub
		
	}
}
