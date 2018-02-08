package src.org.metrobots.commands.auto.groups;

import src.org.metrobots.commands.auto.DriveForward;
import src.org.metrobots.commands.auto.Rotate;
import src.org.metrobots.subsystems.IntakeArm;
import src.org.metrobots.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LLmiddle extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN THIS
    public LLmiddle() {
    	
    	addSequential(new DriveForward(0.5, 5));
    	addSequential(new Rotate(-90, 1));
    	addSequential(new DriveForward(0.5, 5));
    	addSequential(new Rotate(90, 1));
    	addSequential(new DriveForward(0.5, 5));
    	//addSequential(new arm);
    	
    	    }

	public void addSequential(Rotate rotate) {
		
		
	}

	public void addSequential(DriveForward driveForward) {
		
		
	}
	
	public void addSequential()
	
	
}
