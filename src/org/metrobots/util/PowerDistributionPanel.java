package org.metrobots.util;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PowerDistributionPanel extends Subsystem {

    PowerDistributionPanel pdp = new PowerDistributionPanel();
    

    /**
     * Get current from the PDP channel. Print out result to SmartDashboard.
     * @param pdpPort
     * 	Motor controller connection to PDP, listed on physical PDP.
     * @return
     */
	public double getCurrent(int pdpChannel) {
		SmartDashboard.putNumber("Current of PDP port: ", pdpChannel);
    	return pdp.getCurrent(pdpChannel);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

