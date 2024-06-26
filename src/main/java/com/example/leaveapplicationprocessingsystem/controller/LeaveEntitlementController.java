package com.example.leaveapplicationprocessingsystem.controller;

import com.example.leaveapplicationprocessingsystem.entity.LeaveApplication;
import com.example.leaveapplicationprocessingsystem.entity.LeaveEntitlement;
import com.example.leaveapplicationprocessingsystem.service.LeaveEntitlementService;
import com.example.leaveapplicationprocessingsystem.service.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveEntitlementController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private LeaveEntitlementService leaveEntitlementService;

    @GetMapping("/leave-entitlement/edit")
    public String index(HttpSession session, Model model) {
        model.addAttribute("firstName", session.getAttribute("firstName"));
        model.addAttribute("lastName", session.getAttribute("lastName"));

        // Get role name by role ID
        // 通过角色 ID 获取角色名称
        String roleName = roleService.getRoleNameByRoleId((Integer) session.getAttribute("roleId")).getRoleName();

        // Add the role name to the model
        // 将角色名称添加到模型中
        model.addAttribute("roleName", roleName);

        model.addAttribute("roles", roleService.getAllRoles());

        model.addAttribute("leaveEntitlements", leaveEntitlementService.getAllLeaveEntitlements());

        return "leave-entitlement/edit";
    }

    @PostMapping("/leave-entitlement/update")
    // ModelAttribute: Bind the form data to the LeaveApplication object
    // ModelAttribute：将表单数据绑定到  LeaveApplication对象
    public String update(@ModelAttribute LeaveEntitlement leaveEntitlement) {
        //  Save the leave application
        //  保存请假申请
        leaveEntitlementService.store(leaveEntitlement);

        //  Redirect to the home page
        //  重定向到主页
        return "redirect:/dashboard";
    }
}
