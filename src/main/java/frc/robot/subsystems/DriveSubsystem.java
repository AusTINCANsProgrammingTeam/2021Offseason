// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {
private CANSparkMax m_frontLDriveMotor;
private CANSparkMax m_frontRDriveMotor;
private CANSparkMax m_backLDriveMotor;
private CANSparkMax m_backRDriveMotor;
private CANEncoder m_frontLDriveEncoder;
private CANEncoder m_frontRDriveEncoder;
private CANEncoder m_backLDriveEncoder;
private CANEncoder m_backRDriveEncoder;
private DifferentialDrive m_diffDrive;
private Joystick m_Joystick;
  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    //Sets up Motors
    m_frontLDriveMotor = new CANSparkMax(Constants.kfrontLMotorID,MotorType.kBrushless);
    m_frontRDriveMotor = new CANSparkMax(Constants.kfrontRMotorID,MotorType.kBrushless);
    m_backLDriveMotor = new CANSparkMax(Constants.kbackLMotorID,MotorType.kBrushless);
    m_backRDriveMotor = new CANSparkMax(Constants.kbackRMotorID,MotorType.kBrushless);
    m_frontLDriveMotor.restoreFactoryDefaults();
    m_frontRDriveMotor.restoreFactoryDefaults();
    m_backLDriveMotor.restoreFactoryDefaults();
    m_backRDriveMotor.restoreFactoryDefaults();
    m_frontLDriveMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_frontRDriveMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_backLDriveMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_backRDriveMotor.setOpenLoopRampRate(Constants.kRampRate);
    m_backLDriveMotor.follow(m_frontLDriveMotor);
    m_backRDriveMotor.follow(m_frontRDriveMotor);
    m_frontLDriveMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    m_frontRDriveMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    m_backLDriveMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    m_backRDriveMotor.setSmartCurrentLimit(Constants.kSmartCurrentLimit);
    //Sets up Encoders
    m_frontLDriveEncoder = m_frontLDriveMotor.getEncoder();
    m_frontRDriveEncoder = m_frontRDriveMotor.getEncoder();
    m_backLDriveEncoder = m_backLDriveMotor.getEncoder();
    m_backRDriveEncoder = m_backRDriveMotor.getEncoder();
    //Sets up Joysticks
    m_Joystick = new Joystick(Constants.klJoystickID);
    //m_rJoystick = new Joystick(Constants.krJoystickID);
    //Sets up Differential Drive
    m_diffDrive = new DifferentialDrive(m_frontLDriveMotor, m_frontRDriveMotor);
  }

  public void drive(){
    m_diffDrive.tankDrive(m_Joystick.getRawAxis(Constants.klSpeedAxis),m_Joystick.getRawAxis(Constants.krSpeedAxis));
  }

  public void end(){
      m_diffDrive.tankDrive(0,0);
  }

  @Override
  public void periodic() {
    m_frontLDriveEncoder.getVelocity();
    m_frontRDriveEncoder.getVelocity();
    m_backLDriveEncoder.getVelocity();
    m_backRDriveEncoder.getVelocity();
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
