package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class RMiddle extends CommandGroup {

    public RMiddle() {
    	this.addSequential(new DriveForward(60*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));
    	this.addSequential(new DriveForward(72*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(44*0.6716417904477, 1));
    	this.addSequential(new CubeControl(-0.4, 2));
    	this.addSequential(new DriveForward(-30*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));
    	this.addSequential(new DriveForward(36*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(108*0.6716417904477, 1));
    	this.addSequential(new Rotate(-90,0));
    	this.addSequential(new DriveForward(161.25*0.6716417904477, 1));
    	this.addSequential(new Rotate(90,0));




    }

}
