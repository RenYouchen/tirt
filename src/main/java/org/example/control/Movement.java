package org.example.control;

import org.example.Constants;
import org.example.motor.Motor;

public class Movement {
    static Motor leftMotor = new Motor();
    static Motor rightMotor = new Motor();
    public static void Init() {
        leftMotor = new Motor(Constants.Motor_Left_IN1, Constants.Motor_Left_IN2, Constants.Motor_Left_PWM);
        rightMotor = new Motor(Constants.Motor_Right_IN3, Constants.Motor_Right_IN4, Constants.Motor_Right_PWM);

        leftMotor.set(0);
        rightMotor.set(0);
    }
    public static void Forward () {
        Forward(Constants.Default_Speed);
    }
    public static void Backward () {
        Backward(Constants.Default_Speed);
    }
    public static void TurnLeft () {
        TurnLeft(Constants.Default_Speed);
    }
    public static void TurnRight () {
        TurnRight(Constants.Default_Speed);
    }

    public static void Forward (double speed) {
        leftMotor.set(speed);
        rightMotor.set(speed);
    }
    public static void Backward (double speed) {
        leftMotor.set(-speed);
        rightMotor.set(-speed);
    }
    public static void TurnLeft (double speed) {
        leftMotor.set(speed);
        rightMotor.set(-speed);
    }
    public static void TurnRight (double speed) {
        leftMotor.set(-speed);
        rightMotor.set(speed);
    }
}
