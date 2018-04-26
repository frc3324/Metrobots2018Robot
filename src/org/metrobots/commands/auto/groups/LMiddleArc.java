package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.DriveArc;
import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	ARCODE (angle, radius)
Changing radius:
Parameters: (140, 10) to Speeds: Outside (1.0) Inside ()
Parameters: (140, 20) to Speeds: Outside (1.0) Inside (0.28)
Parameters: (140, 30) to Speeds: Outside (1.0) Inside (0.4545454545)
Parameters: (140, 40) to Speeds: Outside (1.0) Inside (0.560975609)
Parameters: (140, 50) to Speeds: Outside (1.0) Inside (0.632653061)
 */
public class LMiddleArc extends CommandGroup {

    public LMiddleArc() {
        this.addSequential(new DriveArc(-90.0, 20.26)); // ~29.5 inches
        this.addSequential(new DriveArc(90.0, 20.26));
        this.addSequential(new DriveForward(28.84, 1.0)); //42 inches
        this.addSequential(new CubeControl(-0.5, 1.0));
        this.addSequential(new DriveForward(7.53, -1.0)); //20 inches
        this.addSequential(new Rotate(-90.0, 0.0));
        this.addSequential(new DriveForward(2.06, 1.0)); //3 inches
        this.addSequential(new DriveArc(90.0, 98.88)); //144 inches
    }
}
