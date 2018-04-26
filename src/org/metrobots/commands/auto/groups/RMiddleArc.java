package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.DriveArc;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RMiddleArc extends CommandGroup {

    public RMiddleArc() {
    	this.addSequential(new DriveArc(90.0, 16.82)); //24.5 inches
        this.addSequential(new DriveArc(-90.0, 16.82));
        this.addSequential(new DriveForward(28.84, 1.0)); //42 inches
        this.addSequential(new CubeControl(-0.5, 1.0));
        this.addSequential(new DriveForward(7.53, -1.0)); //20 inches
        this.addSequential(new Rotate(90.0, 0.0));
        this.addSequential(new DriveForward(9.96, 1.0)); //14.25 inches
        this.addSequential(new DriveArc(-90, 98.88));
    }
}
