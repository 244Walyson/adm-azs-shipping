package com.waly.azShipMongo.Adapter.config;

import com.waly.azShipMongo.Adapter.model.embedded.ClientEmbedded;
import com.waly.azShipMongo.Adapter.model.embedded.PropertyEmbedded;
import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import com.waly.azShipMongo.Adapter.model.entities.ShipEntity;
import com.waly.azShipMongo.Adapter.repositories.ClientRepository;
import com.waly.azShipMongo.Adapter.repositories.ShipRepository;
import com.waly.azShipMongo.domain.ShipStatus;
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
    @Autowired
    private ShipRepository shipRepository;

    @PostConstruct
    public void init(){

        clientRepository.deleteAll();
        shipRepository.deleteAll();

        ClientEntity maria = new ClientEntity(null, "Maria Brown", "maria@gmail.com", "31945654323", "4356476543", null);
        ClientEntity joao = new ClientEntity(null, "Joao Tranportes LTDA", "joao@gmail.com", "31935234", "426252452", null);
        ClientEntity alex = new ClientEntity(null, "Alex Grey LTDA", "alex@gmail.com", "31944252344", "34634524552", null);

        clientRepository.saveAll(Arrays.asList(maria, joao, alex));

        ShipEntity ship1 = new ShipEntity(null, null, "descriçao", ShipStatus.ENVIADA, new ClientEmbedded(maria), null);

        PropertyEmbedded p1 = new PropertyEmbedded("cubagem", 5000.00);
        PropertyEmbedded p2 = new PropertyEmbedded("peso", 10000.00);

        ship1.setProperties(Arrays.asList(p1, p2));


        shipRepository.save(ship1);
    }
}
