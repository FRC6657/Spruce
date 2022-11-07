package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
    
    private static TalonSRX mLeft = new TalonSRX(Constants.Lift.kLeft);
    private static TalonSRX mRight = new TalonSRX(Constants.Lift.kRight);
    
    
    private void configureMotors() {
        
        mLeft.configFactoryDefault(); //Set default to prevent floating configurations
        mLeft.setInverted(true); //Invert so + is up and - is down
        mLeft.setNeutralMode(NeutralMode.Brake); //Brake as to hold on bar
        mLeft.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 80, 1)); //Configure current limit

        mRight.configFactoryDefault(); //Set default to prevent floating configurations
        mRight.setInverted(mLeft.getInverted()); //Invert so + is up and - is down
        mRight.setNeutralMode(NeutralMode.Brake); //Brake as to hold on bar
        mRight.configSupplyCurrentLimit(new SupplyCurrentLimitConfiguration(true, 40, 80, 1)); //Configure current limit
        
        mRight.follow(mLeft);
    }

    public LiftSubsystem() {
        configureMotors();
    }

    public void set (double percent) {
       mLeft.set(ControlMode.PercentOutput, percent);

    }

    public void stop() {
        mLeft.set(ControlMode.PercentOutput, 0); 

    }

    public void up () {
        mLeft.set(ControlMode.PercentOutput, Constants.Lift.kUp);

    }

    public void down () {
        mLeft.set(ControlMode.PercentOutput, Constants.Lift.kDown);

    }
}   

