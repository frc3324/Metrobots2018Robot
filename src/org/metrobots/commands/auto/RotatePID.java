package org.metrobots.commands.auto;

import org.metrobots.Constants;
import org.metrobots.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotatePID extends Command {
	private AHRS navx;
	
	private PIDController turnController;
	
	double rotateAngle;
	private PIDOutput mPIDOutput;
	private double rotateValue;
	private static final double kP = 1.0;
	private static final double kI = 0.0;
	private static final double kD = 0.0;


	
	
	
	
    public RotatePID(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.mDriveTrain);
    	rotateAngle = angle;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
			navx = new AHRS(SPI.Port.kMXP);
			DriverStation.reportError("Instantiated! ", true);
//			isInitialized = false;
//			SmartDashboard.putBoolean("Initialized?", isInitialized);
		} catch (RuntimeException ex) {
//			DriverStation.reportError("Error instantiating navc: ", true);
		}
    	turnController = new PIDController(kP, kI, kD, navx, mPIDOutput );
    	turnController.setInputRange(-180.0, 180.0);
    	turnController.setOutputRange(-1.0, 1.0);
    	turnController.setAbsoluteTolerance(Constants.AUTO_ROTATE_ANGLE_THRESHOLD);
    	turnController.setContinuous(true);
	}
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turnController.enable();
    	mPIDOutput.pidWrite(rotateValue);
    	Robot.mDriveTrain.arcadeDrive(0.0, rotateValue, true);
        SmartDashboard.putNumber("Gyro", navx.pidGet());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
