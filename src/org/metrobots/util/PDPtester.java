package org.metrobots.util;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private PowerDistributionPanel pdp;
	
	public void robotInit() {
		pdp = new PowerDistributionPanel();
	}

	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
	}

	public void teleopPeriodic() {

		for(int i = 0; i < /* however many things to test */; i++)
		{
			SmartDashboard.putNumber("Channel " + i + " Current", pdp.getCurrent(i));
		}
		
		SmartDashboard.putNumber("Total Current", pdp.getTotalCurrent());
		SmartDashboard.putNumber("Total Power", pdp.getTotalPower());
	}

	public void testPeriodic() {
	}
	
}