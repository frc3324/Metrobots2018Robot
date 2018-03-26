package org.metrobots.util;

import edu.wpi.first.wpilibj.Solenoid;

public class StatusLED {

	// Chasing LED strip lights?!! Maybe?!!
	 Solenoid redLights = new Solenoid(2);
	Solenoid greenLights = new Solenoid(3);
	Solenoid blueLights = new Solenoid(4);
	
	public StatusLED() {
		redLights.setPulseDuration(100);
		greenLights.setPulseDuration(100);
		blueLights.setPulseDuration(100);
	}
	
	public void setStateHigh() {
		greenLights.set(true);
	}
	
	/**
	 * Set state to show cube is not in the intake.
	 */
	public void setStateLow() {
		redLights.set(true);
	}
	
	/**
	 * Alternatively turn on and off the lights of the robot.
	 */
	public void setPartyMode() {
		redLights.startPulse();
		greenLights.startPulse();
		blueLights.startPulse();
	}
	
	/**
	 * Stop pulsing of the lights.
	 * @param lightType
	 */
	public void stopPulse(Solenoid lightType) {
		lightType.set(false);
	}
	
	/**
	 * Set state of robot to brownout.
	 */
	public void setStateBrownout() {
		redLights.setPulseDuration(10);
		redLights.startPulse();
	}
	
}
