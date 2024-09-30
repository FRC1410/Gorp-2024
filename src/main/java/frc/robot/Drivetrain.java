package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {

    private final WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(LEFT_FRONT_ID);
    private final WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(LEFT_BACK_ID);
    private final WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(RIGHT_BACK_ID);
    private final WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RIGHT_FRONT_ID);

    public DifferentialDrive differentialDrive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
    public DifferentialDrive getDifferentialDrive() {return differentialDrive;}


    public Drivetrain(){
        leftBackMotor.follow(leftFrontMotor);
        rightBackMotor.follow(rightBackMotor);
    }

    public void tankDrive(double leftStickY, double rightStickX, double leftTrigger, double rightTrigger) {
            getDifferentialDrive().tankDrive(leftStickY, 0.0 - rightStickX);


    }
}
