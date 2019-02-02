/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.constants.constants;
// import frc.robot.subsystems.flyWheel;
import edu.wpi.first.wpilibj.Timer;
// import timer

public class FLyWheel extends Command {

  public double m_output;
  public double m_desiredDis;
  public double m_oldError, m_newError;
  public double m_oldTime, m_newTime;
  public double m_d;

  public FLyWheel(double desiredDis) {
    m_desiredDis = desiredDis;
    requires(Robot.m_flyWheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Robot.m_flyWheel.resetEnc();
    m_newError = m_desiredDis;
    m_newTime = Timer.getFPGATimestamp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_newTime = Timer.getFPGATimestamp();
    m_newError = m_desiredDis - Robot.m_flyWheel.getEncValue();
    m_d = (m_oldError - m_newError)/(m_oldTime - m_newTime);

    m_output = constants.kP * m_newError + constants.kD * m_d;

    Robot.m_flyWheel.setPower(m_output);

    m_oldError = m_newError;
    m_newTime = m_oldTime;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(m_newError) <= constants.tolerance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_flyWheel.setPower(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
