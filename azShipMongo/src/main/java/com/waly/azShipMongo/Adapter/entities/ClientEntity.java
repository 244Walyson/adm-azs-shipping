package com.waly.azShipMongo.Adapter.entities;

import com.waly.azShipMongo.domain.Ship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

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
}
