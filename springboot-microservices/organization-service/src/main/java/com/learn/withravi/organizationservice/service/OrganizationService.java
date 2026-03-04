package com.learn.withravi.organizationservice.service;

import com.learn.withravi.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    public OrganizationDto saveOrganization(OrganizationDto organizationDto);

    public OrganizationDto findByOrganizationCode(String organizationCode);
}
