// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final static class CAN {
       
        public static final int kFrontLeft = 0;
        public static final int kBackLeft = 1;
        public static final int kBackRight = 2;
        public static final int kFrontRight = 3;
        
    }

    public static final class Lift {
        
        public static final int kLeft = 4;
        public static final int kRight = 5;

        public static final double kUp = 0.8;
        public static final double kDown = -0.8;

    }

    public static final class Intake {

        public static final int kIntake = 6;

        public static final double kForward = 1;
        public static final double kBackward = -1;
        
    }

    public static final class Shooter {

        public static final int kShooter = 8;

        public static final double kShootSpeed = 0.8;

    }

    public static final class Kicker {

        public static final int kKicker = 7;

        public static final double kKickSpeed = 0.8;

    }

    public static class Field {

        public static final Translation2d RED_1 = new Translation2d(8.9, 8);
        public static final Translation2d RED_2 = new Translation2d(11.438, 6.383);
        public static final Translation2d RED_3 = new Translation2d(11.553, 2);
        public static final Translation2d RED_4 = new Translation2d(15.448, 7.123);

        public static final Translation2d BLUE_1 = new Translation2d(7.609, 0.303);
        public static final Translation2d BLUE_2 = new Translation2d(5.075, 1.881);
        public static final Translation2d BLUE_3 = new Translation2d(4.963, 6.2);
        public static final Translation2d BLUE_4 = new Translation2d(1.07, 1.141);

        public static final Pose2d RED_FENDER_1 = new Pose2d(8.792, 5.363, Rotation2d.fromDegrees(69));
        public static final Pose2d RED_FENDER_2 = new Pose2d(9.56, 3.656, Rotation2d.fromDegrees(-20.645));

        public static final Pose2d BLUE_FENDER_1 = new Pose2d(7.725, 2.768, Rotation2d.fromDegrees(-111.682));
        public static final Pose2d BLUE_FENDER_2 = new Pose2d(6.919, 4.7, Rotation2d.fromDegrees(-202.67));
        
    }
}

