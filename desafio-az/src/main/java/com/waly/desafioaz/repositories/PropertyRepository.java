package com.waly.desafioaz.repositories;

import com.waly.desafioaz.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
