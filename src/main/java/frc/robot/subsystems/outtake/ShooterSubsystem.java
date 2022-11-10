package frc.robot.subsystems.outtake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase{
   
    private static VictorSPX mShooter = new VictorSPX(Constants.Shooter.kShooter);
    
    
    private void configureMotors() {
        
        mShooter.configFactoryDefault(); //Set default to prevent floating configurations
        mShooter.setInverted(false); //Invert so + is up and - is down
        mShooter.setNeutralMode(NeutralMode.Coast); //Brake as to hold on bar
       
    }

    public ShooterSubsystem() {
        configureMotors();
    }

    public void set (double percent) {
       mShooter.set(ControlMode.PercentOutput, percent);

    }

    public void stop() {
        mShooter.set(ControlMode.PercentOutput, 0); 

    }

    public void shoot() {
        mShooter.set(ControlMode.PercentOutput, Constants.Shooter.kShootSpeed);

    }
}   

