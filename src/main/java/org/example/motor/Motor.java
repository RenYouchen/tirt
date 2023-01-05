package org.example.motor;

import com.pi4j.io.gpio.*;
import org.example.Constants;

public class Motor {
    private final GpioController gpio;
    private GpioPinPwmOutput PWMPin;
    private GpioPinDigitalOutput PinA, PinB;

    public Motor() {
        gpio = GpioFactory.getInstance();
    }

    public Motor(int PinA, int PinB, int PWMPinNumber) {
        gpio = GpioFactory.getInstance();
        setPinA(PinA);
        setPinB(PinB);
        setPWMPin(PWMPinNumber);
    }

    public void setPinA(int pinA) {
        PinA = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(pinA));
    }

    public void setPinB(int pinB) {
        PinB = gpio.provisionDigitalOutputPin(RaspiPin.getPinByAddress(pinB));
    }

    public void setPWMPin(int PWMPinNumber) {
        PWMPin = gpio.provisionPwmOutputPin(RaspiPin.getPinByAddress(PWMPinNumber));
    }

    public void set(double speed) {
        int PWM;
        if (speed < 0) {
            PWM = (int) (Math.abs(speed) * Constants.PWM_MAX);
            //System.out.printf("PWM is %d \n",PWM);
            setPWM(PWM);
            setReverse();
        } else {
            PWM = (int) (Math.abs(speed) * Constants.PWM_MAX);
            //System.out.printf("PWM is %d \n",PWM);
            setPWM(PWM);
            setForward();
        }
    }

    public void setPWM(int pwm) {
        PWMPin.setPwm(pwm);
    }

    private void setForward() {
        //System.out.println("setForward");
        PinA.low();
        PinB.high();
    }

    private void setReverse() {
        //System.out.println("setReverse");
        PinA.high();
        PinB.low();
    }

    private void toggle(){
        PinA.toggle();
        PinB.toggle();
    }
}
