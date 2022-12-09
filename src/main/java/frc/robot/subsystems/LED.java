// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.RainbowAnimation;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class LED extends SubsystemBase {
  /** Creates a new LED. */
  public LED() {}
  private CANdle m_CANdle = new CANdle(0);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void lightAnimate( int R,int G, int B){
   
  RainbowAnimation rainbowAnimation = new RainbowAnimation(.5, .5, 100);
  m_CANdle.animate(rainbowAnimation); 
  
  }
  
  public void lightAnimate2( int R,int G, int B){
    
    RainbowAnimation rainbowAnimation2 = new RainbowAnimation(255, 1, 100);
    m_CANdle.animate(rainbowAnimation2); 
    }

  public void lightUp( int R,int G, int B){
    m_CANdle.setLEDs( R,G,B);
 
    
   // m_CANdle.setLEDOutput(R, CANdle.LEDChannel.LEDChannelB);
    //m_CANdle.setLEDOutput(B, CANdle.LEDChannel.LEDChannelC);
  } // Redo which colors correlate to which channels if we do a new canifier

}

