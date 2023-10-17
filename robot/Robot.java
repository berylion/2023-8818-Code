// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// importing our command class



/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  
  Victor frontLeft = new Victor(2);
  Victor frontRight = new Victor(1);
  Victor rearLeft = new Victor(3);
  Victor rearRight = new Victor(0);
  PWMSparkMax catapult = new PWMSparkMax(5);


 
   
    

  


  private Command m_autonomousCommand;



  @Override



  public void robotInit() {

    

// assign motors to their ports
  CameraServer.startAutomaticCapture(); 

  }


  @Override
  public void robotPeriodic() {
 
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = null;

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }


    // schedule the autonomous command (example)
  
  
  

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
   
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    

   
    XboxController controller = new XboxController(0);

    
 

    if(controller.getLeftBumper()){

      frontLeft.set(-1);
      rearLeft.set(1);
      rearLeft.setInverted(true);
      frontRight.set(-1);
      frontRight.setInverted(true);
      rearRight.set(1);
      
       
      } else if(controller.getRightBumper()){
        
        frontLeft.set(1);
        rearLeft.set(-1);
        frontLeft.setInverted(true);
        frontRight.set(1);
        rearRight.setInverted(true);
        rearRight.set(-1);
        
      } else {
      frontLeft.set(controller.getLeftY());
      rearLeft.set(controller.getLeftY());
      frontRight.set(-controller.getRightY());
      rearRight.set(-controller.getRightY());

      }
  
    if(controller.getAButtonPressed());{
      catapult.set(1);
      catapult.setInverted(true);
    }





  }
    
  

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
  
