package com.example.leaveapplicationprocessingsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Integer employeeId;

    @Column(name="user_id", insertable=false, updatable=false)
    private Integer userId;

    @Column(name="manager_id", insertable=false, updatable=false)
    private Integer managerId;

    @Column(name="annual_leave_days_used")
    private Integer annualLeaveDaysUsed;

    @Column(name="medical_leave_days_used")
    private Integer medicalLeaveDaysUsed;

    @ManyToOne
    @JoinColumn(name="manager_id")
    private Manager manager;

    public Employee() {}

    public Employee(Integer employeeId,
                    Integer userId,
                    Integer managerId,
                    Integer annualLeaveDaysUsed,
                    Integer medicalLeaveDaysUsed) {
        this.employeeId = employeeId;
        this.userId = userId;
        this.managerId = managerId;
        this.annualLeaveDaysUsed = annualLeaveDaysUsed;
        this.medicalLeaveDaysUsed = medicalLeaveDaysUsed;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getManagerId() { return managerId; }

    public void setManagerId(Integer managerId) { this.managerId = managerId; }

    public Integer getAnnualLeaveDaysUsed() {
        return annualLeaveDaysUsed;
    }

    public void setAnnualLeaveDaysUsed(Integer annualLeaveDaysUsed) {
        this.annualLeaveDaysUsed = annualLeaveDaysUsed;
    }

    public Integer getMedicalLeaveDaysUsed() {
        return medicalLeaveDaysUsed;
    }

    public void setMedicalLeaveDaysUsed(Integer medicalLeaveDaysUsed) {
        this.medicalLeaveDaysUsed = medicalLeaveDaysUsed;
    }
}
