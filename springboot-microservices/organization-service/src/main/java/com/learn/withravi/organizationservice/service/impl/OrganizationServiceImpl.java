package com.learn.withravi.organizationservice.service.impl;

import com.learn.withravi.organizationservice.dto.OrganizationDto;
import com.learn.withravi.organizationservice.entity.Organization;
import com.learn.withravi.organizationservice.mapper.OrganizationMapper;
import com.learn.withravi.organizationservice.repository.OrganizationRepository;
import com.learn.withravi.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization organizationSaved = organizationRepository.save(organization);

        OrganizationDto organizationDtoSaved = OrganizationMapper.mapToOrganizationDto(organizationSaved);

        return organizationDtoSaved;
    }

    @Override
    public OrganizationDto findByOrganizationCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);

        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);

        return organizationDto;
    }

}
