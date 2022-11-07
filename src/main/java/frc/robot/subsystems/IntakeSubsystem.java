package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    
    private static WPI_VictorSPX mIntake = new WPI_VictorSPX(Constants.Intake.kIntake);


    private void configureMotors() {
        mIntake.configFactoryDefault();
        mIntake.setInverted(true);
        mIntake.stopMotor();

    }

    public IntakeSubsystem (){
        configureMotors();
    }

    public void forward() {
        mIntake.set(Constants.Intake.kForward);

    }

    public void backward() {
        mIntake.set(Constants.Intake.kBackward);

    }

    public void stop() {
        mIntake.stopMotor();

    }
}
