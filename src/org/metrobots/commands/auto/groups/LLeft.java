package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.Rotate;
//import org.metrobots.commands.auto.TestMotor;

/**
 *
 */
public class LLeft extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN
    public LLeft() {
    	
    	this.addSequential(new DriveForward(60));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90));
    	this.addSequential(new GyroReset());
    	//arm
    	this.addSequential(new Rotate(-90));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(50));
    	
    }
}
