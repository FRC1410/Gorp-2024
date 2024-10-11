package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

import java.util.Optional;

public class TurnCommand extends Command {
    private final Drivetrain drivetrain;
    private final Optional<DriverStation.Alliance> allianceColor;
    private final double leftDrivetrainSpeed;
    private final double rightDrivetrainSpeed;

    public TurnCommand(
            Drivetrain drivetrain,
            Optional<DriverStation.Alliance> allianceColor,
            double leftDrivetrainSpeed,
            double rightDrivetrainSpeed
    ) {
        this.drivetrain = drivetrain;
        this.allianceColor = allianceColor;
        this.leftDrivetrainSpeed = leftDrivetrainSpeed;
        this.rightDrivetrainSpeed = rightDrivetrainSpeed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if(allianceColor.equals(DriverStation.Alliance.Blue)) {
            drivetrain.tankDrive(leftDrivetrainSpeed, -rightDrivetrainSpeed);
        } else if(allianceColor.equals(DriverStation.Alliance.Red)) {
            drivetrain.tankDrive(-leftDrivetrainSpeed, rightDrivetrainSpeed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

