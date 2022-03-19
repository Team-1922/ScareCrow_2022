// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;



public class cantest extends WPI_TalonFX {
  /** Creates a new cantest. */
  
  protected double m_lastSet= Double.NaN;
  protected TalonFXControlMode m_lastControlMode = null;
  
  
  public cantest(int deviceid) {
    // Use addRequirements() here to declare subsystem dependencies.
 super (deviceid);

  }
 @Override public void set(TalonFXControlMode mode, double value  )
 {
   if(value !=m_lastSet || mode !=m_lastControlMode) 
   {
     m_lastSet= value;
     m_lastControlMode = mode;
     super.set(mode, value);
   }
  
  }

}

