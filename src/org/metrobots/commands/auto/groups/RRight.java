package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 *
 */
public class RRight extends CommandGroup {
	
    public RRight() {

//    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(100));
    	this.addSequential(new Rotate(-90));
//    	this.addSequential(new MoveArm(11.75));
//    	this.addParallel(new MoveArm(0));
//    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(37));
    	this.addSequential(new CubeControl(-0.5, 2));
    	
    }

}
