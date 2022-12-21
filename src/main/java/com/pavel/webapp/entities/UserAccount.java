package com.pavel.webapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity(name = "user_accounts")
public class UserAccount extends BaseEntity {
    Collection<JobOffer> appliedJobOffers;
    private String username;
    private String password;
    private String email;
    private boolean isCompany;

    @OneToMany
    @JoinColumn(name = "user_id")
    public Collection<JobOffer> getAppliedJobOffers() {
        return appliedJobOffers;
    }

    public void setAppliedJobOffers(Collection<JobOffer> appliedJobOffers) {
        this.appliedJobOffers = appliedJobOffers;
    }

    @Column(name = "is_company")
    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "username", nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
