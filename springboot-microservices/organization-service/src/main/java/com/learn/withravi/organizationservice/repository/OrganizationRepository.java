package com.learn.withravi.organizationservice.repository;

import com.learn.withravi.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    public Organization findByOrganizationCode(String organizationCode);
}
