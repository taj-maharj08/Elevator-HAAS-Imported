package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{
    private final CANSparkMax m_leftMotor, m_rightMotor;
    private final double kDriveSpeed = 0.5;

    public Elevator() {
        m_leftMotor = new CANSparkMax(0, MotorType.kBrushless);
        m_rightMotor = new CANSparkMax(1, MotorType.kBrushless);
        setDefaultCommand(idle());
    }
    public Command extend() {
        return this.run(() -> {
            m_leftMotor.set(kDriveSpeed);
            m_rightMotor.set(kDriveSpeed);
        }).withName("extend");
    }
    public Command idle() {
        return this.run(() -> {
            m_leftMotor.set(0);
            m_rightMotor.set(0);
        }).withName("idle");
    }
    public Command retract() {
        return this.run(() -> {
            m_leftMotor.set(-kDriveSpeed);
            m_rightMotor.set(-kDriveSpeed);
        }).withName("retract");
    }
}
