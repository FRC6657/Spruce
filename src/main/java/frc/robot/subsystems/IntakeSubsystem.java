package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    
    private static TalonSRX mIntake = new TalonSRX(6);


    private void configureMotors() {
        mIntake.configFactoryDefault();
        mIntake.setInverted(true);

    }

    public IntakeSubsystem (){
        configureMotors();
    }

    public void forward() {
        mIntake.set(ControlMode.PercentOutput, Constants.Intake.kForward);
    }

    public void backward() {
        mIntake.set(ControlMode.PercentOutput, Constants.Intake.kBackward);

    }

    public void stop() {
        mIntake.set(ControlMode.PercentOutput, 0);

    }
}
