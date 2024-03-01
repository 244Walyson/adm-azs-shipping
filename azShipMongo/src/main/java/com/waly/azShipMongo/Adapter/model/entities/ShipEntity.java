package com.waly.azShipMongo.Adapter.model.entities;

import com.waly.azShipMongo.Adapter.model.embedded.ClientEmbedded;
import com.waly.azShipMongo.Adapter.model.embedded.PropertyEmbedded;
import com.waly.azShipMongo.domain.ShipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "ship")
public class ShipEntity {

    @Id
    private String id;
    private Instant createdAt;
    private String description;
    private ShipStatus status;
    private ClientEmbedded client;
    private List<PropertyEmbedded> properties = new ArrayList<>();

}
