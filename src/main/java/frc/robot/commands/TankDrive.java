// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;



public class TankDrive extends CommandBase {
  DriveTrainSubsystem m_driveTrain;
  private Joystick m_joystickRight;
  private Joystick m_joystickLeft;

  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");

  /** Creates a new TankDrive. */
  public TankDrive(DriveTrainSubsystem driveTrain, Joystick joystickLeft, Joystick joystickRight){
    m_driveTrain = driveTrain;
    m_joystickLeft = joystickLeft;
    m_joystickRight = joystickRight;

    addRequirements(m_driveTrain);

  } 
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //(Math.pow(m_joystickLeft.getY(),3)*0.8+(m_joystickLeft.getY())*0.2)*1.00, (Math.pow(m_joystickRight.getY(),3)*0.8+(m_joystickRight.getY())*0.2)*1.00
    m_driveTrain.drive((m_joystickLeft.getY()*0.6-m_joystickRight.getX()*0.5*(1-Math.abs(m_joystickLeft.getY()/3))*0.5),(m_joystickLeft.getY()*0.6+m_joystickRight.getX()*0.5*(1-Math.abs(m_joystickLeft.getY()/3))*0.5));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
