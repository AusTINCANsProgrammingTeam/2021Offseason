// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.HopperInCommand;
import frc.robot.commands.HopperOutCommand;
import frc.robot.commands.HopperUpCommand;
import frc.robot.commands.HopperDownCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.HopperSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final HopperSubsystem m_hopperSubsystem = new HopperSubsystem();
  private final HopperInCommand m_hopperInCommand = new HopperInCommand(m_hopperSubsystem);
  private final HopperOutCommand m_hopperOutCommand = new HopperOutCommand(m_hopperSubsystem);
  private final HopperUpCommand m_hopperUpCommand = new HopperUpCommand(m_hopperSubsystem);
  private final HopperDownCommand m_hopperDownCommand = new HopperDownCommand(m_hopperSubsystem);
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getHopperInCommand(){
    return m_hopperInCommand;
  }
  public Command getHopperOutCommand(){
    return m_hopperOutCommand;
  }
  public Command getHopperUpCommand(){
    return m_hopperUpCommand;
  }
  public Command getHopperDownCommand(){
    return m_hopperDownCommand;
  }
  public Command getTeleopCommand(){
    return m_driveCommand;
  }
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
