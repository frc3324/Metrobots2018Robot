package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveArc;

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
public class TestArc extends CommandGroup {

    public TestArc() {
        this.addSequential(new DriveArc(130, 20));
    }
}
