package org.metrobots.subsystems;

import org.metrobots.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CubeController extends Subsystem {

	WPI_TalonSRX leftIntakeMotor = new WPI_TalonSRX(Constants.leftIntakeMotorPort);
	WPI_TalonSRX rightIntakeMotor = new WPI_TalonSRX(Constants.rightIntakeMotorPort);
//	SpeedControllerGroup intakeMotors = new SpeedControllerGroup(leftIntakeMotor, rightIntakeMotor);
//	
	public CubeController() {
//		leftIntakeMotor.setInverted(true);
	}
	
	public void intake(double speed) {
		leftIntakeMotor.set(-speed);
		rightIntakeMotor.set(speed);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

