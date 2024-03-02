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

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ShipRepository shipRepository;

    @PostConstruct
    public void init() {
        clientRepository.deleteAll();
        shipRepository.deleteAll();

        // Clientes
        ClientEntity maria = new ClientEntity(null, "Maria Brown", "maria@gmail.com", "31945654323", "4356476543", null);
        ClientEntity joao = new ClientEntity(null, "Joao Tranportes LTDA", "joao@gmail.com", "31935234", "426252452", null);
        ClientEntity alex = new ClientEntity(null, "Alex Grey LTDA", "alex@gmail.com", "31944252344", "34634524552", null);

        clientRepository.saveAll(Arrays.asList(maria, joao, alex));

        // Envios
        ShipEntity ship1 = new ShipEntity(null, Instant.now(), "descrição 1", ShipStatus.ENVIADA, new ClientEmbedded(maria), null);
        ShipEntity ship2 = new ShipEntity(null, Instant.now(), "descrição 2", ShipStatus.AGUARDANDO_PAGAMENTO, new ClientEmbedded(joao), null);
        ShipEntity ship3 = new ShipEntity(null, Instant.now(), "descrição 3", ShipStatus.ENTREGUE, new ClientEmbedded(alex), null);
        ShipEntity ship4 = new ShipEntity(null, Instant.now(), "descrição 4", ShipStatus.ENVIADA, new ClientEmbedded(maria), null);
        ShipEntity ship5 = new ShipEntity(null, Instant.now(), "descrição 5", ShipStatus.AGUARDANDO_PAGAMENTO, new ClientEmbedded(joao), null);
        ShipEntity ship6 = new ShipEntity(null, Instant.now(), "descrição 6", ShipStatus.ENTREGUE, new ClientEmbedded(alex), null);
        ShipEntity ship7 = new ShipEntity(null, Instant.now(), "descrição 7", ShipStatus.ENVIADA, new ClientEmbedded(maria), null);
        ShipEntity ship8 = new ShipEntity(null, Instant.now(), "descrição 8", ShipStatus.AGUARDANDO_PAGAMENTO, new ClientEmbedded(joao), null);
        ShipEntity ship9 = new ShipEntity(null, Instant.now(), "descrição 9", ShipStatus.ENTREGUE, new ClientEmbedded(alex), null);
        ShipEntity ship10 = new ShipEntity(null, Instant.now(), "descrição 10", ShipStatus.ENVIADA, new ClientEmbedded(maria), null);

        // Propriedades
        PropertyEmbedded p1 = new PropertyEmbedded("cubagem", 5000.00);
        PropertyEmbedded p2 = new PropertyEmbedded("peso", 10000.00);
        ship1.setProperties(Arrays.asList(p1, p2));

        PropertyEmbedded p3 = new PropertyEmbedded("cubagem", 6000.00);
        PropertyEmbedded p4 = new PropertyEmbedded("peso", 12000.00);
        ship2.setProperties(Arrays.asList(p3, p4));

        PropertyEmbedded p5 = new PropertyEmbedded("cubagem", 7000.00);
        PropertyEmbedded p6 = new PropertyEmbedded("peso", 15000.00);
        ship3.setProperties(Arrays.asList(p5, p6));

        PropertyEmbedded p7 = new PropertyEmbedded("cubagem", 4500.00);
        PropertyEmbedded p8 = new PropertyEmbedded("peso", 9000.00);
        ship4.setProperties(Arrays.asList(p7, p8));

        PropertyEmbedded p9 = new PropertyEmbedded("cubagem", 5500.00);
        PropertyEmbedded p10 = new PropertyEmbedded("peso", 11000.00);
        ship5.setProperties(Arrays.asList(p9, p10));

        PropertyEmbedded p11 = new PropertyEmbedded("cubagem", 6500.00);
        PropertyEmbedded p12 = new PropertyEmbedded("peso", 13000.00);
        ship6.setProperties(Arrays.asList(p11, p12));

        PropertyEmbedded p13 = new PropertyEmbedded("cubagem", 7500.00);
        PropertyEmbedded p14 = new PropertyEmbedded("peso", 16000.00);
        ship7.setProperties(Arrays.asList(p13, p14));

        PropertyEmbedded p15 = new PropertyEmbedded("cubagem", 4800.00);
        PropertyEmbedded p16 = new PropertyEmbedded("peso", 9500.00);
        ship8.setProperties(Arrays.asList(p15, p16));

        PropertyEmbedded p17 = new PropertyEmbedded("cubagem", 5800.00);
        PropertyEmbedded p18 = new PropertyEmbedded("peso", 11500.00);
        ship9.setProperties(Arrays.asList(p17, p18));

        PropertyEmbedded p19 = new PropertyEmbedded("cubagem", 6800.00);
        PropertyEmbedded p20 = new PropertyEmbedded("peso", 14000.00);
        ship10.setProperties(Arrays.asList(p19, p20));

        shipRepository.saveAll(Arrays.asList(ship1, ship2, ship3, ship4, ship5, ship6, ship7, ship8, ship9, ship10));
    }
}
