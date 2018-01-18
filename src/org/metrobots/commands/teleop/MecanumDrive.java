package org.metrobots.commands.teleop;

import org.metrobots.Robot;
import org.metrobots.subsystems.OldDriveTrain;
import org.metrobots.util.MetroController;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Teleop control of drive train<br>
 * <br>
 * 
 * 
 * Feb 5: Refactored. Also, added Javadocs - Cameron
 * 
 */
public class MecanumDrive extends Command {

	public OldDriveTrain driveTrain;
	private MetroController gamepad;

	/**
	 * Get the objects necessary to operate the drive train
	 * 
	 * @param dt
	 *            drive train object
	 * @param gp
	 *            handheld controller for operating shooter
	 */
	public MecanumDrive(OldDriveTrain dt, MetroController gp) {
		driveTrain = dt;
		gamepad = gp;
	}

	/**
	 * Initialize stuff for driving the robot
	 */
	public void initialize() {
		driveTrain.mecanumDrive(0.0, 0.0, 0.0);
	}

	/**
	 * Function constantly run during teleop. Controls:<br>
	 * <b>Left X Axis:</b> left/right motion<br>
	 * <b>Left Y Axis:</b> forward/backward motion<br>
	 * <b>Right X Axis:</b> turning motion<br>
	 * <b>B</b>: Enable field orientation<br>
	 * <b>A</b>: Disable field orientation<br>
	 * <b>START</b>: Reset gyro
	 */
	public void execute() {
		double driverLX = gamepad.getAxis(MetroController.LEFT_X);
		double driverLY = gamepad.getAxis(MetroController.LEFT_Y);
		double driverRX = gamepad.getAxis(MetroController.RIGHT_X);
		//double driverRY = gamepad.getAxis(MetroGamepad.RIGHT_Y);

		if (gamepad.getButton(MetroController.BUTTON_B)) {
			driveTrain.setFieldOriented(true);
		} else if (gamepad.getButton(MetroController.BUTTON_A)) {
			driveTrain.setFieldOriented(false);
		}

		if (gamepad.getButton(MetroController.BUTTON_START)) {
			driveTrain.resetGyro();
		}
		
		if (gamepad.getButton(MetroController.RB)) {
			driveTrain.holdThisAngle();
		} else {
			driveTrain.setIsHoldingAngle(false);
		}
		
		//Vision Integration Code
		/*if (gamepad.getButton(MetroGamepad.LT)) {
			driveTrain.visionGear();
		}*/
		
		/*if (gamepad.getDPadAngle() != -1) {
			driveTrain.setIsHoldingAngle(true);
			driveTrain.setTargetAngle(-(gamepad.getDPadAngle()-90));
		}*/
		
		/*if (gamepad.getButton(MetroGamepad.RB)) {
			double tempX = driverRX;
			if (driverRX == 0) tempX = 0.0000001;
			double angle = Math.toDegrees(Math.atan(driverRY / tempX));
			if (tempX < 0) {
				angle = 180 + angle;
			}
			if (tempX > 0 && driverRY < 0) {
				angle = 360 + angle;
			}
			//double angle = Math.toDegrees(Math.atan(tempX / tempY));
			driveTrain.setTargetAngle(-angle);
			if (driverRX != 0.0 || driverRY != 0.0) {
				driveTrain.setIsHoldingAngle(true);
			}
		}*/
		
		/*if (!gamepad.getButton(MetroGamepad.RB) && driverRX != 0.0 && driverRY != 0.0) {
			driveTrain.setIsHoldingAngle(false);
		}*/
		
		/**
		 * These are added to make the robot more controllable
		 */
		driverLX = driverLX * driverLX * driverLX * 0.5; //was 0.3
		driverLY = driverLY * driverLY * driverLY * 0.5;
		driverRX = driverRX * driverRX * driverRX * 0.5;
		if (gamepad.getButton(MetroController.LB)) {
			driverLX *= 0.3; //was 0.5
			driverLY *= 0.3; //was 0.5
			driverRX *= 0.3; //was 0.5
			Robot.driveTrain.fl.enableBrakeMode(true);
			Robot.driveTrain.bl.enableBrakeMode(true);
			Robot.driveTrain.fr.enableBrakeMode(true);
			Robot.driveTrain.br.enableBrakeMode(true);
		} else {
			Robot.driveTrain.fl.enableBrakeMode(false);
			Robot.driveTrain.bl.enableBrakeMode(false);
			Robot.driveTrain.fr.enableBrakeMode(false);
			Robot.driveTrain.br.enableBrakeMode(false);
		}
		/*if (gamepad.getButton(MetroGamepad.LT)) {
			driveTrain.visionGear();
		} else {
			driveTrain.mecanumDrive(driverLX, driverLY, driverRX);
		}*/
		driveTrain.mecanumDrive(driverLX, driverLY, driverRX);
	}

	/*
	 * Necessary function that returns false.
	 */
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}