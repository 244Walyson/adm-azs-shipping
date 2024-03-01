package com.waly.azShipMongo.Adapter.config;

import com.waly.azShipMongo.Adapter.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.repositories.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void init(){

        clientRepository.deleteAll();

        ClientEntity maria = new ClientEntity(null, "Maria Brown", "maria@gmail.com", "31945654323", "4356476543");
        ClientEntity joao = new ClientEntity(null, "Joao Tranportes LTDA", "joao@gmail.com", "31935234", "426252452");
        ClientEntity alex = new ClientEntity(null, "Alex Grey LTDA", "alex@gmail.com", "31944252344", "34634524552");

        clientRepository.saveAll(Arrays.asList(maria, joao, alex));
    }
}
