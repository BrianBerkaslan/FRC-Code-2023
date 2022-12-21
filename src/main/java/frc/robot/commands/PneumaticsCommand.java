// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PneumaticSub;

public class PneumaticsCommand extends CommandBase {

  private final PneumaticSub pneumaticsub;
  private boolean isDone = false;

  /** Creates a new PneumaticsCommand. */
  public PneumaticsCommand(PneumaticSub pt) {
    // Use addRequirements() here to declare subsystem dependencies.
    pneumaticsub = pt;
    addRequirements(pneumaticsub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //McT added
    //running the pneumatics solenoid
    this.pneumaticsub.setSolenoid();
    this.isDone = true;
    //end McT added
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Mct - don't need this.  I put it in initialize
    /*
    if ( DRIVER PRESSES THE A BUTTON) {
      pneumaticsub.SetSolForward();
    }
    if ( DRIVER PRESSES THE B BUTTON) {
      pneumaticsub.SetSolReverse();
    }
    */
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //McT added
    return this.isDone;
    //end McT added
  }
}
