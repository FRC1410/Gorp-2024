package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

import static frc.robot.Constants.BOTTOM_SHOOTER_ID;
import static frc.robot.Constants.TOP_SHOOTER_ID;

public class Shooter {

    private final WPI_TalonSRX topShooter = new WPI_TalonSRX(TOP_SHOOTER_ID);
    private final WPI_TalonSRX bottomShooter = new WPI_TalonSRX(BOTTOM_SHOOTER_ID);

    public Shooter(){
        bottomShooter.follow(topShooter);
    }

    public void runShooter(double topShooterSpeed){
        topShooter.set(topShooterSpeed);

    }

}
