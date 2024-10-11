package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

import java.util.Optional;

public class AmpSideAuto extends SequentialCommandGroup {
    public AmpSideAuto(
            Drivetrain drivetrain,
            Shooter shooter,
            Optional<DriverStation.Alliance> allianceColor
    ) {
        addCommands(
            new ParallelRaceGroup(
                    new revShooter(shooter),

                    new SequentialCommandGroup(
                            new WaitCommand(5),
                            new ParallelRaceGroup(
                                    new WaitCommand(1.5),
                                    new ShootCommand(shooter)
                            )
                    )
            ),
            new SequentialCommandGroup(
                new ParallelRaceGroup(
                        new WaitCommand(2),
                        new DriverAutoCommand(drivetrain, 1,1)
                )
            ),
            new SequentialCommandGroup(
                   new ParallelRaceGroup(
                           new DriverAutoCommand(drivetrain, 1,1),
                           new WaitCommand(1.5)
                   ),
                   new ParallelRaceGroup(
                           new TurnCommand(drivetrain, allianceColor, 1, 1),
                           new WaitCommand(0.5)
                   ),
                   new ParallelRaceGroup(
                           new DriverAutoCommand(drivetrain, 0.5, 0.5),
                           new  WaitCommand(1)
                   )
                )
        );
    }

}