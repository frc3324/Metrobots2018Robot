package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.JaciPathfinding;
import org.metrobots.commands.auto.JaciPathfindingInvert;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.util.JaciFinder;
import org.metrobots.util.TrajContainer;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JaciTest extends CommandGroup {

    public JaciTest() {
//    	JaciFinder mJa nnnciFinder = new JaciFinder();
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
//    	SmartDashboard.putBoolean("Wt", true);
    	addSequential(new JaciPathfinding(1, 1, 0));
    	addSequential(new Rotate(90, 1));
    	addSequential(new JaciPathfindingInvert(1, 1, 0));
    	addSequential(new Rotate(180,1));
//    	addSequential(new Rotate(-90, 1));
    	// To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
