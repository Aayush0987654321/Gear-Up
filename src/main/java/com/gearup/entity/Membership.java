package com.gearup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Membership {

    @Id
    private Long membershipId;

    private String membershipType;
    private Double membershipFee;
    private Double discountPercentage;
    private String benefits;
    private String status;

    public Membership() {
    }

    public Long getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public Double getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(Double membershipFee) {
        this.membershipFee = membershipFee;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}