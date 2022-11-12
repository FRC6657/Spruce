package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  
  private final TalonSRX mFrontRight = new TalonSRX(Constants.CAN.kFrontRight); 
  private final TalonSRX mFrontLeft = new TalonSRX(Constants.CAN.kFrontLeft); 
  private final TalonSRX mBackRight = new TalonSRX(Constants.CAN.kBackRight); 
  private final TalonSRX mBackLeft = new TalonSRX(Constants.CAN.kBackLeft); 

  private final Timer mTimer = new Timer();
  
  public Drivetrain() {

    mFrontRight.setNeutralMode(NeutralMode.Brake);
    mFrontLeft.setNeutralMode(NeutralMode.Brake);
    mBackRight.setNeutralMode(NeutralMode.Brake);
    mBackLeft.setNeutralMode(NeutralMode.Brake);

  }

  public void easyDrive(double speed, double turn) {

    double left = speed + turn;
    double right = speed - turn;

    mFrontRight.set(ControlMode.PercentOutput,-right);
    mFrontLeft.set(ControlMode.PercentOutput, left);
    mBackRight.set(ControlMode.PercentOutput, -right);
    mBackLeft.set(ControlMode.PercentOutput, left);

  }

  public void autoDrive() {
    double speed = 0.6;
    double turn = 0;
    double time = mTimer.get();
    
    while (time < 2) {
      easyDrive(speed, turn);
    }
  }
 
}
