package com.waly.desafioaz.repositories;

import com.waly.desafioaz.entities.Ship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {


    @Query("""
            SELECT obj FROM Ship obj
            JOIN FETCH  obj.client c
            LEFT JOIN FETCH obj.properties p
             WHERE
                LOWER(CAST(obj.id AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(obj.createdAt AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(obj.description AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(obj.status AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(c.name AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(c.email AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(c.phone AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(c.cnpj AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(c.id AS string)) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(CAST(p.name AS string)) LIKE LOWER(CONCAT('%', :param ,'%'))
                """)
    Page<Ship> findAllByAttributes(@Param("param") String param, Pageable pageable);


    @Query("""
            SELECT obj FROM Ship obj
            JOIN FETCH obj.client c
            LEFT JOIN FETCH obj.properties p
            WHERE obj.id = :shipId
            """)
    Optional<Ship> findByIdWithProperties(@Param("shipId") Long shipId);

}
