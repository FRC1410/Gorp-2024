// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import java.awt.*;

public class RobotContainer {
    private final XboxController driverController = new XboxController(0);

    // Test (This one should work!!)

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {

    }
}
