// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.DriverControl;
import frc.robot.custom.CommandXboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.outtake.KickerSubsystem;
import frc.robot.subsystems.outtake.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


public class RobotContainer{
  
  private Drivetrain drivetrain = new Drivetrain();
  private LiftSubsystem lift = new LiftSubsystem();
  private IntakeSubsystem intake = new IntakeSubsystem();
  private KickerSubsystem kicker = new KickerSubsystem();
  private ShooterSubsystem shooter = new ShooterSubsystem();

  private final CommandXboxController driver = new CommandXboxController(0);
  private final CommandXboxController operator = new CommandXboxController(1);


  //Current drive set up: 2 Xbox

  public RobotContainer() {

    configureButtonBindings();

  }
 
  private void configureButtonBindings() {

    CommandScheduler.getInstance().setDefaultCommand(drivetrain, 
      new DriverControl(drivetrain,
      () -> cubicDeadband(-driver.getRawAxis(XboxController.Axis.kLeftY.value), 0.4, 0.1),
      () -> cubicDeadband(driver.getRawAxis(XboxController.Axis.kLeftX.value), 0.4, 0.1)
      ));
    
      operator.pov.up().whenHeld(
        new StartEndCommand(
        () -> lift.up(),
        lift::stop,
        lift
          )
      );

      operator.pov.down().whenHeld(
        new StartEndCommand(
        () -> lift.down(),
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

      driver.x().whenHeld(
        new StartEndCommand(
        () -> kicker.run(),
        kicker::stop, kicker)
        );

      driver.y().whenHeld(
        new ParallelCommandGroup(
          new StartEndCommand(
            shooter::shoot,
            shooter::stop,
            shooter
          ),
          new StartEndCommand(
            kicker::run,
            kicker::stop,
            kicker
          )
        ) 
      );
  

      driver.b().whenHeld(
        new StartEndCommand(
        () -> intake.backward(), 
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


  public SequentialCommandGroup getAutonomousCommand(){

    return new SequentialCommandGroup(
      new ParallelCommandGroup(
        new StartEndCommand(
          shooter::shoot,
          shooter::stop,
          shooter
        ),
        new StartEndCommand(
          kicker::run,
          kicker::stop,
          kicker
        )
      ).withTimeout(5),
      new DriverControl(drivetrain,() -> -0.7, () -> 0d).withTimeout(3)
    );

  }

  public void configureAutoChooser() {

    
  }
}


