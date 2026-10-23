package com.gearup.service;

import com.gearup.entity.Admin;
import com.gearup.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public java.util.List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Long id, Admin admin) {
        admin.setAdminId(id);
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}