/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class flyWheel extends Subsystem {
  
  public static TalonSRX flyWheel;
  
  public flyWheel() {
    flyWheel = new TalonSRX(RobotMap.kFlyWheel);
    flyWheel.setInverted(true);
  }

  public void setPower(double power){
    flyWheel.set(ControlMode.PercentOutput, -power);
  }

  public void resetEnc(){
    flyWheel.setSelectedSensorPosition(0);
  }
  public double getEncValue(){
    return flyWheel.getSelectedSensorPosition();
  }

  public void reportToSmardashboard(){
    SmartDashboard.putNumber("encoder value", getEncValue());
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
