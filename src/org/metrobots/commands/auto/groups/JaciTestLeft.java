package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.JaciPathfinding;
import org.metrobots.commands.auto.JaciPathfinding2;
import org.metrobots.commands.auto.JaciPathfindingInvert1;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.util.JaciFinder;
import org.metrobots.util.TrajContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JaciTestLeft extends CommandGroup {

    public JaciTestLeft() {
    	addSequential(new JaciPathfinding(0, 0, 0, 3.556, -1.8288, 0));
    	addSequential(new Pause(1));
    	addSequential(new DriveForward(-20, 1));
    	addSequential(new Rotate(45, 1));
    	addSequential(new DriveForward(25, 1));
    	addSequential(new DriveForward(-25, 1));
    	addSequential(new Rotate(-45, 1));
    	addSequential(new DriveForward(20, 1));
//    	addSequential(new JaciPathfindingInvert1(3.556, -1.8288, 0, 3.048 , -0.9144, 45));
//    	addSequential(new Pause(1));
//    	addSequential(new JaciPathfinding2(3.048 , -0.9144, 45, 3.429, -0.4572, 45));
//    	addSequential(new Pause(1));
//    	addSequential(new JaciPathfinding2(3.429, -0.4572, 45, 3.048, -0.9144, 45));
//    	addSequential(new Pause(1));
//    	addSequential(new JaciPathfinding(3.048 , -0.9144, 45, 3.556, -1.8288, 0));
    }
}
