package org.metrobots.util;

import edu.wpi.first.wpilibj.Solenoid;

public class StatusLED {

	Solenoid redLights = new Solenoid(2);
	Solenoid greenLights = new Solenoid(3);
	Solenoid blueLights = new Solenoid(4);
	
	public StatusLED() {
		redLights.setPulseDuration(100);
		greenLights.setPulseDuration(100);
		blueLights.setPulseDuration(100);
	}
	
	/**
	 * Set state to show cube is in the intake (green).
	 */
	public void setStateHigh() {
		greenLights.set(true);
	}
	
	/**
	 * Set state to show cube is not in the intake (red).
	 */
	public void setStateLow() {
		redLights.set(true);
	}
	
	/**
	 * Alternatively turn on and off the lights of the robot (red, green, blue).
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
	 * Set state of robot to brownout (rapid blinking red).
	 */
	public void setStateBrownout() {
		redLights.setPulseDuration(10);
		redLights.startPulse();
	}
	
}
