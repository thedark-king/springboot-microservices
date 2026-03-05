package com.learn.withravi.organizationservice.controller;

import com.learn.withravi.organizationservice.dto.OrganizationDto;
import com.learn.withravi.organizationservice.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "Organization Controller",
    description = "APIs for managing organizations" 
)
@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Operation(
        summary = "Save Organization REST API",
        description = "Save Organization REST API is used to save organization into database"
    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {

        OrganizationDto organizationDtoSaved = organizationService.saveOrganization(organizationDto);

        return new ResponseEntity<>(organizationDtoSaved, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Get Organization REST API",
        description = "Get Organization REST API is used to get organization from database"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/{organizationCode}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode) {
        OrganizationDto organizationDto = organizationService.findByOrganizationCode(organizationCode);

        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }
}
