// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Drivebase Constants
    public static final int kfrontLMotorID = 4;
    public static final int kfrontRMotorID = 11;
    public static final int kbackLMotorID = 3;
    public static final int kbackRMotorID = 1;
    public static final int klSpeedAxis = 1;
    public static final int krSpeedAxis = 3;
    public static final int klJoystickID = 0;
    public static final int krJoystickID = 2;
    //Hopper Constants
    public static final int khopperLMotorID = 11;
    public static final int khopperRMotorID = 4;
    public static final int khopperYMotorID = 9;
    public static final int khopperInID = 1;
    public static final int khopperOutID = 2;
    public static final int khopperUpID = 3;
    public static final int khopperDownID = 4;
    public static final double khopperSpeed = 0.5;
    //Universal Constants
    public static final int kSmartCurrentLimit = 40;
    public static final double kRampRate = 0.2;
}
