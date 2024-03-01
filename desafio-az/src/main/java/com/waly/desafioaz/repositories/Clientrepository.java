package com.waly.desafioaz.repositories;


import com.waly.desafioaz.entities.Client;
import com.waly.desafioaz.entities.Ship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Clientrepository extends JpaRepository<Client, Long> {

    @Query("""
            SELECT obj FROM Client obj
            JOIN FETCH obj.ships
            WHERE
                LOWER(obj.name) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(obj.email) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(obj.phone) LIKE LOWER(CONCAT('%', :param ,'%')) OR
                LOWER(obj.cnpj) LIKE LOWER(CONCAT('%', :param ,'%'))
            """)
    Page<Client> findAllByParam(@Param("param") String param, Pageable pageable);
}
