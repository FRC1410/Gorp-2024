// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriverLooped;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import static frc.robot.Constants.*;



public class RobotContainer {
    private final XboxController driverController = new XboxController(DRIVER_CONTROLLER);

    private final Drivetrain drivetrain = new Drivetrain();
    private final Shooter shooter = new Shooter();
    // Test (This one should work!!)



    public RobotContainer() {
        drivetrain.setDefaultCommand(new DriverLooped(drivetrain, driverController));
        configureBindings();
    }

    private void configureBindings() {
        //Config for the Tank Drivetrain

        //Config for the Shooter
        new JoystickButton(driverController, Button.kRightBumper.value).whileTrue(new ShootCommand(shooter));
        new JoystickButton(driverController, Button.kLeftBumper.value).whileTrue(new IntakeCommand(shooter));
    }
}
