// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.commands.AvoidWall;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Lights;
import frc.robot.commands.Lights2;
//import frc.robot.commands.TOFDistance;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TankDriveXbox;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LED;
//import frc.robot.subsystems.TOF;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrainSubsystem m_driveTrain = new DriveTrainSubsystem();
//  private final TOF m_TOF = new TOF();

  private final Joystick m_joystickLeft = new Joystick(0);
  private final Joystick m_joystickRight = new Joystick(1);
  private final LED m_LED = new LED();
  private final XboxController m_XBoxController = new XboxController(2);



  //Commands ---- Go Here ------ Please ------ Thank you
private final Lights m_lights = new Lights(m_LED);
private final Lights2 m_lights2 = new Lights2(m_LED);
private final TankDrive m_tankDrive = new TankDrive(m_driveTrain, m_joystickLeft, m_joystickRight);
private final TankDriveXbox m_tankDriveXbox = new TankDriveXbox(m_driveTrain, m_XBoxController);
//private final TOFDistance m_TOFDistance = new TOFDistance(m_TOF);
//private final AvoidWall m_avoidWall = new AvoidWall(m_driveTrain, m_TOF);




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveTrain.setDefaultCommand(m_tankDriveXbox);
    //m_TOF.setDefaultCommand(m_TOFDistance);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

 //   new JoystickButton(m_XBoxController, 1) //A
   //       .whenPressed(m_avoidWall);
 
      new JoystickButton(m_XBoxController, 1)
            .whenPressed(m_lights);
          
      new JoystickButton(m_XBoxController, 2)
        .whenPressed(m_lights2);

           
  }


  /*
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
