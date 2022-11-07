// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriverControl;
import frc.robot.custom.CommandXboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


public class RobotContainer{
  
  private Drivetrain drivetrain = new Drivetrain();
  private LiftSubsystem lift = new LiftSubsystem();
  private IntakeSubsystem intake = new IntakeSubsystem();

  private final CommandXboxController driver = new CommandXboxController(0);
  private final CommandXboxController operator = new CommandXboxController(1);

  public RobotContainer() {

    configureButtonBindings();

  }

 
  private void configureButtonBindings() {

    CommandScheduler.getInstance().setDefaultCommand(drivetrain, 
      new DriverControl(drivetrain,
      () -> cubicDeadband(driver.getRawAxis(XboxController.Axis.kLeftY.value), 0, 0.1),
      () -> cubicDeadband(driver.getRawAxis(XboxController.Axis.kRightX.value), 0, 0.1)
      ));

    
    
      operator.x().whenHeld(
      new StartEndCommand(
      () -> lift.up(),
      lift::stop,
      lift
        )
      );

      driver.a().whenHeld(
        new StartEndCommand(
      () -> intake.forward(), 
      intake::stop, 
      intake)
      );
    
  
  
  }

  private double cubicDeadband(double pInput, double pWeight, double pDeadband){

    double output;

    if(Math.abs(pInput) > pDeadband){
      output = (((pWeight * (Math.pow(pInput, 3)) + 1*(1 - pWeight) * pInput) - (Math.abs(pInput)) / pInput * (pWeight * (Math.pow(pDeadband, 3)) + (1 - pWeight) * pDeadband)) / (1 - (pWeight * (Math.pow(pDeadband, 3)) + (1 - pWeight) * pDeadband)));
    }
    else{
      output = 0;
    }
    return output;
  }

}
