package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.DriveForward1;
import org.metrobots.commands.auto.Rotate;
//import org.metrobots.commands.auto.TestMotor;

/**
 *
 */
public class LLeft extends CommandGroup {
//THIS IS ALL ARBITRARY DO NOT RUN
    public LLeft() {
    	
    	this.addSequential(new DriveForward1(60));
//    	this.addSequential(new Rotate(90, 1));
//    	//arm
//    	this.addSequential(new Rotate(-90, 1));
//    	this.addSequential(new DriveForward(5));
    	
    }
}
