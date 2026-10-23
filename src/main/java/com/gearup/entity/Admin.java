package com.gearup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private Long adminId;

    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String adminRole;
    private String status;

    public Admin() {
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
