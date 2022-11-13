package frc.robot.subsystems.outtake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class KickerSubsystem extends SubsystemBase {
     
    private static WPI_TalonSRX mKicker = new WPI_TalonSRX(Constants.Kicker.kKicker);
   

    private void configureMotors() {
        mKicker.configFactoryDefault();
        mKicker.setInverted(true);
        mKicker.setNeutralMode(NeutralMode.Coast);
    }

    public KickerSubsystem() {
        configureMotors();
    }

    public void set(double percent) {
        mKicker.set(ControlMode.PercentOutput, percent);

    }

    public void stop() {
        mKicker.set(ControlMode.PercentOutput, 0);
        
    }

    public void run() {
        mKicker.set(ControlMode.PercentOutput, Constants.Kicker.kKickSpeed);
    }
}
