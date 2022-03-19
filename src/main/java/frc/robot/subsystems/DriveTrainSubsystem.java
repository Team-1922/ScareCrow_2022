// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  private cantest frontLeft = new cantest(Constants.FrontLeft);
  private cantest frontRight = new cantest(Constants.FrontRight);
  private cantest backLeft = new cantest(Constants.BackLeft);
  private cantest backRight = new cantest(Constants.BackRight);
  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {
    backLeft.set(ControlMode.Follower, frontLeft.getDeviceID());
    backRight.set(ControlMode.Follower, frontRight.getDeviceID());
    frontRight.setInverted(TalonFXInvertType.CounterClockwise);
    backRight.setInverted(InvertType.FollowMaster);
    frontLeft.setInverted(TalonFXInvertType.Clockwise);
    backLeft.setInverted(InvertType.FollowMaster);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double left, double right){
    frontLeft.set(left);
    frontRight.set(right);

  }
}

