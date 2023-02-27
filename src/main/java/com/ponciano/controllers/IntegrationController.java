package com.ponciano.controllers;

import com.ponciano.controllers.dto.IntegrationDTO;
import com.ponciano.models.entity.Integration;
import com.ponciano.services.IntegrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("integration")
@CrossOrigin(origins = "http://localhost:8080")
public class IntegrationController {

    private IntegrationService integrationService;

    public IntegrationController(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    @PostMapping("/")
    public IntegrationDTO saveIntegration(@RequestBody IntegrationDTO integrationDTO) {
        Integration result = integrationService.save(integrationDTO.toModel());
        return new IntegrationDTO(result);
    }

    @GetMapping("/{id}")
    public IntegrationDTO getIntegrationById(@PathVariable("id") Integer id) {
        Integration result = integrationService.getById(id);
        return new IntegrationDTO(result);
    }
}
