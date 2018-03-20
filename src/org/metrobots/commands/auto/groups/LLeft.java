package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in foremost left of the left driverstation.
 */
public class LLeft extends CommandGroup {

    public LLeft() {
    	
    	this.addSequential(new DriveForward(100)); //was 192
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90));
//    	this.addSequential(new MoveArm(11.75));
//    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(26));
    	this.addSequential(new CubeControl(-0.5, 2));
    }
}
