package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SelectCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.revShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

public class PreloadAuto extends ParallelRaceGroup {
    public PreloadAuto(Shooter shooter) {
        addCommands(
                new revShooter(shooter),

                new SequentialCommandGroup(
                    new WaitCommand(5),
                    new ShootCommand(shooter)
                )
        );
    }
}
