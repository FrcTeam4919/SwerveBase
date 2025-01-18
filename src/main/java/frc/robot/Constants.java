// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

//import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.config.SwerveModuleConstants;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class SwerveConstants {
    public static final double gearRatio1st = 14/50;
    public static final double gearRatio2nd = 27/17;
    public static final double gearRatio3rd = 15/45;
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4); // meters

    public static final double kDrivingEncoderPositionFactor = kWheelDiameterMeters/(gearRatio1st*gearRatio2nd*gearRatio3rd);
    public static final double kDrivingEncoderVelocityFactor = kDrivingEncoderPositionFactor/60; // meters per second

    //public static final double kturnGearRatio = 14/50;
    public static final double kturnGearRatio = 12.8/1;
    public static final double kTurningEncoderPositionFactor = (2 * Math.PI) / kturnGearRatio; //position in radians
    public static final double kTurningEncoderVelocityFactor = kTurningEncoderPositionFactor/60; // meters per second
    
    public static final double driveGainP = 0.01;
    public static final double driveGainI = 0;
    public static final double driveGainD = 0;

    public static final double turnGainP = 0.01;
    public static final double turnGainI = 0;
    public static final double turnGainD = 0;

    public static final double kAngleEncoderResolution = 42;
    public static final boolean kTurningEncoderInverted = true;
    public static final double kTurningMinOutput = -1;
    public static final double kTurningMaxOutput = 1;
    public static final double kTurningEncoderPositionPIDMinInput = -1;
    public static final double kTurningEncoderPositionPIDMaxInput = 1;
  }

  public static class DriveConstants {
    public static final double robotWidth = Units.inchesToMeters(37);
    public static final double robotLength = Units.inchesToMeters(37);
    public static final double WheelYdist = robotLength*0.5;
    public static final double WheelXdist = robotWidth*0.5;

    // encoder angluar offset in Radians
    public static final double kFrontLeftChassisAngularOffset = 0.005615*Math.PI; 
    public static final double kFrontRightChassisAngularOffset = -0.462891*Math.PI;
    public static final double kBackLeftChassisAngularOffset = -0.065918*Math.PI;
    public static final double kBackRightChassisAngularOffset = 0.177002*Math.PI;

    public static final double kChassisAngularOffset = 0;

    /*public static final SwerveDriveKinematics kswerveDriveKinematics = new SwerveDriveKinematics(
      new Translation2d(WheelXdist, WheelYdist),
      new Translation2d(WheelXdist, -WheelYdist),
      new Translation2d(-WheelXdist, WheelYdist),
      new Translation2d(-WheelXdist, -WheelYdist));*/

    public static final double kMaxSpeed = 5;
    public static final double kMaxAngularSpeed = 1;
    public static final boolean kTeleField = false;
  }

public static class ControlSystem {
    // Driving motor CAN IDs
    public static final int kLeftFrontDrive = 2;
    public static final int kLeftBackDrive = 4;
    public static final int kRightFrontDrive = 1;
    public static final int kRightBackDrive = 3;
    // Turning motors
    public static final int kLeftFrontTurn = 10;
    public static final int kLeftBackTurn = 9;
    public static final int kRightFrontTurn = 11;
    public static final int kRightBackTurn = 12;
    // CANCoder Can IDs for tunring encoders
    public static final int kLFturn = 13;
    public static final int kLBturn = 16;
    public static final int kRFturn = 14;
    public static final int kRBturn = 15;
  }

  
    public static final class Swerve {
      public static final double stickDeadband = 0.1;
  
      public static final int pigeonID = 6;
      public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-
  
      /* Drivetrain Constants */
      public static final double trackWidth = Units.inchesToMeters(21.73);
      public static final double wheelBase = Units.inchesToMeters(21.73);
      public static final double wheelDiameter = Units.inchesToMeters(4.0);
      public static final double wheelCircumference = wheelDiameter * Math.PI;
  
      public static final double openLoopRamp = 0.25;
      public static final double closedLoopRamp = 0.0;
  
      public static final double driveGearRatio = (6.75 / 1.0); // 6.75:1
      public static final double angleGearRatio = (12.8 / 1.0); // 12.8:1
  
      public static final SwerveDriveKinematics swerveKinematics =
          new SwerveDriveKinematics(
              new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
              new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
              new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
              new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));
  
      /* Swerve Voltage Compensation */
      public static final double voltageComp = 12.0;
  
      /* Swerve Current Limiting */
      public static final int angleContinuousCurrentLimit = 20;
      public static final int driveContinuousCurrentLimit = 80;
  
      /* Angle Motor PID Values */
      public static final double angleKP = 0.01;
      public static final double angleKI = 0.0;
      public static final double angleKD = 0.0;
      public static final double angleKFF = 0.0;
  
      /* Drive Motor PID Values */
      public static final double driveKP = 0.1;
      public static final double driveKI = 0.0;
      public static final double driveKD = 0.0;
      public static final double driveKFF = 0.0;
  
      /* Drive Motor Characterization Values */
      public static final double driveKS = 0.667;
      public static final double driveKV = 2.44;
      public static final double driveKA = 0.27;
  
      /* Drive Motor Conversion Factors */
      public static final double driveConversionPositionFactor =
          (wheelDiameter * Math.PI) / driveGearRatio;
      public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60.0;
      public static final double angleConversionFactor = 360.0 / angleGearRatio;
  
      /* Swerve Profiling Values */
      public static final double maxSpeed = 4.5; // meters per second
      public static final double maxAngularVelocity = 11.5;
  
      /* Neutral Modes */
      //public static final IdleMode angleNeutralMode = IdleMode.kBrake;
      //public static final IdleMode driveNeutralMode = IdleMode.kBrake;
  
      /* Motor Inverts */
      public static final boolean driveInvert = false;
      public static final boolean angleInvert = false;
  
      /* Angle Encoder Invert */
      public static final boolean canCoderInvert = false;
  
      /* Module Specific Constants */
      /* Front Left Module - Module 0 */
      public static final class Mod0 {
        public static final int driveMotorID = 4;
        public static final int angleMotorID = 3;
        public static final int canCoderID = 1;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(327.48046875);
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
      }
  
      /* Front Right Module - Module 1 */
      public static final class Mod1 {
        public static final int driveMotorID = 14;
        public static final int angleMotorID = 13;
        public static final int canCoderID = 2;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(286.34765625);
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
      }
  
      /* Back Left Module - Module 2 */
      public static final class Mod2 {
        public static final int driveMotorID = 2;
        public static final int angleMotorID = 1;
        public static final int canCoderID = 3;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(55.01953125);
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
      }
  
      /* Back Right Module - Module 3 */
      public static final class Mod3 {
        public static final int driveMotorID = 15;
        public static final int angleMotorID = 16;
        public static final int canCoderID = 4;
        public static final Rotation2d angleOffset = Rotation2d.fromDegrees(67.939453125);
        public static final SwerveModuleConstants constants =
            new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
      }
    }
  
    public static final class AutoConstants {
      public static final double kMaxSpeedMetersPerSecond = 3;
      public static final double kMaxAccelerationMetersPerSecondSquared = 3;
      public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
      public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
  
      public static final double kPXController = 1;
      public static final double kPYController = 1;
      public static final double kPThetaController = 1;
  
      // Constraint for the motion profilied robot angle controller
      public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
          new TrapezoidProfile.Constraints(
              kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }
    
}
