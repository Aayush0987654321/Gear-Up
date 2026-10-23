package com.gearup.service;

import com.gearup.entity.Membership;
import com.gearup.repository.MembershipRepository;
import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public Membership saveMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public java.util.List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Membership getMembershipById(Long id) {
        return membershipRepository.findById(id).orElse(null);
    }

    public Membership updateMembership(Long id, Membership membership) {
        membership.setMembershipId(id);
        return membershipRepository.save(membership);
    }

    public void deleteMembership(Long id) {
        membershipRepository.deleteById(id);
    }
}