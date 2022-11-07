// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
}

