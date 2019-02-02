/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.FLyWheel;
import frc.robot.commands.OpenLoop;
import frc.robot.commands.ResetEncoders;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  public OI(){
    SmartDashboard.putData("flywheel", new FLyWheel(1000));
    SmartDashboard.putData("reset Incoders", new ResetEncoders());
    SmartDashboard.putData("set power .3", new OpenLoop());
    
  }
}
