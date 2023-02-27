package com.ponciano.services;

import com.ponciano.models.entity.Integration;

public interface IntegrationService {
    Integration save(Integration integration);

    Integration getById(Integer id);
}
