// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HopperSubsystem extends SubsystemBase {
private CANSparkMax m_hopperLMotor;
private CANSparkMax m_hopperRMotor;
private CANSparkMax m_hopperYMotor;
private CANEncoder m_hopperLEncoder;
private CANEncoder m_hopperREncoder;
private CANEncoder m_hopperYEncoder;
  /** Creates a new ExampleSubsystem. */
  public HopperSubsystem() {
    //Sets up Motors
    m_hopperLMotor = new CANSparkMax(Constants.khopperLMotorID,MotorType.kBrushless);
    m_hopperRMotor = new CANSparkMax(Constants.khopperRMotorID,MotorType.kBrushless);
    m_hopperYMotor = new CANSparkMax(Constants.khopperYMotorID,MotorType.kBrushless);

    m_hopperLMotor.restoreFactoryDefaults();
    m_hopperRMotor.restoreFactoryDefaults();
    m_hopperYMotor.restoreFactoryDefaults();

    m_hopperLMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_hopperRMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_hopperYMotor.setOpenLoopRampRate(Constants.kRampRate);

    m_hopperRMotor.follow(m_hopperLMotor);

    m_hopperLMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    m_hopperRMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    m_hopperYMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    //Sets up Encoders
    m_hopperLEncoder = m_hopperLMotor.getEncoder();
    m_hopperREncoder = m_hopperRMotor.getEncoder();
    m_hopperYEncoder = m_hopperYMotor.getEncoder();
  }

public void spinFront(double speed){
      m_hopperLMotor.set(speed);
  }
public void spinUp(double speed){
    m_hopperLMotor.set(speed);
    }

  @Override
  public void periodic() {
    m_hopperLEncoder.getVelocity();
    m_hopperREncoder.getVelocity();
    m_hopperYEncoder.getVelocity();
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}