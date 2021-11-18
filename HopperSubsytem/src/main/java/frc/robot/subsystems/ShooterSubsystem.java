// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private CANSparkMax m_flywheelController;
  private DoubleSolenoid m_solenoidController;
  public ShooterSubsystem() {
    m_flywheelController = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_solenoidController = new DoubleSolenoid(0, 1);
    m_flywheelController.restoreFactoryDefaults();
    m_flywheelController.setOpenLoopRampRate(Constants.kRampRate);
    m_flywheelController.setSmartCurrentLimit(Constants.kCurrentLimit);
  }

  public void teleopShooterPeriodic(boolean on) {
    if (on == true) {
      m_flywheelController.set(Constants.kFlywheelSpeed);
      
      
    } else {
      m_flywheelController.set(0);
      
    }
    
  }
}
