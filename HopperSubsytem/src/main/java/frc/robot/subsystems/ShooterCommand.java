// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterCommand extends CommandBase {
  private ShooterSubsystem m_shooterSubsystem;
  private boolean toggle = true;
  /** Creates a new CommandScheduler. */
  public ShooterCommand(ShooterSubsystem h) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(h);
    m_shooterSubsystem = h;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    if (toggle == true) {
      toggle = false;
    } else {
      toggle = true;
    }
    SmartDashboard.putBoolean("toggle", toggle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.teleopShooterPeriodic(toggle);
    m_shooterSubsystem.teleopHoodPeriodic(toggle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
