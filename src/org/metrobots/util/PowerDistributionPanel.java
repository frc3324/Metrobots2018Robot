package org.metrobots.util;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PowerDistributionPanel extends Subsystem {

    PowerDistributionPanel pdp = new PowerDistributionPanel();

	public double getCurrent(int pdpPort) {
		SmartDashboard.putNumber("Current of PDP port: ", pdpPort);
    	return pdp.getCurrent(pdpPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

