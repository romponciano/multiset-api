package com.ponciano.services;

import com.ponciano.models.entity.Integration;
import com.ponciano.repositories.IntegrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrationServiceImpl implements IntegrationService {

    private IntegrationRepository repository;

    @Autowired
    public IntegrationServiceImpl(IntegrationRepository integrationRepository) {
        this.repository = integrationRepository;
    }

    @Override
    public Integration save(Integration integration) {
        return repository.save(integration);
    }

    @Override
    public Integration getById(Integer id) {
        return repository.findById(id).orElseThrow();
    }
}
