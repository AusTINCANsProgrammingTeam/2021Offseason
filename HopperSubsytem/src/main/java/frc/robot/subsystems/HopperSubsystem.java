// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;



public class HopperSubsystem extends SubsystemBase {
  /** Creates a new HopperSubsystem. */
  private CANSparkMax m_motorController1;
  private CANSparkMax m_motorController2;
  private CANSparkMax m_motorController3;

  public HopperSubsystem() {
    m_motorController1 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController2 = new CANSparkMax(11, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController3 = new CANSparkMax(9, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController1.restoreFactoryDefaults();
    m_motorController1.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController1.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController2.restoreFactoryDefaults();
    m_motorController2.setInverted(true);
    m_motorController2.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController2.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController3.restoreFactoryDefaults();
    m_motorController3.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController3.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController3.setInverted(true);
  }

  
  /** public void init() {
    m_motorController1 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController2 = new CANSparkMax(11, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController3 = new CANSparkMax(9, CANSparkMaxLowLevel.MotorType.kBrushless);
    m_motorController1.restoreFactoryDefaults();
    m_motorController1.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController1.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController2.restoreFactoryDefaults();
    m_motorController2.setInverted(true);
    m_motorController2.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController2.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController3.restoreFactoryDefaults();
    m_motorController3.setOpenLoopRampRate(Constants.kRampRate);
    m_motorController3.setSmartCurrentLimit(Constants.kCurrentLimit);
    m_motorController3.setInverted(true);
  } */
  
  public void teleopIntakePeriodic(boolean on) {
    if (on == true) {
      m_motorController1.set(Constants.kInputMotorOneSpeed);
      m_motorController2.set(Constants.kInputMotorTwoSpeed);
      m_motorController3.set(Constants.kInputMotorThreeSpeed);
    } else {
      m_motorController1.set(0);
      m_motorController2.set(0);
      m_motorController3.set(0);
    }
    
  }
}
  