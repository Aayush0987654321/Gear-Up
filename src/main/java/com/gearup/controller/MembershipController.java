package com.gearup.controller;

import com.gearup.entity.Membership;
import com.gearup.service.MembershipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PostMapping
    public Membership createMembership(@RequestBody Membership membership) {
        return membershipService.saveMembership(membership);
    }

    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @GetMapping("/{id}")
    public Membership getMembershipById(@PathVariable Long id) {
        return membershipService.getMembershipById(id);
    }

    @PutMapping("/{id}")
    public Membership updateMembership(@PathVariable Long id, @RequestBody Membership membership) {
        return membershipService.updateMembership(id, membership);
    }

    @DeleteMapping("/{id}")
    public String deleteMembership(@PathVariable Long id) {
        membershipService.deleteMembership(id);
        return "Membership deleted successfully";
    }
}