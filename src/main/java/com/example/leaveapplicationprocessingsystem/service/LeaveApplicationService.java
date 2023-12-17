package com.example.leaveapplicationprocessingsystem.service;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface LeaveApplicationService {
    // Find the leave application by id
    // 通过 id 查找请假申请
    List<LeaveApplication> findAllByUserId(Integer userId);

    // Store the leave application
    // 存储请假申请
    LeaveApplication store(LeaveApplication leaveApplication);
}