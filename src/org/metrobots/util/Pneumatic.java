package org.metrobots.util;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.metrobots.util.MetroController;

public class Pneumatic {
	private MetroController gamepad; // Setup the controller
	private Solenoid GearShifter = new Solenoid(1); //Make GearShifter a Solenoid

	public Pneumatic(MetroController gp) { // Setup constructor 
		gamepad = gp; 
	}
		
	public void startSolenoid() { //Make method to startSolenoid
		try {
			if (gamepad.getAPressed()) { // (Line 18-20) If A is pressed, (change gear (to whatever it's not right now))
			boolean currentShifterStatus = GearShifter.get(); // get current gear/solenoid status
				GearShifter.set(!currentShifterStatus); // Change gear to whatever it's not right now 
			}
		} catch (Exception e) {
		}
	
	}

}