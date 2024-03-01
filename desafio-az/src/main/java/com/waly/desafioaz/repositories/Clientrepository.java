package com.waly.desafioaz.repositories;


import com.waly.desafioaz.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientrepository extends JpaRepository<Client, Long> {
}
