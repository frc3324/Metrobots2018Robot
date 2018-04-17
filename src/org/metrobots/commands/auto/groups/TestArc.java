package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestArc extends CommandGroup {

    public TestArc() {
        this.addSequential(new DriveArc(140, 20));
    }
}
