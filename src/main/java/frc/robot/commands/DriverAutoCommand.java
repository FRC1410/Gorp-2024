package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

import java.util.Optional;

public class DriverAutoCommand extends Command {
    private final Drivetrain drivetrain;
    private final double leftDrivetrainSpeed;
    private final double rightDrivetrainSpeed;

    public DriverAutoCommand(
            Drivetrain drivetrain,
            double leftDrivetrainSpeed,
            double rightDrivetrainSpeed
    ) {
        this.drivetrain = drivetrain;
        this.leftDrivetrainSpeed = leftDrivetrainSpeed;
        this.rightDrivetrainSpeed = rightDrivetrainSpeed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        drivetrain.tankDrive(leftDrivetrainSpeed, rightDrivetrainSpeed);
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
