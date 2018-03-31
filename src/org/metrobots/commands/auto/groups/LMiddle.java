package org.metrobots.commands.auto.groups;

import org.metrobots.commands.auto.DriveForward;
import org.metrobots.commands.auto.GyroReset;
import org.metrobots.commands.auto.MoveArm;
import org.metrobots.commands.auto.Pause;
import org.metrobots.commands.auto.CubeControl;
import org.metrobots.commands.auto.Rotate;
import org.metrobots.commands.auto.RotatePID;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Set robot in middle position closest to the middle of the field. <p>
 * Position of robot = middle <p>
 * First letter from FMS = L 
 */
public class LMiddle extends CommandGroup {
	
    public LMiddle() {
    	
    	/*************FANCYTURN**************/
//    	this.addSequential(new Pause(0.1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new GyroReset());
////    	this.addSequential(new DriveForward(5));
//    	this.addSequential(new Rotate(-45, 0.45));
////    	this.addSequential(new MoveArm(11.75));
////    	this.addParallel(new MoveArm(0));
//    	this.addSequential(new Pause(0.1));
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new GyroReset());
//    	this.addSequential(new Rotate(30, 0));
//    	this.addSequential(new DriveForward(5));
////    	this.addSequential(new GyroReset());
////    	this.addSequential(new Rotate(-30, 0));
////    	this.addSequential(new DriveForward(50));
//    	this.addSequential(new CubeControl(-0.5, 2));
    	/*************FANCYTURN**************/
    	
    	this.addSequential(new Pause(0.1));
    	this.addSequential(new DriveForward(25));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(-90, 0));
//    	this.addSequential(new MoveArm(11.75));
//    	this.addParallel(new MoveArm(0));
    	this.addSequential(new Pause(0.5));
    	this.addSequential(new GyroReset());
    	this.addSequential(new DriveForward(36));
    	this.addSequential(new GyroReset());
    	this.addSequential(new Rotate(90,0));
    	this.addSequential(new DriveForward(44));
    	this.addSequential(new Pause(0.01));
    	this.addSequential(new CubeControl(-0.4, 2));
    }
    	
    }
