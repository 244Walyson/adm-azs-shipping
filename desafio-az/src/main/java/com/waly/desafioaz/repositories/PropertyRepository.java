package com.waly.desafioaz.repositories;

import com.waly.desafioaz.entities.Property;
import com.waly.desafioaz.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
