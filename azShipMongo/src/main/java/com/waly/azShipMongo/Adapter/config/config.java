package com.waly.azShipMongo.Adapter.config;

import com.waly.azShipMongo.domain.Ship;
import com.waly.azShipMongo.domain.ports.ClientRepositoryPort;
import com.waly.azShipMongo.domain.ports.ClientServicePort;
import com.waly.azShipMongo.domain.ports.ShipRepositoryPort;
import com.waly.azShipMongo.domain.ports.ShipServicePort;
import com.waly.azShipMongo.domain.services.ClientService;
import com.waly.azShipMongo.domain.services.ShipService;
import graphql.GraphQL;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class config {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ShipServicePort shipServicePort(ShipRepositoryPort repositoryPort){
        return new ShipService(repositoryPort);
    }
    @Bean
    public ClientServicePort clientServicePort(ClientRepositoryPort repositoryPort){
        return new ClientService(repositoryPort);
    }

}
