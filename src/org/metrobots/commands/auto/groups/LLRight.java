package org.metrobots.commands.auto.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.metrobots.commands.auto.DriveForward;

/**
 *
 */
public class LLRight extends CommandGroup {
//THIS IS ARBITRARY DO NOT RUN
    public LLRight() {
        this.addSequential(new DriveForward(0.5, 18.0));
    }

}