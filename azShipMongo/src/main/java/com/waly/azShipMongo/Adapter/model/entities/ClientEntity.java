package com.waly.azShipMongo.Adapter.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "clients")
public class ClientEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String cnpj;
    @DBRef(lazy = true)
    private List<ShipEntity> ships;
}
