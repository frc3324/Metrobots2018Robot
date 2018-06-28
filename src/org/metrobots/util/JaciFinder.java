package org.metrobots.util;

import java.util.HashMap;

import org.metrobots.Constants;
import org.metrobots.Robot;

import jaci.pathfinder.Pathfinder;

import jaci.pathfinder.Trajectory;

import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
public class JaciFinder {
	public static Waypoint[] testPoints = new Waypoint[] {
			new Waypoint(0, 0, 0),
			new Waypoint(1, 1, 0)
	};
	public static Trajectory.Config testConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_LOW, 0.05, 4, 2, 15);
	public static Trajectory test = Pathfinder.generate(testPoints, testConfig);
	TankModifier modifier = new TankModifier(test);
	Trajectory left = modifier.getLeftTrajectory();
	Trajectory right = modifier.getRightTrajectory();
	
	EncoderFollower leftFollower = new EncoderFollower();
	EncoderFollower rightFollower = new EncoderFollower();
//	followerLeft.
}
