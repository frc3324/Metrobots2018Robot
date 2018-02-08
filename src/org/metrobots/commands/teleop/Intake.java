//package org.metrobots.commands.teleop;
//
//import org.metrobots.subsystems.CubeController;
//
//import edu.wpi.first.wpilibj.AnalogTrigger;
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class Intake extends Command {
//
//	CubeController mCubeController = new CubeController();
//	AnalogTrigger limitSwitch = new AnalogTrigger(0);
//	
//	/**
//	 * Spin wheels inward. <p>
//	 */
//    public Intake() {
//    	requires(mCubeController);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	if (limitSwitch.getTriggerState() == true) {
//    		mCubeController.intake(0.2);
//    	}
//    	
//    	mCubeController.intake(1.0);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
