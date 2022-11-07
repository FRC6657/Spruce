// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.Lift;
import frc.robot.commands.DriverControl;
import frc.robot.custom.CommandXboxController;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


public class RobotContainer {
  
  private final Drivetrain drivetrain = new Drivetrain();
  private final Lift lift = new Lift();
  private final CommandXboxController driver = new CommandXboxController(0); // to do make custom xbox

  public RobotContainer() {

    configureButtonBindings();

  }

 
  private void configureButtonBindings() {

    CommandScheduler.getInstance().setDefaultCommand(drivetrain, 
      new DriverControl(drivetrain,
      () -> cubicDeadband(driver.getRawAxis(XboxController.Axis.kLeftY.value), 0, 0.1),
      () -> cubicDeadband(driver.getRawAxis(XboxController.Axis.kRightX.value), 0, 0.1)
      ));
    
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
