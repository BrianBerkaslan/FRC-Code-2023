// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.PneumaticsCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PneumaticSub;//McT added
//McT note - I usually import import frc.robot.subsystems.*; and frc.robot.commands.* so I don't have to add each one manually.

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 
  // DriveTrain Declare
  private final DriveTrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForardTimed;
  
  //McT added
  private final PneumaticSub pneumaticSub = new PneumaticSub();
  //end McT added - you need to import your subsystems.

  public static XboxController driverJoystick;

/** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driveTrain = new DriveTrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);

    driveForardTimed = new DriveForwardTimed(driveTrain);
    driveForardTimed.addRequirements(driveTrain);

    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK_PORT);
    

    // Configure the button bindings
    configureButtonBindings();
    //McT edited
    JoystickButton DriverAButton = new JoystickButton(driverJoystick, Constants.XBOX_A_BUTTON);
//    JoystickButton DriverBButton = new JoystickButton(driverJoystick, Constants.XBOX_B_BUTTON);
    //We only need one button - each time we press it the solenoid will switch direction.
    //end McT edited.
    //McT added
    DriverAButton.whenPressed(new PneumaticsCommand(pneumaticSub));
    //Note - whenPressed, whenReleased, whileHeld allow you to schedule different commands based on what you want.
    //Since we are simply changing the solenoid direction whenPressed is the best option.
    //If you wanted to run an intake motor whild you held a button down then whileHeld would be the best option.
    //end McT added
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForardTimed;
  }
}
