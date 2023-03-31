package com.gcu.data;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.OrderEntity;

public interface RegistrationRepositoryInterface extends CrudRepository<OrderEntity, Long> {
    
    
}
