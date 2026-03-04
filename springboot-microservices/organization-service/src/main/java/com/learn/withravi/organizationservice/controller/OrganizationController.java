package com.learn.withravi.organizationservice.controller;

import com.learn.withravi.organizationservice.dto.OrganizationDto;
import com.learn.withravi.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto organizationDtoSaved = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(organizationDtoSaved, HttpStatus.CREATED);
    }

    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode) {
        OrganizationDto organizationDto = organizationService.findByOrganizationCode(organizationCode);

        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
