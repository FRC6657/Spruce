package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  private Timer mTimer;
  private RobotContainer m_robotContainer;
  private Drivetrain drivetrain = new Drivetrain();
  
  @Override
  public void robotInit() {
   
    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic(){

  }

  @Override
  public void teleopInit() {
  
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    
    CommandScheduler.getInstance().cancelAll();

  }
  
  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
