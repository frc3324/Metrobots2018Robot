package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeController extends Subsystem {

	WPI_VictorSPX leftIntakeMotor = new WPI_VictorSPX(Constants.leftIntakeMotorPort);
	WPI_VictorSPX rightIntakeMotor = new WPI_VictorSPX(Constants.rightIntakeMotorPort);
	SpeedControllerGroup intakeMotors = new SpeedControllerGroup(leftIntakeMotor, rightIntakeMotor);
	
	public CubeController() {
		
	}
	
	public void intake(double speed) {
		intakeMotors.set(speed);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

