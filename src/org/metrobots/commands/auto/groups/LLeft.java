package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in foremost left of the left driverstation.
 */
public class LLeft extends CommandGroup {

    public LLeft() {
    	
//    	this.addSequential(new Pause(0.5));
    	this.addSequential(new DriveForward(100, 1.0)); //was 192
//    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90, 0));
    	this.addSequential(new GyroReset());
//    	this.addSequential(new MoveArm(11.75));
//    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(30, 1));
    	this.addSequential(new CubeControl(-0.5, 2));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(15.0, -1.0));
    	this.addSequential(new Rotate(-90, 0));
    }
}
